package hotel.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class conventionHall extends JFrame{
    JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6;
    JComboBox c1,c2,c3,c4;

    public conventionHall(){
        getContentPane().setForeground(Color.BLUE);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Convention Hall Booking");

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(778,486);
        getContentPane().setLayout(null);

        JLabel Passportno = new JLabel("NAME");
        Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Passportno.setBounds(60, 30, 150, 27);
        add(Passportno);

        textField = new JTextField();
        textField.setBounds(200, 30, 150, 27);
        add(textField);

        JButton Next = new JButton("BOOK HALL");
        Next.setBounds(200, 420, 150, 30);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        add(Next);



        JLabel capacity= new JLabel("NO OF PEOPLE");
        capacity.setFont(new Font("Tahoma", Font.PLAIN, 17));
        capacity.setBounds(60, 80, 150, 27);
        add(capacity);

        String Capacity[] = {"50-100","100-500","500-1000","1000-2000","2000-5000"};
        c3 = new JComboBox(Capacity);
        c3.setBackground(Color.WHITE);
        c3.setBounds(200,80,150,30);
        add(c3);

        JLabel food= new JLabel("FOOD SERVICE");
        food.setFont(new Font("Tahoma", Font.PLAIN, 17));
        food.setBounds(60, 130, 150, 27);
        add(food);

        String Food[] = {"Plate Service","Cart Service","Plater Service","Buffet Service","Family Style Service"};
        c4 = new JComboBox(Food);
        c4.setBackground(Color.WHITE);
        c4.setBounds(200,130,150,30);
        add(c4);


        JLabel Address = new JLabel("EVENTS");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Address.setBounds(60, 170, 150, 27);
        add(Address);

        String course[] = {"Wedding","Engagement","Get Together","Birthday Party","Cocktail Party","Children Party","Sangeet Ceremony","Bridal Shower","Baby Shower"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(200,170,150,30);
        add(c1);

        JLabel Slots = new JLabel("SLOTS");
        Slots.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Slots.setBounds(60, 220, 150, 27);
        add(Slots);

        String slots[] = {"2 Hours slot ","4 hours slot","6 hours slot","8 hours slot","Fordays"};
        c2 = new JComboBox(slots);
        c2.setBackground(Color.WHITE);
        c2.setBounds(200,220,150,30);
        add(c2);

        JLabel Nationality = new JLabel("DATE");
        Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Nationality.setBounds(60, 270, 150, 27);
        add(Nationality);

        textField_3 = new JTextField();
        textField_3.setBounds(200, 270, 150, 27);
        add(textField_3);

        JLabel Name = new JLabel("PHONE NO");
        Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Name.setBounds(60, 320, 150, 27);
        add(Name);

        textField_4 = new JTextField();
        textField_4.setBounds(200, 320, 150, 27);
        add(textField_4);


        JLabel email = new JLabel("DEPOSIT");
        email.setFont(new Font("Tahoma", Font.PLAIN, 17));
        email.setBounds(60, 370, 150, 27);
        add(email);

        textField_6 = new JTextField();
        textField_6.setBounds(200, 370, 150, 27);
        add(textField_6);

        setVisible(true);

        JLabel AddPassengers = new JLabel("Convention Hall Booking");
        AddPassengers.setForeground(Color.BLUE);
        AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddPassengers.setBounds(450, 24, 442, 35);
        add(AddPassengers);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/icons/hall.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 440,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel image = new JLabel(i2);
        image.setBounds(360,30,500,440);
        add(image);





        Next.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String name = textField.getText();
                String date = textField_3.getText();
                String phone = textField_4.getText();
                String deposit = textField_6.getText();
                String s6 = (String)c1.getSelectedItem();
                String s7 = (String)c2.getSelectedItem();
                String s8 = (String)c3.getSelectedItem();
                String s9 = (String)c3.getSelectedItem();

                try {
                    conn c = new conn();
                    String str = "INSERT INTO hallbook values( '"+name+"', '"+s6+"','"+s7+"','"+s8+"','"+s9+"', '"+date+"', '"+phone+"', '"+deposit+"')";

                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Hall Booked");
                    setVisible(false);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setSize(900,550);
        setVisible(true);
        setLocation(300,90);

    }

    public static void main(String[] args){

        new conventionHall ();
    }
}
