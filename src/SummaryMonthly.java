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
        setContentPane(panel);
    }

    private CategoryDataset createDataset() {
        final String monthly = "MONTHLY";
        db = new Database();
        token.readToken();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        String query = "SELECT COUNT(id) AS count FROM event WHERE type = '%s' AND createdBy = '%d' AND MONTH(date) = MONTH(CURRENT_DATE())";
        ResultSet montlyNone = db.query(String.format(query, "None", token.getUserId()));
        ResultSet montlyWork = db.query(String.format(query, "Work", token.getUserId()));
        ResultSet montlyLeisure = db.query(String.format(query, "Leisure", token.getUserId()));
        ResultSet montlyPriority = db.query(String.format(query, "Priority", token.getUserId()));

        try {
            montlyNone.next();
            montlyWork.next();
            montlyLeisure.next();
            montlyPriority.next();

            dataset.addValue(montlyNone.getInt("count"),"None", monthly );
            dataset.addValue(montlyWork.getInt("count"), "Work", monthly );
            dataset.addValue(montlyLeisure.getInt("count"), "Leisure", monthly );
            dataset.addValue(montlyPriority.getInt("count"), "Priority", monthly );

            if (montlyNone.getInt("count")== 0 && montlyWork.getInt("count")== 0 && montlyLeisure.getInt("count")== 0 && montlyPriority.getInt("count")== 0){
                JOptionPane.showMessageDialog(new Frame(), "No event on this month!");
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