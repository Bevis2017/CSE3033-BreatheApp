import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BreatheTime extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BreatheTime frame = new BreatheTime();
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
	public BreatheTime() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Breathe Activity");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setLayout(null);
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 370, 594);
		contentPane.add(panel);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(SystemColor.activeCaption);
		btnBack.setBounds(15, 16, 115, 29);
		panel.add(btnBack);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(BreatheTime.class.getResource("/image/njy-lotus[1].png")));
		label_1.setBounds(-83, 74, 487, 460);
		panel.add(label_1);
		
		JLabel lblSummary = new JLabel("BREATHE ACTIVITY");
		lblSummary.setForeground(Color.BLACK);
		lblSummary.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblSummary.setBackground(Color.WHITE);
		lblSummary.setBounds(516, 32, 302, 60);
		contentPane.add(lblSummary);
		
		Button btnDay = new Button("MUSIC TIME");
		btnDay.setForeground(Color.WHITE);
		btnDay.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDay.setBackground(new Color(255, 182, 193));
		btnDay.setBounds(443, 376, 205, 80);
		contentPane.add(btnDay);
		
		Button button = new Button("BREATHE TIME");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 20));
		button.setBackground(new Color(255, 182, 193));
		button.setBounds(443, 184, 205, 80);
		contentPane.add(button);
		
		Button button_1 = new Button("FUN FACT TIME");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_1.setBackground(new Color(255, 182, 193));
		button_1.setBounds(695, 184, 205, 80);
		contentPane.add(button_1);
		
		Button button_2 = new Button("QUOTE TIME");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		button_2.setBackground(new Color(255, 182, 193));
		button_2.setBounds(695, 376, 205, 80);
		contentPane.add(button_2);
	}
}
