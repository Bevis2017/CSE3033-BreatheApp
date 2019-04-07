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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ForgotPassword extends JFrame {

	private JPanel contentPane;
	private JTextField txtMail;
	private User user = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassword frame = new ForgotPassword();
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
	public ForgotPassword() {
		setBackground(Color.WHITE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Forgot Password");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 370, 444);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(ForgotPassword.class.getResource("/image/forgot-password[1].png")));
		lblImage.setBounds(15, 93, 340, 257);
		panel.add(lblImage);
		
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
		
		JLabel lblForgotPassword1 = new JLabel("FORGOT PASSWORD");
		lblForgotPassword1.setBackground(Color.WHITE);
		lblForgotPassword1.setForeground(Color.BLACK);
		lblForgotPassword1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblForgotPassword1.setBounds(441, 26, 324, 60);
		contentPane.add(lblForgotPassword1);
		
		JLabel lblForgotPassword2 = new JLabel("Forgot Your Password ?");
		lblForgotPassword2.setForeground(Color.BLACK);
		lblForgotPassword2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblForgotPassword2.setBounds(493, 83, 219, 25);
		contentPane.add(lblForgotPassword2);
		
		JTextPane txtPaneMail = new JTextPane();
		txtPaneMail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPaneMail.setText("Enter you email address below and we'll send you a new password");
		txtPaneMail.setBounds(455, 124, 287, 70);
		contentPane.add(txtPaneMail);
		contentPane.setFocusable(true);
		
		txtMail = new JTextField();
		txtMail.setBounds(441, 231, 324, 41);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		Button btnSend = new Button("SEND");
		btnSend.setForeground(Color.WHITE);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSend.setBackground(new Color(255, 182, 193));
		btnSend.setBounds(453, 346, 302, 41);
		contentPane.add(btnSend);
		btnSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = txtMail.getText();
				if (User.validateEmail(email)) {
					// email format correct, check if email exist
					if (!user.isUserEmailAvailable(email)) {
						// email exist, reset password
						boolean resetStatus = user.resetPassword(email);

						if (resetStatus) {
							JOptionPane.showMessageDialog(new Frame(), "Please check your mailbox. \nThe new password already sent through your mailbox.");
							dispose();
						} else {
							JOptionPane.showMessageDialog(new Frame(), "Unexpected error, please try again!");
						}
					} else {
						// email not exist (user not found)
						JOptionPane.showMessageDialog(new Frame(), "The mail that you entered is not found !");
					}
				} else {
					// wrong format
					JOptionPane.showMessageDialog(new Frame(), "The mail format that you entered is incorrect !");
				}
			}
		});



	}
}
