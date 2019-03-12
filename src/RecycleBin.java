import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RecycleBin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecycleBin frame = new RecycleBin();
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
	public RecycleBin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		setTitle("Breathe Application");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Recycle Bin");
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
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(RecycleBin.class.getResource("/image/1-512[1].png")));
		label_4.setBounds(-74, 89, 458, 447);
		panel.add(label_4);
		
		JLabel viewCalLbl = new JLabel("RECYCLE BIN");
		viewCalLbl.setForeground(Color.BLACK);
		viewCalLbl.setFont(new Font("Tahoma", Font.BOLD, 30));
		viewCalLbl.setBackground(Color.WHITE);
		viewCalLbl.setBounds(595, 16, 214, 60);
		contentPane.add(viewCalLbl);
		
		JList deletedList = new JList();
		deletedList.setToolTipText("this is deleted activity list");
		deletedList.setBounds(406, 72, 562, 452);
		contentPane.add(deletedList);
		
		Button button = new Button("RECOVER");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBackground(new Color(255, 182, 193));
		button.setBounds(528, 543, 336, 29);
		contentPane.add(button);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		JOptionPane.showMessageDialog(new Frame(), "Recover successful !");
	}
}
