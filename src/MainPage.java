import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Token token = new Token();

				try {
					// check user detail
					if (token.readToken() && token.getRememberMe()) {
						MainPage frame = new MainPage();
						frame.setVisible(true);
					} else {
						new Login().setVisible(true);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		setTitle("Breathe Application");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Main Page");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 370, 594);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Logout().setVisible(true);
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogout.setBackground(SystemColor.activeCaption);
		btnLogout.setBounds(15, 16, 128, 38);
		panel.add(btnLogout);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(MainPage.class.getResource("/image/Relax-PNG-Clipart[1].png")));
		lblImage.setBounds(-113, 16, 521, 578);
		panel.add(lblImage);
		
		JLabel lblMainPage = new JLabel("MAIN PAGE");
		lblMainPage.setForeground(Color.BLACK);
		lblMainPage.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMainPage.setBackground(Color.WHITE);
		lblMainPage.setBounds(609, 11, 181, 57);
		contentPane.add(lblMainPage);
		
		JButton btnViewCalendar = new JButton("VIEW CALENDER");
		btnViewCalendar.setForeground(Color.WHITE);
		btnViewCalendar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnViewCalendar.setBackground(new Color(255, 182, 193));
		btnViewCalendar.setBounds(431, 169, 225, 68);
		contentPane.add(btnViewCalendar);
		
		JButton btnAddFriend = new JButton("ADD FRIEND");
		btnAddFriend.setForeground(Color.WHITE);
		btnAddFriend.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddFriend.setBackground(new Color(255, 182, 193));
		btnAddFriend.setBounds(431, 267, 225, 68);
		contentPane.add(btnAddFriend);
		
		JButton btnBreatheTime = new JButton("BREATHE TIME");
		btnBreatheTime.setForeground(Color.WHITE);
		btnBreatheTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBreatheTime.setBackground(new Color(255, 182, 193));
		btnBreatheTime.setBounds(431, 369, 225, 68);
		contentPane.add(btnBreatheTime);
		
		JButton btnSummary = new JButton("MY SUMMARY");
		btnSummary.setForeground(Color.WHITE);
		btnSummary.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSummary.setBackground(new Color(255, 182, 193));
		btnSummary.setBounds(722, 169, 225, 68);
		contentPane.add(btnSummary);
		btnSummary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SummaryAty().setVisible(true);
			}
		});
		
		JButton btnRecycleBin = new JButton("RECYCLE BIN");
		btnRecycleBin.setForeground(Color.WHITE);
		btnRecycleBin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRecycleBin.setBackground(new Color(255, 182, 193));
		btnRecycleBin.setBounds(722, 267, 225, 68);
		contentPane.add(btnRecycleBin);
		btnRecycleBin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RecycleBin().setVisible(true);
			}
		});
		
		JButton btnSetting = new JButton("SETTING");
		btnSetting.setForeground(Color.WHITE);
		btnSetting.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSetting.setBackground(new Color(255, 182, 193));
		btnSetting.setBounds(722, 369, 225, 68);
		contentPane.add(btnSetting);
		btnSetting.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SettingPage().setVisible(true);
			}
		});
		
		JButton btnAddEvent = new JButton("+");
		btnAddEvent.setForeground(Color.WHITE);
		btnAddEvent.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddEvent.setBackground(new Color(255, 182, 193));
		btnAddEvent.setBounds(861, 507, 86, 68);
		contentPane.add(btnAddEvent);
		btnAddEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddEvent().setVisible(true);
			}
		});
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	}
}
