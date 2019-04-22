import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewMyActivity extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMyActivity frame = new ViewMyActivity();
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
	public ViewMyActivity() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		setTitle("Breathe Application");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("View Detail");
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
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(ViewMyActivity.class.getResource("/image/416332-music-festival[1].png")));
		lblImage.setBounds(-125, 0, 566, 594);
		panel.add(lblImage);
		
		JLabel lblActivityTitle = new JLabel("DETAIL OF EVENT");
		lblActivityTitle.setForeground(Color.BLACK);
		lblActivityTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblActivityTitle.setBackground(Color.WHITE);
		lblActivityTitle.setBounds(552, 0, 267, 60);
		contentPane.add(lblActivityTitle);
		
		Button btnEdit = new Button("EDIT");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEdit.setBackground(new Color(255, 182, 193));
		btnEdit.setBounds(467, 544, 179, 29);
		contentPane.add(btnEdit);
		
		Button btnDelete = new Button("DELETE");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.setBackground(new Color(255, 182, 193));
		btnDelete.setBounds(719, 544, 179, 29);
		contentPane.add(btnDelete);
		
		JLabel lblEventName = new JLabel("Event Name :");
		lblEventName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEventName.setBounds(415, 90, 119, 20);
		contentPane.add(lblEventName);
		
		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblType.setBounds(415, 140, 101, 20);
		contentPane.add(lblType);
		
		JLabel lblLocation = new JLabel("Location :");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocation.setBounds(415, 190, 101, 20);
		contentPane.add(lblLocation);
		
		JLabel lblTime = new JLabel("Time :");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBounds(415, 240, 101, 20);
		contentPane.add(lblTime);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(415, 290, 101, 20);
		contentPane.add(lblDate);
		
		JLabel lblRepeat = new JLabel("Repeat :");
		lblRepeat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRepeat.setBounds(415, 340, 101, 20);
		contentPane.add(lblRepeat);
		
		JLabel lblAlert = new JLabel("Alert :");
		lblAlert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlert.setBounds(415, 390, 101, 20);
		contentPane.add(lblAlert);
		
		JLabel lblNotes = new JLabel("Notes :");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNotes.setBounds(415, 440, 101, 20);
		contentPane.add(lblNotes);
		
		JLabel lblInvitees = new JLabel("Invitees :");
		lblInvitees.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInvitees.setBounds(415, 490, 101, 20);
		contentPane.add(lblInvitees);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
	}
}
