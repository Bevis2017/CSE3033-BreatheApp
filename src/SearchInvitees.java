import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import java.awt.Color;
import java.awt.Panel;

import java.awt.Font;
import java.awt.Frame;

import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SearchInvitees extends JFrame {

	private JPanel contentPane;
	private JTextField txtMail;
	private JTextField txtInvitee;
	private ArrayList<String> inviteeList, resultList;
	private User user = new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchInvitees frame = new SearchInvitees(new JTextField(), new ArrayList<>());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SearchInvitees() {
		// nothing
	}

	/**
	 * Create the frame.
	 */
	public SearchInvitees(JTextField tf, ArrayList<String> al) {
		txtInvitee = tf;
		inviteeList = al;
		resultList = new ArrayList<>();

		setBackground(Color.WHITE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Search Invitee");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 370, 444);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(15, 16, 115, 29);
		panel.add(btnBack);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(SearchInvitees.class.getResource("/image/1154433-avatars[1].png")));
		lblImage.setBounds(-23, 0, 393, 444);
		panel.add(lblImage);
		
		JLabel lblSearchInvitee = new JLabel("SEARCH INVITEE");
		lblSearchInvitee.setBackground(Color.WHITE);
		lblSearchInvitee.setForeground(Color.BLACK);
		lblSearchInvitee.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSearchInvitee.setBounds(465, 28, 267, 60);
		contentPane.add(lblSearchInvitee);
		
		JLabel lblFindFriend = new JLabel("Find Your Friend ?");
		lblFindFriend.setForeground(Color.BLACK);
		lblFindFriend.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFindFriend.setBounds(517, 83, 170, 25);
		contentPane.add(lblFindFriend);
		
		JTextPane txtPaneMail = new JTextPane();
		txtPaneMail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPaneMail.setText("Enter your friend's username or email address at below ");
		txtPaneMail.setBounds(481, 131, 251, 70);
		contentPane.add(txtPaneMail);
		contentPane.setFocusable(true);
		
		//txtMail = new JTextField();
		//txtMail.setBounds(441, 231, 324, 41);
		//contentPane.add(txtMail);
		//txtMail.setColumns(10);

		JComboBox<Object> cbMail = new JComboBox<>();
		cbMail.setBounds(441, 231, 324, 41);
		cbMail.setEditable(true);
		contentPane.add(cbMail);

		// get the combo box' editor component
		JTextComponent editor = (JTextComponent) cbMail.getEditor().getEditorComponent();
		// change the editor's document to our BadDocument
		//editor.setDocument(new SearchInvitees());
		editor.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String keyword = cbMail.getEditor().getItem().toString().trim();
				System.out.println("JTextComponent: " + keyword);
				ResultSet rs = user.searchUserByName(keyword);
				resultList.clear(); // clear the list every time
				cbMail.removeAllItems();

				try {
					while (rs.next()) {
						cbMail.addItem(rs.getString("name"));
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}

				//cbMail.setModel(new DefaultComboBoxModel<>(resultList.toArray()));

				if (cbMail.isDisplayable()) cbMail.setPopupVisible(true);
			}
		});



		Button btnAdd = new Button("ADD");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.setBackground(new Color(255, 182, 193));
		btnAdd.setBounds(453, 346, 302, 41);
		contentPane.add(btnAdd);
		
		JOptionPane.showMessageDialog(new Frame(), "The mail format that you entered is incorrect !");
		JOptionPane.showMessageDialog(new Frame(), "The mail that you entered is not found !");
		JOptionPane.showMessageDialog(new Frame(), "The username that you entered is not found !");

		user.searchUserByName("test");
	}
}
