/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management;

/**
 *
 * @author Pratiksha
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagement extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1;
        
        public HotelManagement() {
		
                setSize(1366,750);          // setContentPane(300,300,1366,390);   frame size
                setLayout(null);
                setLocation(0,0);

		l1 = new JLabel("");
                b1 = new JButton("Click Next");
                
                b1.setBackground(Color.black);
                b1.setForeground(Color.white);
				
                
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/second.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1366, 750,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                JLabel lid=new JLabel("HOTEL MANAGEMENT SYSTEM");
                lid.setBounds(80,300,1500,500);
                lid.setFont(new Font("Ta",Font.PLAIN,70));
                lid.setForeground(Color.red);
                l1.add(lid);
                
                b1.setBounds(1100,600,100,50);
		        l1.setBounds(0, 0, 1366, 750);
                
                l1.add(b1);
		add(l1);
 
                b1.addActionListener(this);
                setVisible(true);
                
                while(true){
                        lid.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
	}
        
        public void actionPerformed(ActionEvent ae){
                new Login().setVisible(true);
                this.setVisible(false);
                
        }
        
        public static void main(String[] args) {
                HotelManagement window = new HotelManagement();
                window.setVisible(true);			
	}
}