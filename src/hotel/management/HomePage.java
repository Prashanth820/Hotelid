package hotel.management;


import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class HomePage extends JFrame  implements ActionListener {

    JButton b1,b2;
    JLabel l2;

    HomePage(){

        JLabel l1= new JLabel("WELCOME ");
        l1.setBounds(600,25,500,50);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 40));
        add(l1);

        JLabel l2= new JLabel("Select User Type");
        l2.setBounds(570,200,300,40);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 30));
        add(l2);

        b1=new JButton("User");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(430,350,170,40);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Admin");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(800,350,170,40);
        b2.addActionListener(this);
        add(b2);


        ImageIcon i10= new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/second.jpg"));
        Image i11 = i10.getImage().getScaledInstance(1366,750,Image.SCALE_DEFAULT);
        ImageIcon i12 =  new ImageIcon(i11);
        JLabel l12= new JLabel(i12);
        l12.setBounds(0,0,1366,750);
        add(l12);

        setLayout(null);
        setBounds(0,0,1366,750);
        setVisible(true);

     }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == b1){
            new Login().setVisible(true);
        }else if(e.getSource() == b2){
            new AdminLogin().setVisible(true);

        }
    }

    public static void main (String[] args){
        new HomePage().setVisible(true);

    }




}
