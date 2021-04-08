package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserWelcomePage extends JFrame  implements ActionListener {
    JButton b1, b2;
    JLabel l2;

    UserWelcomePage() {

        JLabel l1 = new JLabel("WELCOME TO TAJ HOTEL");
        l1.setBounds(450, 40, 500, 50);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(l1);

        JLabel l2 = new JLabel("Experience The Best Customer Service In a Hotel");
        l2.setBounds(400, 200, 700, 40);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(l2);

        b1 = new JButton("Check Room Availability");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(400, 350, 220, 40);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Book Room");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(800, 350, 220, 40);
        b2.addActionListener(this);
        add(b2);


        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/first.jpg"));
        Image i11 = i10.getImage().getScaledInstance(1366, 750, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l12 = new JLabel(i12);
        l12.setBounds(0, 0, 1366, 750);
        add(l12);

        setLayout(null);
        setBounds(0, 0, 1366, 750);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            try {
                new SearchRoom().setVisible(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else if (e.getSource() == b2) {
            new BookRoom().setVisible(true);

        }
    }

    public static void main(String[] args) {
        new UserWelcomePage().setVisible(true);

    }
}

