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

public class SummaryWeekly extends JFrame {
    private Database db;
    private Token token = new Token ();


    //private static final long serialVersionUID = 1L;

    public SummaryWeekly(String appTitle) {
        super(appTitle);

        setBounds(100, 100, 850, 480);
        setResizable(false);

        // Create Dataset
        CategoryDataset dataset = createDataset();

        //Create chart
        JFreeChart chart=ChartFactory.createBarChart(
                "Summary Weekly", //Chart Title
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
        final String weekly = "WEEKLY";
        db = new Database();
        token.readToken();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String query = "SELECT COUNT(id) AS count FROM event WHERE type = '%s' AND createdBy = '%d' AND WEEK(date) = WEEK(CURRENT_DATE())";
        ResultSet weeklyNone = db.query(String.format(query, "None", token.getUserId()));
        ResultSet weeklyWork = db.query(String.format(query, "Work", token.getUserId()));
        ResultSet weeklyLeisure = db.query(String.format(query, "Leisure", token.getUserId()));
        ResultSet weeklyPriority = db.query(String.format(query, "Priority", token.getUserId()));

        try {
            weeklyNone.next();
            weeklyWork.next();
            weeklyLeisure.next();
            weeklyPriority.next();

            dataset.addValue(weeklyNone.getInt("count"),"None", weekly );
            dataset.addValue(weeklyWork.getInt("count"), "Work", weekly );
            dataset.addValue(weeklyLeisure.getInt("count"), "Leisure", weekly );
            dataset.addValue(weeklyPriority.getInt("count"), "Priority", weekly );

            int countNumber;
            countNumber = weeklyNone.getInt("count") + weeklyWork.getInt("count") + weeklyLeisure.getInt("count") + weeklyPriority.getInt("count");

            if (countNumber == 0){
                JOptionPane.showMessageDialog(null,"No event on this week!","Amount of events", JOptionPane.PLAIN_MESSAGE);
            }else if (countNumber > 0 && countNumber <= 10){
                JOptionPane.showMessageDialog(null,"The total amount of activities on this week: " + countNumber ,"Amount of events", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "The level of rush is low !" ,"Level of rush", JOptionPane.PLAIN_MESSAGE);
            } else if (countNumber > 10 && countNumber <= 15){
                JOptionPane.showMessageDialog(null,"The total amount of activities on this week: " + countNumber ,"Amount of events", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "The level of rush is medium !" ,"Level of rush", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,"The total amount of activities on this week: " + countNumber ,"Amount of events", JOptionPane.PLAIN_MESSAGE);
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
                    SummaryWeekly frame = new SummaryWeekly("Summary Activity");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}