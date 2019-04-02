import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Button;

public class SettingPage extends JFrame {

	private JPanel contentPane;
	private JTextField userIDTxt;
	private JTextField userNaTxt;
	private JTextField emailTxt;
	private JTextField passwordTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SettingPage frame = new SettingPage();
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
	public SettingPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		setTitle("Breathe Application");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
		lblImage.setIcon(new ImageIcon(SettingPage.class.getResource("/image/TECHVOC-300x297[1].png")));
		lblImage.setBounds(37, 83, 318, 425);
		panel.add(lblImage);
		
		JLabel lblSetting = new JLabel("SETTING");
		lblSetting.setForeground(Color.BLACK);
		lblSetting.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSetting.setBackground(Color.WHITE);
		lblSetting.setBounds(607, 0, 138, 60);
		contentPane.add(lblSetting);
		
		JPanel jPanelProfilePic = new JPanel();
		jPanelProfilePic.setBackground(Color.PINK);
		jPanelProfilePic.setBounds(605, 60, 156, 166);
		contentPane.add(jPanelProfilePic);
		
		userIDTxt = new JTextField();
		userIDTxt.setBackground(Color.WHITE);
		userIDTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userIDTxt.setEditable(false);
		userIDTxt.setColumns(10);
		userIDTxt.setBounds(580, 265, 285, 25);
		contentPane.add(userIDTxt);
		
		userNaTxt = new JTextField();
		userNaTxt.setBackground(Color.WHITE);
		userNaTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNaTxt.setEditable(false);
		userNaTxt.setColumns(10);
		userNaTxt.setBounds(580, 315, 285, 25);
		contentPane.add(userNaTxt);
		
		emailTxt = new JTextField();
		emailTxt.setBackground(Color.WHITE);
		emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emailTxt.setEditable(false);
		emailTxt.setColumns(10);
		emailTxt.setBounds(580, 365, 285, 25);
		contentPane.add(emailTxt);
		
		passwordTxt = new JTextField();
		passwordTxt.setBackground(Color.WHITE);
		passwordTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordTxt.setEditable(false);
		passwordTxt.setColumns(10);
		passwordTxt.setBounds(580, 415, 285, 25);
		contentPane.add(passwordTxt);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUserid.setBounds(470, 265, 79, 20);
		contentPane.add(lblUserid);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(470, 315, 79, 20);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(470, 365, 49, 20);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(470, 415, 78, 20);
		contentPane.add(lblPassword);
		
		Button btnReset = new Button("RESET");
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReset.setBackground(new Color(255, 182, 193));
		btnReset.setBounds(777, 465, 136, 29);
		contentPane.add(btnReset);
		
		JLabel lblDeleteAccount = new JLabel("Delete Account ?");
		lblDeleteAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDeleteAccount.setBounds(531, 540, 138, 23);
		contentPane.add(lblDeleteAccount);
		
		JButton btnYesDeleteAccount = new JButton("Yes, Delete Account");
		btnYesDeleteAccount.setForeground(Color.BLUE);
		btnYesDeleteAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnYesDeleteAccount.setBorderPainted(false);
		btnYesDeleteAccount.setBackground(Color.WHITE);
		btnYesDeleteAccount.setBounds(669, 537, 197, 29);
		contentPane.add(btnYesDeleteAccount);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	}
}
