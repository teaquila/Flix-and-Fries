package Project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

class SRating implements ActionListener {

    JLabel bg;
    JLabel L1;
    JTextField tf;
    String S, Name;

    SRating(String s, String name) {

        S = s;
        Name = name;

        JFrame frm = new JFrame("SRating");
        frm.setSize(1600, 900);
        frm.setLocationRelativeTo(null);
        
        ImageIcon bgimg = new ImageIcon("rating_bg.jpg");
        Image img = bgimg.getImage();
        Image temp_img = img.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
        bgimg = new ImageIcon(temp_img);
        bg = new JLabel("", bgimg, JLabel.CENTER);
        bg.setBounds(0, 0, 1600, 900);
        frm.add(bg);

        frm.setLayout(new FlowLayout());
        frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
        frm.setVisible(true);

        JButton exit = new JButton("Exit");
        exit.setBounds(50, 20, 100, 30);
        bg.add(exit);

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                frm.dispose();

            }
        });

        JButton back = new JButton("Back");
        back.setBounds(50, 70, 100, 30);
        bg.add(back);

        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                new SDisplay(s, name);
            }
        });

        L1 = new JLabel("");
        L1.setText("ENTER YOUR RATING");
        L1.setBounds(550, 170, 1600, 40);
        L1.setForeground(new Color(255, 255, 255));
        L1.setFont(new Font("Arial", Font.BOLD, 48));
        bg.add(L1);

        tf = new JTextField(50);
        tf.setBounds(750, 270, 100, 40);
        tf.setFont(new Font("Lato", Font.PLAIN, 20));
        bg.add(tf);

        JButton add = new JButton("Add");
        add.setBounds(750, 330, 100, 40);
        bg.add(add);
        add.addActionListener(this);

    } // constructor

    public void actionPerformed(ActionEvent ae) {
        if (tf.getText().length() == 0 || Float.parseFloat(tf.getText()) > 10 || Float.parseFloat(tf.getText()) < 0)
            JOptionPane.showMessageDialog(null, "Enter a rating between 0 and 10!");

        else {
            try {
                File file = new File("ratings-series.txt");
                FileWriter rs = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(rs);
                bw.write("\n");
                bw.write(S.toLowerCase());
                bw.write(tf.getText());
                bw.write("\n");
                bw.close();
            } catch (IOException a) {
                System.out.println("an IO error occurred");
            }

            new SDisplay(S, Name);

        }
    }

}
