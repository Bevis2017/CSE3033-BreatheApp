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

		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon(BreatheTime.class.getResource("/image/njy-lotus[1].png")));
		lblImage.setBounds(-83, 74, 487, 460);
		panel.add(lblImage);

		JLabel lblBreatheActivity = new JLabel("BREATHE ACTIVITY");
		lblBreatheActivity.setForeground(Color.BLACK);
		lblBreatheActivity.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblBreatheActivity.setBackground(Color.WHITE);
		lblBreatheActivity.setBounds(516, 32, 302, 60);
		contentPane.add(lblBreatheActivity);

		Button btnMusicTime = new Button("MUSIC TIME");
		btnMusicTime.setForeground(Color.WHITE);
		btnMusicTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMusicTime.setBackground(new Color(255, 182, 193));
		btnMusicTime.setBounds(443, 376, 205, 80);
		contentPane.add(btnMusicTime);
		btnMusicTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnMusicTime.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						WebBrowser wb = new WebBrowser();
						//wb.initAndShowGUI();
						//wb.setVisible(true);
						//wb.loadPage("https://www.youtube.com/watch?v=8Z5EjAmZS1o");
                        wb.loadPage("https://www.google.com/ncr");
					}
				});
			}
		});

		Button btnBreatheTime = new Button("BREATHE TIME");
		btnBreatheTime.setForeground(Color.WHITE);
		btnBreatheTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBreatheTime.setBackground(new Color(255, 182, 193));
		btnBreatheTime.setBounds(443, 184, 205, 80);
		contentPane.add(btnBreatheTime);
		btnBreatheTime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WebBrowser wb = new WebBrowser();
				//wb.initAndShowGUI();
				//wb.setVisible(true);
				wb.loadLocalPage("/html/BreathePlayer.html");
			}
		});

		Button btnFunTime = new Button("FUN FACT TIME");
		btnFunTime.setForeground(Color.WHITE);
		btnFunTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnFunTime.setBackground(new Color(255, 182, 193));
		btnFunTime.setBounds(695, 184, 205, 80);
		contentPane.add(btnFunTime);

		Button btnQuoteTime = new Button("QUOTE TIME");
		btnQuoteTime.setForeground(Color.WHITE);
		btnQuoteTime.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnQuoteTime.setBackground(new Color(255, 182, 193));
		btnQuoteTime.setBounds(695, 376, 205, 80);
		contentPane.add(btnQuoteTime);
	}
}
