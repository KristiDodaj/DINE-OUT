package tip;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class GUIMain {
    public GUIMain() {
        // FRAME AND BACKGROUND
        JFrame frame = new JFrame("DINE OUT");
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel background = new JLabel(
                new ImageIcon("C:\\Users\\Gezim\\Desktop\\VS\\Tip Calculator\\src\\tip\\dine.png"));
        background.setVisible(true);
        background.setLayout(null);
        background.setSize(500, 500);
        frame.add(background);

        // BUTTONS
        JButton tip = new JButton("TIP CALCULATOR") {
            @Override
            public void setBorder(Border border) {
                // No!
            }
        };
        tip.setFont(new Font("Arial", Font.BOLD, 15));
        tip.setBackground(Color.white);
        tip.setBounds(135, 214, 230, 44);
        tip.setOpaque(false);
        background.add(tip);

        JButton split = new JButton("SPLIT BILL") {
            @Override
            public void setBorder(Border border) {
                // No!
            }
        };
        split.setBackground(Color.white);
        split.setFont(new Font("Arial", Font.BOLD, 15));
        split.setBounds(135, 289, 230, 44);
        split.setOpaque(false);
        background.add(split);

        JButton quit = new JButton("QUIT") {
            @Override
            public void setBorder(Border border) {
                // No!
            }
        };
        quit.setBackground(Color.white);
        quit.setFont(new Font("Arial", Font.BOLD, 15));
        quit.setOpaque(false);
        quit.setBounds(190, 406, 120, 23);
        background.add(quit);

        frame.revalidate();
        frame.setResizable(false);

        tip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUITip tip = new GUITip();
            }
        });

        split.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUICheck tip = new GUICheck();
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });

    }
}
