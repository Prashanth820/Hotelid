/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

/**
 *
 * @author 2206p
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1,b2,b3;
    JLabel l1;


    public Login() {

        setBackground(new Color(169, 169, 169));
        setBounds(0, 0, 1366, 750);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);




        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(440, 150, 120, 50);
        l1.setForeground(Color.white);
        panel.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(440, 200, 120, 50);
        l2.setForeground(Color.white);
        panel.add(l2);

        textField = new JTextField();
        textField.setBounds(600, 150, 190, 30);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(600, 200, 190, 30);
        panel.add(passwordField);

        JLabel l3 = new JLabel("");
        l3.setBounds(377, 79, 46, 34);
        panel.add(l3);

        JLabel l4 = new JLabel("");
        l4.setBounds(377, 124, 46, 34);
        panel.add(l3);

        b1 = new JButton("Login");
        b1.addActionListener(this);

        b1.setForeground(new Color(46, 139, 87));
        b1.setBackground(Color.white);
        b1.setBounds(400, 280, 190, 39);
        panel.add(b1);

        b2 = new JButton("Create Account");
        b2.addActionListener(this);

        b2.setForeground(new Color(139, 69, 19));
        b2.setBackground(Color.white);
        b2.setBounds(650, 280, 190, 39);
        panel.add(b2);



        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(176, 224, 230));
        panel2.setBounds(0, 0, 1366, 750);
        panel.add(panel2);

        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/black.jpg"));
        Image i3 = i1.getImage().getScaledInstance(1366, 750,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        l1 = new JLabel(i2);
        panel2.add(l1);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            Boolean status = false;
            try {
                conn con = new conn();
                String sql = "select * from account where username=? and password=?";
                PreparedStatement st = con.c.prepareStatement(sql);

                st.setString(1, textField.getText());
                st.setString(2, passwordField.getText());

                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    this.setVisible(false);
                    new UserWelcomePage().setVisible(true);
                } else
                    JOptionPane.showMessageDialog(null, "Invalid Login...!.");

            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if(ae.getSource() == b2){
            setVisible(false);
            Signup su = new Signup();
            su.setVisible(true);
        }

    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

}

