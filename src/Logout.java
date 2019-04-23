import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Logout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Logout frame = new Logout();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Logout() {
		setBackground(Color.WHITE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Logout");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfirmTitle = new JLabel("Are you sure you want to logout ?");
		lblConfirmTitle.setForeground(Color.BLACK);
		lblConfirmTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmTitle.setBounds(82, 42, 309, 77);
		contentPane.add(lblConfirmTitle);
		
		Button btnOk = new Button("OK");
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnOk.setBackground(new Color(255, 182, 193));
		btnOk.setBounds(82, 136, 136, 29);
		contentPane.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Token token = new Token();
				token.deleteToken();
				JOptionPane.showMessageDialog(new Frame(), "Logout successful !", "Logout", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				System.exit(0);
			}
		});
		
		Button btnCancel = new Button("CANCEL");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBackground(new Color(255, 182, 193));
		btnCancel.setBounds(260, 136, 136, 29);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
