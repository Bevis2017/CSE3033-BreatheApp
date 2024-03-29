import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SummaryDaily extends JFrame {
    private Database db;
    private Token token = new Token ();


    //private static final long serialVersionUID = 1L;

    public SummaryDaily(String appTitle) {
        super(appTitle);

        setBounds(100, 100, 850, 480);
        setResizable(false);

        // Create Dataset
        CategoryDataset dataset = createDataset();

        //Create chart
        JFreeChart chart=ChartFactory.createBarChart(
                "Summary Daily", //Chart Title
                "Event Type", // Category axis
                "Amount", // Value axis
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false
        );

        ChartPanel panel=new ChartPanel(chart);
        setContentPane(panel);
        //panel.setMouseWheelEnabled(false);
    }

    private CategoryDataset createDataset() {
        final String daily = "DAILY";
        db = new Database();
        token.readToken();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String query = "SELECT COUNT(id) AS count FROM event WHERE type = '%s' AND createdBy = '%d' AND DATE(date) = CURDATE()";
        ResultSet dailyNone = db.query(String.format(query, "None", token.getUserId()));
        ResultSet dailyWork = db.query(String.format(query, "Work", token.getUserId()));
        ResultSet dailyLeisure = db.query(String.format(query, "Leisure", token.getUserId()));
        ResultSet dailyPriority = db.query(String.format(query, "Priority", token.getUserId()));

        try {
            dailyNone.next();
            dailyWork.next();
            dailyLeisure.next();
            dailyPriority.next();

            dataset.addValue(dailyNone.getInt("count"),"None", daily );
            dataset.addValue(dailyWork.getInt("count"), "Work", daily );
            dataset.addValue(dailyLeisure.getInt("count"), "Leisure", daily );
            dataset.addValue(dailyPriority.getInt("count"), "Priority", daily );

            int countNumber;
            countNumber = dailyNone.getInt("count") + dailyWork.getInt("count") +dailyLeisure.getInt("count") + dailyPriority.getInt("count");

            if (countNumber == 0){
                JOptionPane.showMessageDialog(null,"No event on today!","Amount of events", JOptionPane.PLAIN_MESSAGE);
            }else if (countNumber > 0 && countNumber <= 3){
                JOptionPane.showMessageDialog(null,"The total amount of activities on today: " + countNumber ,"Amount of events", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "The level of rush is low !" ,"Level of rush", JOptionPane.PLAIN_MESSAGE);
            } else if (countNumber > 3 && countNumber <= 6){
                JOptionPane.showMessageDialog(null,"The total amount of activities on today: " + countNumber ,"Amount of events", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "The level of rush is medium !" ,"Level of rush", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,"The total amount of activities on today: " + countNumber ,"Amount of events", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "The level of rush is high !" ,"Level of rush", JOptionPane.PLAIN_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return dataset;
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SummaryDaily frame = new SummaryDaily("Summary Activity");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}