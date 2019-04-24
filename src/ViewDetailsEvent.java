import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewDetailsEvent extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldEventName;
	private JTextField txtFieldType;
	private JTextField txtFieldLocation;
	private JTextField txtFieldTime;
	private JTextField txtFieldDate;
	private JTextField txtFieldRepeat;
	private JTextField txtFieldAlert;
	private JTextField txtFieldInvitees;
	private Event event;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDetailsEvent frame = new ViewDetailsEvent(14);
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
	public ViewDetailsEvent(int eid) {
		event = new Event(eid);

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 630);
		setResizable(false);
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
		lblImage.setIcon(new ImageIcon(ViewDetailsEvent.class.getResource("/image/416332-music-festival[1].png")));
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
				new EditEvent(eid).setVisible(true);
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
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteEvent(ViewDetailsEvent.this, eid).setVisible(true);
			}
		});

		JLabel lblEventName = new JLabel("Event Name :");
		lblEventName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEventName.setBounds(415, 90, 119, 20);
		contentPane.add(lblEventName);

		txtFieldEventName = new JTextField();
		txtFieldEventName.setBounds(555, 90, 370, 25);
		contentPane.add(txtFieldEventName);
		txtFieldEventName.setEditable(false);
		txtFieldEventName.setColumns(10);

		JLabel lblType = new JLabel("Type :");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblType.setBounds(415, 140, 101, 20);
		contentPane.add(lblType);

		txtFieldType = new JTextField();
		txtFieldType.setColumns(10);
		txtFieldType.setBounds(555, 140, 370, 25);
		txtFieldType.setEditable(false);
		contentPane.add(txtFieldType);

		JLabel lblLocation = new JLabel("Location :");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocation.setBounds(415, 190, 101, 20);
		contentPane.add(lblLocation);

		txtFieldLocation = new JTextField();
		txtFieldLocation.setColumns(10);
		txtFieldLocation.setBounds(555, 190, 370, 25);
		txtFieldLocation.setEditable(false);
		contentPane.add(txtFieldLocation);

		JLabel lblTime = new JLabel("Time :");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBounds(415, 240, 101, 20);
		contentPane.add(lblTime);

		txtFieldTime = new JTextField();
		txtFieldTime.setColumns(10);
		txtFieldTime.setBounds(555, 240, 370, 25);
		txtFieldTime.setEditable(false);
		contentPane.add(txtFieldTime);

		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(415, 290, 101, 20);
		contentPane.add(lblDate);

		txtFieldDate = new JTextField();
		txtFieldDate.setColumns(10);
		txtFieldDate.setBounds(555, 290, 370, 25);
		txtFieldDate.setEditable(false);
		contentPane.add(txtFieldDate);

		JLabel lblRepeat = new JLabel("Repeat :");
		lblRepeat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRepeat.setBounds(415, 340, 101, 20);
		contentPane.add(lblRepeat);

		txtFieldRepeat = new JTextField();
		txtFieldRepeat.setColumns(10);
		txtFieldRepeat.setBounds(555, 340, 370, 25);
		txtFieldRepeat.setEditable(false);
		contentPane.add(txtFieldRepeat);

		JLabel lblAlert = new JLabel("Alert :");
		lblAlert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlert.setBounds(415, 390, 101, 20);
		contentPane.add(lblAlert);

		txtFieldAlert = new JTextField();
		txtFieldAlert.setColumns(10);
		txtFieldAlert.setBounds(555, 390, 370, 25);
		txtFieldAlert.setEditable(false);
		contentPane.add(txtFieldAlert);

		JLabel lblNotes = new JLabel("Notes :");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNotes.setBounds(415, 440, 101, 20);
		contentPane.add(lblNotes);

		JTextArea txtAreaNotes = new JTextArea();
		txtAreaNotes.setBackground(Color.WHITE);
		txtAreaNotes.setBounds(555, 440, 370, 22);
		txtAreaNotes.setEditable(false);
		contentPane.add(txtAreaNotes);

		Border border = BorderFactory.createLineBorder(SystemColor.inactiveCaption);
		txtAreaNotes.setBackground(SystemColor.inactiveCaptionBorder);
		txtAreaNotes.setBorder(border);

		contentPane.add(txtAreaNotes);

		JLabel lblInvitees = new JLabel("Invitees :");
		lblInvitees.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInvitees.setBounds(415, 490, 101, 20);
		contentPane.add(lblInvitees);

		txtFieldInvitees = new JTextField();
		txtFieldInvitees.setColumns(10);
		txtFieldInvitees.setBounds(555, 490, 370, 25);
		txtFieldInvitees.setEditable(false);
		contentPane.add(txtFieldInvitees);

		// set text
		txtFieldEventName.setText(event.getName());
		txtFieldDate.setText(event.getDate());
		txtFieldTime.setText(event.getTime());
		txtFieldAlert.setText(event.getAlert());
		String inviteeTxt = event.getInviteeHash();
		inviteeTxt = inviteeTxt.substring(1, inviteeTxt.length() - 1);
		txtFieldInvitees.setText(inviteeTxt);
		txtFieldLocation.setText(event.getLocation());
		txtFieldType.setText(event.getType());
		txtAreaNotes.setText(event.getNotes());
		txtFieldRepeat.setText(event.getRepeatEvent());
	}
}