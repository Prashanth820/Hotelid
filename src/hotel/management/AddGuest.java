package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.*;

public class AddGuest extends JFrame implements ActionListener{
    JTextField t1,t2,t3,t4,t5;
    JButton b1,b2;
    JComboBox c1;
    Choice c2;
    JRadioButton r1,r2;



    AddGuest(){
        JLabel l1= new JLabel("New Customer Form");
        l1.setBounds(100,20,300,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);

        JLabel l2= new JLabel("ID");
        l2.setBounds(35,80,100,20);
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l2);

        c1= new JComboBox( new String[]{"Passport","voter-id Card","Driving License", "Aadhar Card"});
        c1.setBounds(350,80,150,25);
        add(c1);




        JLabel l3= new JLabel("Number");
        l3.setBounds(35,120,100,20);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l3);

        t1 = new JTextField();
        t1.setBounds(350,120,150,25);
        add(t1);


        JLabel l4= new JLabel("Name");
        l4.setBounds(35,160,100,20);
        l4.setForeground(Color.BLUE);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l4);

        t2 = new JTextField();
        t2.setBounds(350,160,150,25);
        add(t2);

        JLabel l5= new JLabel("Gender");
        l5.setBounds(35,200,100,20);
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l5);

        r1 = new JRadioButton("Male");
        r1.setBounds(350,200,60,25);
        r1.setBackground(Color.WHITE);
        add(r1);
        r1 = new JRadioButton("FeMale");
        r1.setBounds(430,200,60,25);
        r1.setBackground(Color.WHITE);
        add(r1);




        JLabel l6= new JLabel("Country");
        l6.setBounds(35,240,100,20);
        l6.setForeground(Color.BLUE);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l6);

        t3 = new JTextField();
        t3.setBounds(350,240,150,25);
        add(t3);

        JLabel l7= new JLabel("Allocated Room Number");
        l7.setBounds(35,280,250,20);
        l7.setForeground(Color.BLUE);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l7);

        c2 = new Choice();
        try{
            conn c = new conn();
            String str = "Select * from room";
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next())
            {
              c2.add(rs.getString("room"));

            }

        }catch(Exception e){

        }

        c2.setBounds(350,280,150,25);
        add(c2);





        JLabel l8= new JLabel("Checked In");
        l8.setBounds(35,320,100,20);
        l8.setForeground(Color.BLUE);
        l8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l8);

        t4 = new JTextField();
        t4.setBounds(350,320,150,25);
        add(t4);

        JLabel l9= new JLabel("Deposit");
        l9.setBounds(35,360,100,20);
        l9.setForeground(Color.BLUE);
        l9.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l9);

        t5 = new JTextField();
        t5.setBounds(350,360,150,25);
        add(t5);

        b1 = new JButton("Add Guest");
        b1.setBackground(Color.BLACK);
        b1.setBounds(35,440,170,25);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setBounds(280,440,170,25);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);



        getContentPane().setBackground(Color.WHITE);


        setLayout((null));
        setBounds(500,200,1000,700);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1)
        {
            String id = (String) c1.getSelectedItem();
            String number = t1.getText();
            String name = t1.getText();
            String gender = null;

            if (r1.isSelected()) {
                gender = "Male";
            } else if (r2.isSelected()) {

                gender = "Female";
            }

            String Country = t3.getText();
            String room = c2.getSelectedItem();
            String status = t4.getText();
            String deposit = t5.getText();
            String str = " insert into customer values('" + id + "','" + number + "','" + name + "','" + gender + "','" + room + "','" + status + "','" + deposit + "')";

            try {
                conn c = new conn();
                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "New Guest Added");
                new HotelReception().setVisible(true);
                this.setVisible(false);
            } catch (Exception e1) {
            }

        }else if (e.getSource() == b2) {
            new HotelReception().setVisible(true);
            this.setVisible(false);
        }
    }





            public static void main (String[] args){
        new AddGuest().setVisible(true);

    }
}
