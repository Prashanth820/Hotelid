package hotel.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class AdminLogin extends JFrame implements ActionListener{

    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;


    AdminLogin(){
        super("Login");

        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(440, 150, 120, 50);
        l1.setForeground(Color.white);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(440, 200, 120, 50);
        l2.setForeground(Color.white);
        add(l2);

        t1=new JTextField();
        t1.setBounds(600, 150, 190, 30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(600, 200, 190, 30);
        add(t2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/black.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366,750,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1366,750);
        add(l3);


        b1 = new JButton("Login");
        b1.setBounds(400, 280, 190, 39);

        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(650, 280, 190, 39);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);

        b2.addActionListener(this);


        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(1366,750);
        setLocation(0,0);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c1 = new conn();
                String u = t1.getText();
                String v = t2.getText();

                String q = "select * from login where username='"+u+"' and password='"+v+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    new Dashboard().setVisible(true);
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    setVisible(false);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource()==b2){
            System.exit(0);
        }
    }
    public static void main(String[] arg){
        new AdminLogin();
    }
}

