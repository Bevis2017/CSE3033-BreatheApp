import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.github.lgooddatepicker.components.TimePicker;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class EditEvent extends JFrame {

	private JPanel contentPane;
	private JTextField txtName = new JTextField();
	private JTextField txtLocation = new JTextField();
	private JTextField txtInvitees;
	private JTextArea txtrNotes = new JTextArea();
	private Choice choiceAlert, choiceRepeat, choiceType;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	private DatePickerSettings dateSettings = new DatePickerSettings();
	private TimePicker timePicker1;
	private DatePicker datePicker1;
	private ArrayList<String> inviteeList = new ArrayList<>();
	private User user = new User();
	private Event event;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEvent frame = new EditEvent(13);
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
	public EditEvent(int eventId) {
		// pull data from db
		event = new Event(eventId);

		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 630);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Edit event");
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
				if (txtName.getText().trim().length() > 0) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog(
							null,
							"Are you sure you want to exit without save?",
							"Closing",
							dialogButton
					);
					if(dialogResult == JOptionPane.YES_OPTION) {
						// YES
						System.out.println("Option: YES");
						dispose();
					} else {
						// NO
						System.out.println("Option: NO");
					}
				} else {
					dispose();
				}
			}
		});
		
		JLabel lblImage = new JLabel("New label");
		lblImage.setIcon(new ImageIcon(EditEvent.class.getResource("/image/V2[1].png")));
		lblImage.setBounds(197, 220, 173, 159);
		panel.add(lblImage);
		
		JLabel lblImage1 = new JLabel("");
		lblImage1.setIcon(new ImageIcon(EditEvent.class.getResource("/image/calendar[1].png")));
		lblImage1.setBounds(54, 79, 270, 425);
		panel.add(lblImage1);
		
		JLabel lblEditEvent = new JLabel("EDIT EVENT");
		lblEditEvent.setForeground(Color.BLACK);
		lblEditEvent.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblEditEvent.setBackground(Color.WHITE);
		lblEditEvent.setBounds(567, 0, 267, 60);
		contentPane.add(lblEditEvent);
		
		JLabel lblName = new JLabel("Event Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(424, 70, 101, 20);
		contentPane.add(lblName);
		
		JLabel lblRequired = new JLabel("*");
		lblRequired.setForeground(Color.RED);
		lblRequired.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRequired.setBounds(524, 70, 27, 20);
		lblRequired.setToolTipText("Event name is required.");
		contentPane.add(lblRequired);
		
		//txtName = new JTextField();
		txtName.setColumns(5);
		txtName.setBounds(586, 70, 336, 29);
		contentPane.add(txtName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblType.setBounds(424, 117, 101, 20);
		contentPane.add(lblType);
		
		choiceType = new Choice();
		choiceType.setBounds(586, 117, 336, 26);
		choiceType.add("None");
		choiceType.add("Work");
		choiceType.add("Leisure");
		choiceType.add("Priority");
		contentPane.add(choiceType);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLocation.setBounds(424, 164, 101, 20);
		contentPane.add(lblLocation);
		
		txtLocation = new JTextField();
		txtLocation.setColumns(5);
		txtLocation.setBounds(586, 164, 336, 29);
		contentPane.add(txtLocation);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTime.setBounds(424, 211, 47, 20);
		contentPane.add(lblTime);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDate.setBounds(424, 258, 47, 20);
		contentPane.add(lblDate);

		// Create a date picker, and add it to the form.
		datePicker1 = new DatePicker(dateSettings);
		datePicker1.setBounds(586, 258, 336, 25);
		datePicker1.setDateToToday();
		contentPane.add(datePicker1);

		// Create a time picker, and add it to the form.
		timePicker1 = new TimePicker();
		timePicker1.setBounds(586, 214, 336, 25);
		contentPane.add(timePicker1);
		
		JLabel lblRepeat = new JLabel("Repeat");
		lblRepeat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRepeat.setBounds(424, 305, 101, 20);
		contentPane.add(lblRepeat);
		
		choiceRepeat = new Choice();
		choiceRepeat.setBounds(586, 305, 336, 26);
		choiceRepeat.add("Never");
		choiceRepeat.add("Every Day");
		choiceRepeat.add("Every Week");
		choiceRepeat.add("Every 2 Weeks");
		choiceRepeat.add("Every Month");
		choiceRepeat.add("Every Year");
		contentPane.add(choiceRepeat);
		
		JLabel lblAlert = new JLabel("Alert");
		lblAlert.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAlert.setBounds(424, 352, 101, 20);
		contentPane.add(lblAlert);
		
		choiceAlert = new Choice();
		choiceAlert.setBounds(586, 352, 336, 26);
		choiceAlert.add("None");
		choiceAlert.add("At time of event");
		choiceAlert.add("30 minutes before");
		choiceAlert.add("1 hour before");
		choiceAlert.add("1 day before");
		choiceAlert.add("1 week before");
		contentPane.add(choiceAlert);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNotes.setBounds(424, 399, 101, 20);
		contentPane.add(lblNotes);
		
		JLabel lblInvitees = new JLabel("Invitees");
		lblInvitees.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInvitees.setBounds(424, 493, 101, 20);
		contentPane.add(lblInvitees);
        lblInvitees.setToolTipText("Use the symbol ',' for adding more than one invitees.");
		
		txtInvitees = new JTextField();
		txtInvitees.setColumns(5);
		txtInvitees.setBounds(586, 493, 336, 29);
		contentPane.add(txtInvitees);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(617, 224, 4, 22);
		contentPane.add(textArea);
		
		//txtrNotes = new JTextArea();
		txtrNotes.setText("Write something...");
		txtrNotes.setEditable(true);
		txtrNotes.setBounds(586, 399, 336, 80);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtrNotes.setBorder(border);
		contentPane.add(txtrNotes);
		
		JLabel lblRequired1 = new JLabel("*");
		lblRequired1.setForeground(Color.RED);
		lblRequired1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRequired1.setBounds(468, 211, 27, 20);
		lblRequired1.setToolTipText("Time is required.");
		contentPane.add(lblRequired1);
		
		JLabel lblRequired2 = new JLabel("*");
		lblRequired2.setForeground(Color.RED);
		lblRequired2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRequired2.setBounds(468, 258, 27, 20);
		lblRequired2.setToolTipText("Date is required.");
		contentPane.add(lblRequired2);
		
		Button btnEdit = new Button("EDIT");
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEdit.setBackground(new Color(255, 182, 193));
		btnEdit.setBounds(586, 540, 336, 29);
		contentPane.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// check invitee
				boolean isInviteeValid = true;
				if (txtInvitees.getText().length() > 0) {
					// fix multiple space issue
					String strInvitees = txtInvitees.getText().trim().replaceAll(" +", " ");
					// convert string to arraylist
					inviteeList = new ArrayList<>(Arrays.asList(strInvitees.split(",")));
					System.out.println("Invitee List Count: " + inviteeList.size());
					System.out.println("Invitee List: " + inviteeList.toString());

					for (String str : inviteeList) {
						boolean uname = user.isUserNameAvailable(str.trim());
						boolean email = user.isUserEmailAvailable(str.trim());

						if (uname && email) {
							isInviteeValid = false;
							JOptionPane.showMessageDialog(
									new Frame(),
									String.format("Invitee: %s \nInvalid user id / email !", str.trim()),
									"User Not Found!",
									JOptionPane.WARNING_MESSAGE
							);
							break;
						}
					}
				}

				if (isInviteeValid) {
					// submit
					if (txtName.getText().length() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Event name is required ! \nCannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
					} else if (timePicker1.getText().length() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Time is required ! \nCannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
					} else if (datePicker1.getText().length() == 0) {
						JOptionPane.showMessageDialog(new Frame(), "Date is required ! \nCannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
					} else {
						//Event event = new Event();
						event.setName(txtName.getText().trim());
						event.setTime(timePicker1.toString().trim());
						event.setDate(datePicker1.toString().trim());
						event.setLocation(txtLocation.getText().trim());
						event.setType(choiceType.getSelectedItem().trim());
						event.setNotes(txtrNotes.getText().trim());
						event.setAlert(choiceAlert.getSelectedItem().trim());
						event.setRepeatEvent(choiceRepeat.getSelectedItem().trim());
						event.setInviteeHash(inviteeList.toString());
						event.setInviteeList(inviteeList);
						try {
							int id = event.updateEvent();
							JOptionPane.showMessageDialog(new Frame(), "Edit successful!", "Event Added", JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} catch (Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(new Frame(), "Oops ... somethings went wrong!", "ERROR" , JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});

		// load data
		txtName.setText(event.getName());
		txtLocation.setText(event.getLocation());
		txtrNotes.setText(event.getNotes());
		timePicker1.setTime(LocalDateTime.parse(event.getDate(), dtf).toLocalTime());
		datePicker1.setDate(LocalDateTime.parse(event.getDate(), dtf).toLocalDate());
		choiceAlert.select(event.getAlert());
		choiceRepeat.select(event.getRepeatEvent());
		choiceType.select(event.getType());
		String inviteeTxt = event.getInviteeHash();
		inviteeTxt = inviteeTxt.substring(1, inviteeTxt.length() - 1);
		txtInvitees.setText(inviteeTxt.trim().replaceAll(" +", " "));
		System.out.println(String.format("[EditEvent] Alert: %s | Repeat: %s | Type: %s", event.getAlert(), event.getRepeatEvent(), event.getType()));

	}

}
