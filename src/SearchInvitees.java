import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SearchInvitees extends JFrame {

	private JPanel contentPane;
	private JTextField txtMail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchInvitees frame = new SearchInvitees();
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
	public SearchInvitees() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Search Invitee");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 370, 444);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(15, 16, 115, 29);
		panel.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SearchInvitees.class.getResource("/image/1154433-avatars[1].png")));
		label.setBounds(-23, 0, 393, 444);
		panel.add(label);
		
		JLabel lblForgotPassword = new JLabel("SEARCH INVITEE");
		lblForgotPassword.setBackground(Color.WHITE);
		lblForgotPassword.setForeground(Color.BLACK);
		lblForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblForgotPassword.setBounds(465, 28, 267, 60);
		contentPane.add(lblForgotPassword);
		
		JLabel lblItsFree = new JLabel("Find Your Friend ?");
		lblItsFree.setForeground(Color.BLACK);
		lblItsFree.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblItsFree.setBounds(517, 83, 170, 25);
		contentPane.add(lblItsFree);
		
		JTextPane txtpnEnterYouEmail = new JTextPane();
		txtpnEnterYouEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnEnterYouEmail.setText("Enter your friend's username or email address at below ");
		txtpnEnterYouEmail.setBounds(481, 131, 251, 70);
		contentPane.add(txtpnEnterYouEmail);
		contentPane.setFocusable(true);
		
		txtMail = new JTextField();
		txtMail.setBounds(441, 231, 324, 41);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		Button btnSend = new Button("SEARCH");
		btnSend.setForeground(Color.WHITE);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSend.setBackground(new Color(255, 182, 193));
		btnSend.setBounds(453, 346, 302, 41);
		contentPane.add(btnSend);
		
		JOptionPane.showMessageDialog(new Frame(), "The mail format that you entered is incorrect !");
		JOptionPane.showMessageDialog(new Frame(), "The mail that you entered is not found !");
		JOptionPane.showMessageDialog(new Frame(), "The username that you entered is not found !");
	}
}
