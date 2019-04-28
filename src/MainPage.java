import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {

	private JPanel contentPane;
	private static Token token = new Token();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {


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
					new Login().setVisible(true);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 630);
		setResizable(false);
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

		JButton btnViewAllEvents = new JButton("VIEW ALL EVENTS");
		btnViewAllEvents.setForeground(Color.WHITE);
		btnViewAllEvents.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnViewAllEvents.setBackground(new Color(255, 182, 193));
		btnViewAllEvents.setBounds(420, 145, 225, 125);
		contentPane.add(btnViewAllEvents);
		btnViewAllEvents.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new ViewAllEvent(token.getUserId()).setVisible(true);
			}
		});

		JButton btnBreatheTime = new JButton("BREATHE TIME");
		btnBreatheTime.setForeground(Color.WHITE);
		btnBreatheTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBreatheTime.setBackground(new Color(255, 182, 193));
		btnBreatheTime.setBounds(420, 350, 225, 125);
		contentPane.add(btnBreatheTime);
		btnBreatheTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BreatheTime().setVisible(true);
			}
		});

		JButton btnSummary = new JButton("MY SUMMARY");
		btnSummary.setForeground(Color.WHITE);
		btnSummary.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSummary.setBackground(new Color(255, 182, 193));
		btnSummary.setBounds(700, 145, 225, 125);
		contentPane.add(btnSummary);
		btnSummary.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SummaryAty().setVisible(true);
			}
		});

		JButton btnSetting = new JButton("SETTING");
		btnSetting.setForeground(Color.WHITE);
		btnSetting.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSetting.setBackground(new Color(255, 182, 193));
		btnSetting.setBounds(700, 350, 225, 125);
		contentPane.add(btnSetting);
		btnSetting.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SettingPage(token.getUserId()).setVisible(true);
			}
		});

		JButton btnAddEvent = new JButton("+");
		btnAddEvent.setForeground(Color.WHITE);
		btnAddEvent.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddEvent.setBackground(new Color(255, 182, 193));
		btnAddEvent.setBounds(840, 507, 86, 68);
		contentPane.add(btnAddEvent);
		btnAddEvent.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddEvent().setVisible(true);
			}
		});

		Border border = BorderFactory.createLineBorder(Color.BLACK);

		// run alert module, check for conflicts in activities
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new AlertModule(token.getUserId());
			}
		});
	}
}
