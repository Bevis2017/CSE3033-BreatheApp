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
		
		JButton logoutBtn = new JButton("LOGOUT");
		logoutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Logout().setVisible(true);
			}
		});
		logoutBtn.setForeground(Color.WHITE);
		logoutBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		logoutBtn.setBackground(SystemColor.activeCaption);
		logoutBtn.setBounds(15, 16, 128, 38);
		panel.add(logoutBtn);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(MainPage.class.getResource("/image/Relax-PNG-Clipart[1].png")));
		label_4.setBounds(-113, 16, 521, 578);
		panel.add(label_4);
		
		JLabel lblAddNewEvent = new JLabel("MAIN PAGE");
		lblAddNewEvent.setForeground(Color.BLACK);
		lblAddNewEvent.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblAddNewEvent.setBackground(Color.WHITE);
		lblAddNewEvent.setBounds(609, 11, 181, 57);
		contentPane.add(lblAddNewEvent);
		
		JButton viewCalBtn = new JButton("VIEW CALENDER");
		viewCalBtn.setForeground(Color.WHITE);
		viewCalBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		viewCalBtn.setBackground(new Color(255, 182, 193));
		viewCalBtn.setBounds(431, 169, 225, 68);
		contentPane.add(viewCalBtn);
		
		JButton addFriendBtn = new JButton("ADD FRIEND");
		addFriendBtn.setForeground(Color.WHITE);
		addFriendBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		addFriendBtn.setBackground(new Color(255, 182, 193));
		addFriendBtn.setBounds(431, 267, 225, 68);
		contentPane.add(addFriendBtn);
		
		JButton breatheBtn = new JButton("BREATHE TIME");
		breatheBtn.setForeground(Color.WHITE);
		breatheBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		breatheBtn.setBackground(new Color(255, 182, 193));
		breatheBtn.setBounds(431, 369, 225, 68);
		contentPane.add(breatheBtn);
		
		JButton summaryBtn = new JButton("MY SUMMARY");
		summaryBtn.setForeground(Color.WHITE);
		summaryBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		summaryBtn.setBackground(new Color(255, 182, 193));
		summaryBtn.setBounds(722, 169, 225, 68);
		contentPane.add(summaryBtn);
		summaryBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SummaryAty().setVisible(true);
			}
		});
		
		JButton recycleBtn = new JButton("RECYCLE BIN");
		recycleBtn.setForeground(Color.WHITE);
		recycleBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		recycleBtn.setBackground(new Color(255, 182, 193));
		recycleBtn.setBounds(722, 267, 225, 68);
		contentPane.add(recycleBtn);
		recycleBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new RecycleBin().setVisible(true);
			}
		});
		
		JButton settingBtn = new JButton("SETTING");
		settingBtn.setForeground(Color.WHITE);
		settingBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		settingBtn.setBackground(new Color(255, 182, 193));
		settingBtn.setBounds(722, 369, 225, 68);
		contentPane.add(settingBtn);
		settingBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SettingPage().setVisible(true);
			}
		});
		
		JButton addActBtn = new JButton("+");
		addActBtn.setForeground(Color.WHITE);
		addActBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		addActBtn.setBackground(new Color(255, 182, 193));
		addActBtn.setBounds(861, 507, 86, 68);
		contentPane.add(addActBtn);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	}
}
