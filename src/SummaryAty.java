import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SummaryAty extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SummaryAty frame = new SummaryAty();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SummaryAty() {
		setBackground(Color.WHITE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Summary Activity");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 370, 594);
		contentPane.add(panel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(15, 16, 115, 29);
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(SummaryAty.class.getResource("/image/web-analytics-data-analysis[1].png")));
		lblImage.setBounds(0, 121, 328, 341);
		panel.add(lblImage);
		
		JLabel lblImage1 = new JLabel("");
		lblImage1.setIcon(new ImageIcon(SummaryAty.class.getResource("/image/1171930-university[1].png")));
		lblImage1.setBounds(-132, 0, 594, 594);
		panel.add(lblImage1);
		
		JLabel lblSummary = new JLabel("SUMMARY ACTIVITY");
		lblSummary.setForeground(Color.BLACK);
		lblSummary.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSummary.setBackground(Color.WHITE);
		lblSummary.setBounds(516, 29, 319, 60);
		contentPane.add(lblSummary);
		
		Button lblDaily = new Button("DAILY");
		lblDaily.setForeground(Color.WHITE);
		lblDaily.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDaily.setBackground(new Color(255, 182, 193));
		lblDaily.setBounds(516, 150, 302, 80);
		contentPane.add(lblDaily);
		
		Button btnWeekly = new Button("WEEKLY");
		btnWeekly.setForeground(Color.WHITE);
		btnWeekly.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnWeekly.setBackground(new Color(255, 182, 193));
		btnWeekly.setBounds(516, 287, 302, 80);
		contentPane.add(btnWeekly);
		
		Button btnMonthly = new Button("MONTHLY");
		btnMonthly.setForeground(Color.WHITE);
		btnMonthly.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMonthly.setBackground(new Color(255, 182, 193));
		btnMonthly.setBounds(516, 430, 302, 80);
		contentPane.add(btnMonthly);
	}
}
