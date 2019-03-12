import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import java.awt.TextArea;
import java.awt.Choice;
import javax.swing.JTextPane;
import java.awt.List;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Button;

public class EditEvent extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtLocation;
	private JTextField txtInvitees;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEvent frame = new EditEvent();
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
	public EditEvent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(EditEvent.class.getResource("/image/V2[1].png")));
		lblNewLabel.setBounds(197, 220, 173, 159);
		panel.add(lblNewLabel);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(EditEvent.class.getResource("/image/calendar[1].png")));
		label_4.setBounds(54, 79, 270, 425);
		panel.add(label_4);
		
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
		
		JLabel label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(524, 70, 27, 20);
		label.setToolTipText("Event name is required.");
		contentPane.add(label);
		
		txtName = new JTextField();
		txtName.setColumns(5);
		txtName.setBounds(586, 70, 336, 29);
		contentPane.add(txtName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblType.setBounds(424, 117, 101, 20);
		contentPane.add(lblType);
		
		Choice choiceType = new Choice();
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
		
		JLabel lblRepeat = new JLabel("Repeat");
		lblRepeat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRepeat.setBounds(424, 305, 101, 20);
		contentPane.add(lblRepeat);
		
		Choice choiceRepeat = new Choice();
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
		
		Choice choiceAlert = new Choice();
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
		
		txtInvitees = new JTextField();
		txtInvitees.setColumns(5);
		txtInvitees.setBounds(586, 493, 336, 29);
		contentPane.add(txtInvitees);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(617, 224, 4, 22);
		contentPane.add(textArea);
		
		JTextArea txtrNotes = new JTextArea();
		txtrNotes.setText("Write something...");
		txtrNotes.setEditable(true);
		txtrNotes.setBounds(586, 399, 336, 80);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtrNotes.setBorder(border);
		contentPane.add(txtrNotes);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(468, 211, 27, 20);
		label_1.setToolTipText("Time is required.");
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(468, 258, 27, 20);
		label_2.setToolTipText("Date is required.");
		contentPane.add(label_2);
		
		Button btnAdd = new Button("EDIT");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBackground(new Color(255, 182, 193));
		btnAdd.setBounds(586, 540, 336, 29);
		contentPane.add(btnAdd);
		
		JOptionPane.showMessageDialog(new Frame(), "Edit successful !");
		JOptionPane.showMessageDialog(new Frame(), "Cannot be empty ! Event name is required !");
		JOptionPane.showMessageDialog(new Frame(), "Cannot be empty ! Time is required !");
		JOptionPane.showMessageDialog(new Frame(), "Cannot be empty ! Date is required !");
		
	}
}
