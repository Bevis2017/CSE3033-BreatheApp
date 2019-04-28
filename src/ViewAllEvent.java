import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewAllEvent extends JFrame {

    private JPanel contentPane;
    private Event event;
    private String[][] data = new String[50][4];
    private String[] columnNames = {"Event ID", "Date & Time", "Event Name", "Event Type"};
    private DefaultTableModel model;
    private JTable jTable;

    /**
     * Create the frame.
     */
    public ViewAllEvent(int uid) {
        event = new Event();

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1000, 630);
        setResizable(false);
        setTitle("Breathe Application");
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setTitle("View Calendar");
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Panel panel = new Panel();
        panel.setBackground(Color.PINK);
        panel.setBounds(0, 0, 370, 594);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnBack = new JButton("BACK");
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnBack.setBackground(SystemColor.activeCaption);
        btnBack.setBounds(15, 16, 115, 29);
        panel.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JLabel lblImage = new JLabel("");
        lblImage.setIcon(new ImageIcon(ViewAllEvent.class.getResource("/image/445px-Blue_calendar_icon_with_dates_crossed_out.svg[1].png")));
        lblImage.setBounds(-18, 72, 405, 491);
        panel.add(lblImage);

        JLabel btnViewActivities = new JLabel("VIEW EVENTS");
        btnViewActivities.setForeground(Color.BLACK);
        btnViewActivities.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnViewActivities.setBackground(Color.WHITE);
        btnViewActivities.setBounds(543, 0, 291, 60);
        contentPane.add(btnViewActivities);

        // Data to be displayed in the JTable
        getData(uid);

        // Initializing the JTable
        jTable = new JTable();
        jTable.setModel(model);
        // Set enabled
        //jTable.setEnabled(false);
        //jTable.setBounds(30, 40, 200, 300);

        // hide event id column
        jTable.getColumnModel().getColumn(0).setMinWidth(0);
        jTable.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable.getColumnModel().getColumn(0).setWidth(0);


        ListSelectionModel select = jTable.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        select.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    int[] row = jTable.getSelectedRows();
                    //int[] columns = jTable.getSelectedColumns();
                    try {
                        String selectedRow = (String) jTable.getValueAt(row[0], 0);
                        int selectedEvent = -1;
                        if (selectedRow != null) {
                            selectedEvent = Integer.valueOf(selectedRow);
                            new ViewDetailsEvent(selectedEvent).setVisible(true);
                        }

                        System.out.println("[ViewAllEvent][JTable] Selected Event ID: " + selectedEvent);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        JScrollPane calScrollPane = new JScrollPane(jTable);
        calScrollPane.setBounds(417, 76, 525, 450);
        contentPane.add(calScrollPane);

        /*Button btnViewDetail = new Button("REFRESH");
        btnViewDetail.setForeground(Color.WHITE);
        btnViewDetail.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnViewDetail.setBackground(new Color(255, 182, 193));
        btnViewDetail.setBounds(596, 524, 179, 29);
        contentPane.add(btnViewDetail);
        btnViewDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("[ViewAllEvent] Refresh button pressed.");
                refreshData(uid);
            }
        });*/

        Border border = BorderFactory.createLineBorder(Color.BLACK);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewAllEvent frame = new ViewAllEvent(12);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void refreshData(int uid) {
        getData(uid);
        DefaultTableModel newModel = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        jTable.setModel(newModel);

        AbstractTableModel model = (AbstractTableModel) jTable.getModel();
        model.fireTableDataChanged();

        //jTable.invalidate();

        //jTable.repaint();
        //model.fireTableDataChanged();

        // hide event id column
        jTable.getColumnModel().getColumn(0).setMinWidth(0);
        jTable.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable.getColumnModel().getColumn(0).setWidth(0);
    }

    private void getData(int uid) {
        ResultSet rsEventList = event.getAllEventByUserId(uid);
        int rowCount = 0;

        try {
            while (rsEventList.next()) {
                data[rowCount][0] = rsEventList.getString("id");
                data[rowCount][1] = rsEventList.getString("date");
                data[rowCount][2] = rsEventList.getString("name");
                data[rowCount][3] = rsEventList.getString("type");
                rowCount++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        model = new DefaultTableModel(data, columnNames) {
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
    }

    private void checkEvent() {
        //String query = "SELECT * FROM event WHERE "
    }
}
