

import sun.security.krb5.internal.crypto.dk.ArcFourCrypto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.Panel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldUsername;
	private JTextField txtFieldEmail;
	private JPasswordField txtFieldPassword;
	private JPasswordField txtFieldReenter;
	private User user = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setBackground(Color.WHITE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Sign Up");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 370, 444);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(15, 16, 115, 29);
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLACK);
		label.setBounds(28, 102, 308, 240);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(SignUp.class.getResource("/image/registericonpatrol-300x230[1].png")));
		panel.add(label);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(442, 89, 125, 20);
		contentPane.add(lblUsername);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(442, 153, 125, 20);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(442, 216, 125, 20);
		contentPane.add(lblPassword);
		
		JLabel lblReenterPassword = new JLabel("Re-enter Password");
		lblReenterPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReenterPassword.setBounds(442, 276, 180, 20);
		contentPane.add(lblReenterPassword);
		
		Button btnSignUp = new Button("SIGN UP");
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSignUp.setBackground(new Color(255, 182, 193));
		btnSignUp.setBounds(442, 355, 302, 41);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtFieldEmail.getText().length() > 0
						&& txtFieldUsername.getText().length() > 0
						&& String.valueOf(txtFieldPassword.getPassword()).length() > 0) {
				    if (!user.isUserEmailAvailable(txtFieldEmail.getText())) {
				        // error
                        JOptionPane.showMessageDialog(new Frame(), "The email must be unique !");
                    } else if (!user.isUserNameAvailable(txtFieldUsername.getText())) {
				        // error
                        JOptionPane.showMessageDialog(new Frame(), "The username must be unique !");
                    } else {
				        // no problem
                        boolean register = user.createAccount(txtFieldUsername.getText(), txtFieldEmail.getText(), String.valueOf(txtFieldPassword.getPassword()));
                        if (register) {
                            Token token = new Token();
                            token.generateToken(txtFieldEmail.getText());
                            token.saveToken();
                            JOptionPane.showMessageDialog(new Frame(), "Congratulation ! Sign up an account successful !");
                            dispose();
                        }
                    }
				} else {
					JOptionPane.showMessageDialog(new Frame(), "Please fill up all the field!");
				}
			}
		});
		
		JLabel lblMainTitle = new JLabel("SIGN UP");
		lblMainTitle.setBounds(442, 0, 258, 60);
		contentPane.add(lblMainTitle);
		lblMainTitle.setForeground(Color.BLACK);
		lblMainTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblSubTitle = new JLabel("It's free and always will be ");
		lblSubTitle.setBounds(442, 44, 289, 25);
		contentPane.add(lblSubTitle);
		lblSubTitle.setForeground(Color.BLACK);
		lblSubTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtFieldUsername = new JTextField();
		txtFieldUsername.setColumns(5);
		txtFieldUsername.setBounds(442, 112, 302, 29);
		contentPane.add(txtFieldUsername);
		txtFieldUsername.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				// check username
				if (txtFieldUsername.getText().length() > 0) {
					boolean available = user.isUserNameAvailable(txtFieldUsername.getText());

					if (!available) {
						JOptionPane.showMessageDialog(new Frame(), "The username must be unique !");
					}
				}
			}
		});
		
		txtFieldEmail = new JTextField();
		txtFieldEmail.setColumns(5);
		txtFieldEmail.setBounds(442, 173, 302, 29);
		contentPane.add(txtFieldEmail);
		txtFieldEmail.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				// check email
				if (txtFieldEmail.getText().length() > 0) {
					boolean available = user.isUserEmailAvailable(txtFieldEmail.getText());

					if (!validateEmail(txtFieldEmail.getText())) {
						JOptionPane.showMessageDialog(new Frame(), "The email format must be correct !");
					} else if (!available) {
						JOptionPane.showMessageDialog(new Frame(), "The email must be unique !");
					}
				}
			}
		});
		
		txtFieldPassword = new JPasswordField();
		txtFieldPassword.setColumns(5);
		txtFieldPassword.setBounds(442, 236, 302, 29);
		txtFieldPassword.setToolTipText("The password must more than 8 characters.");
		contentPane.add(txtFieldPassword);
		txtFieldPassword.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtFieldPassword.getPassword().length < 8) {
					JOptionPane.showMessageDialog(new Frame(), "The password must more than 8 characters!");
				}
			}
		});
		
		txtFieldReenter = new JPasswordField();
		txtFieldReenter.setColumns(5);
		txtFieldReenter.setBounds(442, 297, 302, 29);
		txtFieldReenter.setToolTipText("The re-enter password should same with password that you entered.");
		contentPane.add(txtFieldReenter);
		txtFieldReenter.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtFieldPassword.getPassword().length > 0 && txtFieldReenter.getPassword().length > 0) {
					if (!Arrays.equals(txtFieldPassword.getPassword(), txtFieldReenter.getPassword())) {
						JOptionPane.showMessageDialog(new Frame(), "The re-enter password must same with password that you entered !");
					}
				}
			}
		});
	}

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		return matcher.find();
	}
}
