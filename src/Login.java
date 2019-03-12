import sun.applet.Main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldMail;
	private JPasswordField txtFieldPassword;
	private User user = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Breathe Application");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 370, 444);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Breathe App");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(90, 355, 201, 60);
		panel.add(lblNewLabel);
		
		JLabel lblRelax = new JLabel("- relax -");
		lblRelax.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRelax.setForeground(Color.WHITE);
		lblRelax.setBounds(148, 403, 89, 25);
		panel.add(lblRelax);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/image/music[1].png")));
		label_1.setBounds(-70, -15, 505, 386);
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(35, 52, 300, 302);
		label.setIcon(new ImageIcon(Login.class.getResource("/image/org.stopbreathethink.app[1].png")));
		panel.add(label);
		
		Button btnLogin = new Button("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    if (txtFieldMail.getText().length() > 0 && String.valueOf(txtFieldPassword.getPassword()).length() > 0) {
                    // validate login info
                    int loginId = user.login(txtFieldMail.getText(), String.valueOf(txtFieldPassword.getPassword()));
                    if ( loginId > 0) {
                        JOptionPane.showMessageDialog(new Frame(), "Login successful !");
                        Token t = new Token();
                        t.generateToken(txtFieldMail.getText());
                        t.saveToken();

                        dispose(); // close current window

						// go to MainPage
						new MainPage().setVisible(true);
                        //System.exit(0);
                    } else {
                        // wrong password
                        JOptionPane.showMessageDialog(new Frame(), "The email or password you entered is incorrect !");
                    }
                } else {
                    JOptionPane.showMessageDialog(new Frame(), "Please enter email and password to login!");
                }
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(255, 182, 193));
		btnLogin.setBounds(457, 324, 302, 41);
		contentPane.add(btnLogin);
		
		txtFieldMail = new JTextField();
		txtFieldMail.setBounds(457, 136, 302, 29);
		contentPane.add(txtFieldMail);
		txtFieldMail.setColumns(5);
		txtFieldMail.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {

			}

			@Override
			public void focusLost(FocusEvent e) {
			    // check email
                if (txtFieldMail.getText().length() > 0) {
                    boolean available = user.isUserEmailAvailable(txtFieldMail.getText());

                    if (available) {
                        JOptionPane.showMessageDialog(new Frame(), "Email not found!");
                    }
                }
			}
		});
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMail.setBounds(457, 115, 125, 20);
		contentPane.add(lblMail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(457, 175, 125, 20);
		contentPane.add(lblPassword);
		
		JCheckBox checkBoxRemember = new JCheckBox("Remember me");
		checkBoxRemember.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkBoxRemember.setBackground(Color.WHITE);
		checkBoxRemember.setBounds(457, 248, 157, 29);
		contentPane.add(checkBoxRemember);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.setForeground(Color.BLUE);
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSignUp.setBorderPainted(false);
		btnSignUp.setBackground(Color.WHITE);
		btnSignUp.setBounds(606, 372, 110, 29);
		contentPane.add(btnSignUp);
		btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUp().setVisible(true);
            }
        });
		
		JButton btnForgotPassword = new JButton("Forgot Password?");
		btnForgotPassword.setForeground(Color.BLUE);
		btnForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnForgotPassword.setBorderPainted(false);
		btnForgotPassword.setBackground(Color.WHITE);
		btnForgotPassword.setBounds(606, 248, 186, 29);
		contentPane.add(btnForgotPassword);
		btnForgotPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ForgotPassword().setVisible(true);
            }
        });
		
		txtFieldPassword = new JPasswordField();
		txtFieldPassword.setColumns(5);
		txtFieldPassword.setBounds(457, 196, 302, 29);
		contentPane.add(txtFieldPassword);
        txtFieldPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                JPasswordField field = (JPasswordField) e.getSource();
                char[] password = field.getPassword();

                if (password.length < 1) {
                    JOptionPane.showMessageDialog(new Frame(), "Please enter a password!");
                }
            }
        });
		
		JLabel lblMainTitle = new JLabel("Welcome back,");
		lblMainTitle.setForeground(Color.BLACK);
		lblMainTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblMainTitle.setBounds(457, 13, 258, 60);
		contentPane.add(lblMainTitle);
		
		JLabel lblSubTitle = new JLabel("Sign in to continue");
		lblSubTitle.setForeground(Color.BLACK);
		lblSubTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSubTitle.setBounds(457, 55, 289, 25);
		contentPane.add(lblSubTitle);
		
		JLabel lblNewUser = new JLabel("New user ?");
		lblNewUser.setForeground(Color.BLACK);
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewUser.setBounds(486, 373, 115, 25);
		contentPane.add(lblNewUser);

	}
}
