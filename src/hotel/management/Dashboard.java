/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.*;

/**
 *
 * @author 2206p
 */
public class Dashboard extends JFrame implements ActionListener{

    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    JLabel l2;


    
     Dashboard() {

       mb = new JMenuBar();
        add(mb);


        m1 = new JMenu("Hotel Management");
        m1.setForeground(Color.BLUE);
        mb.add(m1);

        m2 = new JMenu("Admin");
        m2.setForeground(Color.BLUE);
        mb.add(m2);

        i1 = new JMenuItem("HOTEL RECEPTION");
         i1.setForeground(Color.BLUE);
         i1.addActionListener(this);
        m1.add(i1);

        i2 = new JMenuItem("ADD EMPLOYEE");
         i2.setForeground(Color.BLUE);
         i2.addActionListener(this);
        m2.add(i2);

        i3 = new JMenuItem("ADD ROOMS");
        i3.setForeground(Color.BLUE);
         i3.addActionListener(this);
        m2.add(i3);

        i4 = new JMenuItem("ADD DRIVERS");
         i4.setForeground(Color.BLUE);
         i4.addActionListener(this);
        m2.add(i4);

        mb.setBounds(0,0,1376,30);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/dash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1366, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
        NewLabel.setBounds(0, 0, 1366, 750);
        add(NewLabel);





        setLayout(null);
        setBounds(0,0,1366,750);
        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("HOTEL RECEPTION")) {
            new HotelReception().setVisible(true);
        } else if (e.getActionCommand().equals("ADD EMPLOYEE")) {
            new AddEmployee().setVisible(true);
        } else if (e.getActionCommand().equals("ADD ROOMS")) {
            new AddRoom().setVisible(true);
        } else if (e.getActionCommand().equals("ADD DRIVERS")) {
            new AddDrivers().setVisible(true);
        }
    }

    public static void main(String[] args){
        new Dashboard().setVisible(true);

    }
}






