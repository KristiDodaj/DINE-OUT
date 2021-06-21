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
 * GUI FOR CHECK
 */
public class GUICheck {
    public GUICheck() {
        // FRAME
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setTitle("CHECK SPLIT");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // IMAGE

        // TEXT FIELDS
        JTextField people = new JTextField("ENTER AMOUNT OF PEOPLE") {
            @Override
            public void setBorder(Border border) {
                // No!
            }
        };
        people.setHorizontalAlignment(JTextField.CENTER);
        people.setBounds(145, 217, 203, 30);
        people.setVisible(true);
        frame.add(people);

        JTextField amount = new JTextField("ENTER TOTAL AMOUNT") {
            @Override
            public void setBorder(Border border) {
                // No!
            }
        };
        amount.setHorizontalAlignment(JTextField.CENTER);
        amount.setBounds(145, 150, 203, 30);
        amount.setOpaque(false);
        amount.setVisible(true);
        frame.add(amount);

        // BACKGROUND IMAGE
        JLabel background = new JLabel(
                new ImageIcon("C:\\Users\\Gezim\\Desktop\\VS\\Tip Calculator\\src\\tip\\interface.png"));
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

        people.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                people.setText("");
            }
        });

        amount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                amount.setText("");
            }
        });

        people.addActionListener(new ActionListener() {
            int totalpeople = 0;

            public void actionPerformed(ActionEvent e) {
                totalpeople = Integer.parseInt(people.getText());
                System.out.println(totalpeople);
                amount.addActionListener(new ActionListener() {
                    double totalmoney = 0;

                    public void actionPerformed(ActionEvent e) {
                        totalmoney = Double.parseDouble(amount.getText());
                        System.out.println(totalmoney);
                        BackEndCheck tip = new BackEndCheck(totalpeople, totalmoney);
                        calculate.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("TOTAL PRESSED");
                                answer.setText("$" + String.valueOf(tip.returnValue(totalpeople, totalmoney)));
                            }
                        });
                    }
                });
            }
        });

        amount.addActionListener(new ActionListener() {
            double totalmoney = 0;

            public void actionPerformed(ActionEvent e) {
                totalmoney = Double.parseDouble(amount.getText());
                System.out.println(totalmoney);
                people.addActionListener(new ActionListener() {
                    int totalpeople = 0;

                    public void actionPerformed(ActionEvent e) {
                        totalpeople = Integer.parseInt(people.getText());
                        System.out.println(totalpeople);
                        BackEndCheck tip = new BackEndCheck(totalpeople, totalmoney);
                        calculate.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                System.out.println("TOTAL PRESSED");
                                answer.setText("$" + String.valueOf(tip.returnValue(totalpeople, totalmoney)));
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
    }// end constructor
}// end class
