import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class BreatheTime extends JFrame {

    private JPanel contentPane;

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
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnBack.setBackground(SystemColor.activeCaption);
        btnBack.setBounds(15, 16, 115, 29);
        panel.add(btnBack);
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

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
                WebBrowser wb = new WebBrowser();
                wb.setTitle("MUSIC TIME");
                wb.setSize(540, 95);
                wb.loadLocalPage("/html/MusicTime.html");
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
                wb.setTitle("BREATHE TIME");
                wb.setSize(720, 450);
                wb.loadLocalPage("/html/BreathePlayer.html");
            }
        });

        Button btnFunTime = new Button("FUN FACT TIME");
        btnFunTime.setForeground(Color.WHITE);
        btnFunTime.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnFunTime.setBackground(new Color(255, 182, 193));
        btnFunTime.setBounds(695, 184, 205, 80);
        contentPane.add(btnFunTime);
        btnFunTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int n = rand.nextInt(10);

                if (n == 0) {
                    JOptionPane.showMessageDialog(null, "The average person spends 6 months of their lifetime waiting on a red light to turn green.", "Interesting Facts", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 1) {
                    JOptionPane.showMessageDialog(null, "A single cloud can weight more than 1 million pounds.", "Interesting Facts", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 2) {
                    JOptionPane.showMessageDialog(null, "10% of the World's population is left handed.", "Fun Facts", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 3) {
                    JOptionPane.showMessageDialog(null, "Chewing gum while you cut an onion will help keep you from crying.", "Fun Facts", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 4) {
                    JOptionPane.showMessageDialog(null, "Ketchup was used as a medicine back in the 1930's.", "Nutrition Facts", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 5) {
                    JOptionPane.showMessageDialog(null, "Coconut water can be used as blood plasma.", "Nutrition Facts", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 6) {
                    JOptionPane.showMessageDialog(null, "You breathe on average about 8,409,600 times a year.", "Unbelievable Facts", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 7) {
                    JOptionPane.showMessageDialog(null, "Our eyes are always the same size from birth, but our nose and ears never stop growing.", "Unbelievable Facts", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 8) {
                    JOptionPane.showMessageDialog(null, "A sheep, a duck and a rooster were the first passengers in a hot air balloon.", "Animal Facts", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 9) {
                    JOptionPane.showMessageDialog(null, "An ostrich's eye is bigger than its brain.", "Animal Facts", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(new Frame(), "There have some error!");
                }
            }
        });


        Button btnQuoteTime = new Button("QUOTE TIME");
        btnQuoteTime.setForeground(Color.WHITE);
        btnQuoteTime.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnQuoteTime.setBackground(new Color(255, 182, 193));
        btnQuoteTime.setBounds(695, 376, 205, 80);
        contentPane.add(btnQuoteTime);
        btnQuoteTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int n = rand.nextInt(6);
                String text;

                if (n == 0) {
                    text = "<html><body><div align='center'>\"Your mind will answer most questions if you learn to relax and wait for the answer.\"</div><p><div align='center'>- William Burroughs</div><p></body></html>";
                    JOptionPane.showMessageDialog(null, text, "Quote Message", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 1) {
                    text = "<html><body><div align='center'>\"Sometimes that most important thing in a whole day is the rest we take between two deep breaths.\"</div><p><div align='center'>- Etty Hillesum</div><p></body></html>";
                    JOptionPane.showMessageDialog(null, text, "Quote Message", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 2) {
                    text = "<html><body><div align='center'>\"Give your stress wings and let if fly away.\"</div><p><div align='center'>- Terri Guillemets</div><p></body></html>";
                    JOptionPane.showMessageDialog(null, text, "Quote Message", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 3) {
                    text = "<html><body><div align='center'>\"Life isn't as serious as the mind makes it out to be.\"</div><p><div align='center'>- Eckhart Tolle</div><p></body></html>";
                    JOptionPane.showMessageDialog(null, text, "Quote Message", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 4) {
                    text = "<html><body><div align='center'>\"How beautiful it is to do nothing, and then to rest afterward.\"</div><p><div align='center'>- Spanish Proverb</div><p></body></html>";
                    JOptionPane.showMessageDialog(null, text, "Quote Message", JOptionPane.PLAIN_MESSAGE);
                } else if (n == 5) {
                    text = "<html><body><div align='center'>\"Sometimes the most productive thing you can do is relax.\"</div><p><div align='center'>- Mark Black</div><p></body></html>";
                    JOptionPane.showMessageDialog(null, text, "Quote Message", JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(new Frame(), "There have some error!");
                }
            }
        });
    }

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
}
