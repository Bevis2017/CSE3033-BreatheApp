import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(RecycleBin.class.getResource("/image/1-512[1].png")));
		lblImage.setBounds(-74, 89, 458, 447);
		panel.add(lblImage);
		
		JLabel lblRecycleBin = new JLabel("RECYCLE BIN");
		lblRecycleBin.setForeground(Color.BLACK);
		lblRecycleBin.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRecycleBin.setBackground(Color.WHITE);
		lblRecycleBin.setBounds(595, 16, 214, 60);
		contentPane.add(lblRecycleBin);
		
		JList deletedList = new JList();
		deletedList.setToolTipText("this is deleted activity list");
		deletedList.setBounds(406, 72, 562, 452);
		contentPane.add(deletedList);
		
		Button btnRecover = new Button("RECOVER");
		btnRecover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRecover.setForeground(Color.WHITE);
		btnRecover.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRecover.setBackground(new Color(255, 182, 193));
		btnRecover.setBounds(528, 543, 336, 29);
		contentPane.add(btnRecover);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		JOptionPane.showMessageDialog(new Frame(), "Recover successful !");
	}
}
