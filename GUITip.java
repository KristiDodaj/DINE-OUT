package tip;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * GUI FOR TIP
 */
public class GUITip {
    public GUITip() {
        // FRAME
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("TIP CALCULATOR");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // TEXT FIELDS
        JTextField bill = new JTextField("ENTER TOTAL BILL") {
            @Override
            public void setBorder(Border border) {
                // No!
            }
        };
        bill.setHorizontalAlignment(JTextField.CENTER);
        bill.setBounds(145, 217, 203, 30);
        bill.setVisible(true);
        frame.add(bill);

        JTextField amount = new JTextField("ENTER PREFERED TIP PERCENTAGE") {
            @Override
            public void setBorder(Border border) {
                // No!
            }
        };
        amount.setHorizontalAlignment(JTextField.CENTER);
        amount.setBounds(145, 150, 217, 30);
        amount.setOpaque(false);
        amount.setVisible(true);
        frame.add(amount);

        // BACKGROUND IMAGE
        JLabel background = new JLabel(
                new ImageIcon("filepath"));
        background.setVisible(true);
        background.setLayout(null);
        background.setSize(500, 500);
        frame.add(background);

        // BUTTONS
        JButton calculate = new JButton("CALCULATE");
        calculate.setBackground(Color.white);
        calculate.setForeground(Color.black);
        calculate.setBounds(95, 360, 120, 40);
        calculate.setVisible(true);
        background.add(calculate);

        JButton reset = new JButton("MENU");
        reset.setBackground(Color.white);
        reset.setForeground(Color.black);
        reset.setBounds(285, 360, 120, 40);
        reset.setVisible(true);
        background.add(reset);

        JLabel answer = new JLabel("$0.00");
        answer.setHorizontalAlignment(JLabel.CENTER);
        answer.setForeground(Color.white);
        answer.setFont(new Font("Serif", Font.PLAIN, 50));
        answer.setBounds(145, 50, 200, 50);
        answer.setVisible(true);
        background.add(answer);

        frame.setResizable(false);
        frame.revalidate();

        bill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bill.setText("");
            }
        });

        amount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                amount.setText("");
            }
        });

        bill.addActionListener(new ActionListener() {
            double totalmoney = 0;

            public void actionPerformed(ActionEvent e) {
                totalmoney = Double.parseDouble(bill.getText());
                System.out.println(totalmoney);
                amount.addActionListener(new ActionListener() {
                    double totalpercent = 0;

                    public void actionPerformed(ActionEvent e) {
                        totalpercent = Double.parseDouble(amount.getText());
                        System.out.println(totalpercent);
                        BackEndTip tip = new BackEndTip(totalmoney, totalpercent);
                        calculate.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("TOTAL PRESSED");
                                answer.setText("$" + String.valueOf(tip.returnTip(totalmoney, totalpercent)));
                            }
                        });
                    }
                });
            }
        });

        amount.addActionListener(new ActionListener() {
            double totalpercent = 0;

            public void actionPerformed(ActionEvent e) {
                totalpercent = Double.parseDouble(amount.getText());
                System.out.println(totalpercent);
                bill.addActionListener(new ActionListener() {
                    double totalmoney = 0;

                    public void actionPerformed(ActionEvent e) {
                        totalmoney = Double.parseDouble(bill.getText());
                        System.out.println(totalmoney);
                        BackEndTip tip = new BackEndTip(totalmoney, totalpercent);
                        calculate.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("TOTAL PRESSED");
                                answer.setText("$" + String.valueOf(tip.returnTip(totalmoney, totalpercent)));
                            }
                        });
                    }
                });
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                GUIMain main = new GUIMain();
            }
        });

    }
}
