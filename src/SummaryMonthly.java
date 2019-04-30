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

public class SummaryMonthly extends JFrame {
    private Database db;
    private Token token = new Token ();


    //private static final long serialVersionUID = 1L;

    public SummaryMonthly(String appTitle) {
        super(appTitle);

        setBounds(100, 100, 850, 480);
        setResizable(false);

        // Create Dataset
        CategoryDataset dataset = createDataset();

        //Create chart
        JFreeChart chart=ChartFactory.createBarChart(
                "Summary Monthly", //Chart Title
                "Event Type", // Category axis
                "Amount", // Value axis
                dataset,
                PlotOrientation.VERTICAL,
                true,true,false
        );

        ChartPanel panel=new ChartPanel(chart);
        //panel.setMouseWheelEnabled(false);
        setContentPane(panel);
    }

    private CategoryDataset createDataset() {
        final String monthly = "MONTHLY";
        db = new Database();
        token.readToken();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String query = "SELECT COUNT(id) AS count FROM event WHERE type = '%s' AND createdBy = '%d' AND MONTH(date) = MONTH(CURRENT_DATE())";
        ResultSet monthlyNone = db.query(String.format(query, "None", token.getUserId()));
        ResultSet monthlyWork = db.query(String.format(query, "Work", token.getUserId()));
        ResultSet monthlyLeisure = db.query(String.format(query, "Leisure", token.getUserId()));
        ResultSet monthlyPriority = db.query(String.format(query, "Priority", token.getUserId()));

        try {
            monthlyNone.next();
            monthlyWork.next();
            monthlyLeisure.next();
            monthlyPriority.next();

            dataset.addValue(monthlyNone.getInt("count"),"None", monthly );
            dataset.addValue(monthlyWork.getInt("count"), "Work", monthly );
            dataset.addValue(monthlyLeisure.getInt("count"), "Leisure", monthly );
            dataset.addValue(monthlyPriority.getInt("count"), "Priority", monthly );

            int countNumber;
            countNumber = monthlyNone.getInt("count") + monthlyWork.getInt("count") + monthlyLeisure.getInt("count") + monthlyPriority.getInt("count");

            if (countNumber == 0){
                JOptionPane.showMessageDialog(null,"No event on this month!","Amount of events", JOptionPane.PLAIN_MESSAGE);
            }else if (countNumber > 0 && countNumber <= 25){
                JOptionPane.showMessageDialog(null,"The total amount of activities on this month: " + countNumber ,"Amount of events", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "The level of rush is low !" ,"Level of rush", JOptionPane.PLAIN_MESSAGE);
            } else if (countNumber > 25 && countNumber <= 35){
                JOptionPane.showMessageDialog(null,"The total amount of activities on this month: " + countNumber ,"Amount of events", JOptionPane.PLAIN_MESSAGE);
                JOptionPane.showMessageDialog(null, "The level of rush is medium !" ,"Level of rush", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,"The total amount of activities on this month: " + countNumber ,"Amount of events", JOptionPane.PLAIN_MESSAGE);
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
                    SummaryMonthly frame = new SummaryMonthly("Summary Activity");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}