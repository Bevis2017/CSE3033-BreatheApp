import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import java.awt.TextArea;
import java.awt.Choice;
import javax.swing.JTextPane;
import java.awt.List;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.JScrollPane;

public class ViewCalender extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCalender frame = new ViewCalender();
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
	public ViewCalender() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
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
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(ViewCalender.class.getResource("/image/445px-Blue_calendar_icon_with_dates_crossed_out.svg[1].png")));
		lblImage.setBounds(-18, 72, 405, 491);
		panel.add(lblImage);
		
		JLabel btnViewActivities = new JLabel("VIEW ACTIVITIES");
		btnViewActivities.setForeground(Color.BLACK);
		btnViewActivities.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnViewActivities.setBackground(Color.WHITE);
		btnViewActivities.setBounds(543, 0, 291, 60);
		contentPane.add(btnViewActivities);
		
		JScrollPane calScrollPane = new JScrollPane();
		calScrollPane.setBounds(417, 76, 525, 416);
		contentPane.add(calScrollPane);
		
		Button btnViewDetail = new Button("VIEW DETAIL");
		btnViewDetail.setForeground(Color.WHITE);
		btnViewDetail.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnViewDetail.setBackground(new Color(255, 182, 193));
		btnViewDetail.setBounds(596, 524, 179, 29);
		contentPane.add(btnViewDetail);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	}
}
