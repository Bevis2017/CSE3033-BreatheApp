import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(15, 16, 115, 29);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SummaryAty.class.getResource("/image/web-analytics-data-analysis[1].png")));
		lblNewLabel.setBounds(0, 121, 328, 341);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SummaryAty.class.getResource("/image/1171930-university[1].png")));
		label.setBounds(-132, 0, 594, 594);
		panel.add(label);
		
		JLabel lblSummary = new JLabel("SUMMARY ACTIVITY");
		lblSummary.setForeground(Color.BLACK);
		lblSummary.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSummary.setBackground(Color.WHITE);
		lblSummary.setBounds(516, 29, 319, 60);
		contentPane.add(lblSummary);
		
		Button btnDay = new Button("DAILY");
		btnDay.setForeground(Color.WHITE);
		btnDay.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDay.setBackground(new Color(255, 182, 193));
		btnDay.setBounds(516, 150, 302, 80);
		contentPane.add(btnDay);
		
		Button btnWeek = new Button("WEEKLY");
		btnWeek.setForeground(Color.WHITE);
		btnWeek.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnWeek.setBackground(new Color(255, 182, 193));
		btnWeek.setBounds(516, 287, 302, 80);
		contentPane.add(btnWeek);
		
		Button btnMonth = new Button("MONTHLY");
		btnMonth.setForeground(Color.WHITE);
		btnMonth.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMonth.setBackground(new Color(255, 182, 193));
		btnMonth.setBounds(516, 430, 302, 80);
		contentPane.add(btnMonth);
	}
}
