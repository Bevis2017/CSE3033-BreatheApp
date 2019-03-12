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

public class AddInvitee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddInvitee frame = new AddInvitee();
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
	public AddInvitee() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Add Invitee");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConfirmTitle = new JLabel("Are you sure you want to add this invitee ?");
		lblConfirmTitle.setForeground(Color.BLACK);
		lblConfirmTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblConfirmTitle.setBounds(44, 16, 398, 77);
		contentPane.add(lblConfirmTitle);
		
		Button btnOk = new Button("OK");
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnOk.setBackground(new Color(255, 182, 193));
		btnOk.setBounds(86, 175, 136, 29);
		contentPane.add(btnOk);
		
		Button btnCancel = new Button("CANCEL");
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnCancel.setBackground(new Color(255, 182, 193));
		btnCancel.setBounds(261, 175, 136, 29);
		contentPane.add(btnCancel);
		
		JLabel lblMailName = new JLabel("Username / Mail :");
		lblMailName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMailName.setBounds(52, 108, 159, 20);
		contentPane.add(lblMailName);
		
		JOptionPane.showMessageDialog(new Frame(), "Add invitee successful !");
		
	}
}
