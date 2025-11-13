package tripmanagementsystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class ViewBookedHotel extends JFrame implements ActionListener
{
    JButton back;
    ViewBookedHotel (String username)
    {
        setBounds(400,200,950,590);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS", SwingConstants.CENTER);
        text.setOpaque(true);
        text.setFont(new Font("Taboma", Font.BOLD,20));
        text.setBounds(0,0,getWidth(),25);
        add(text);
       
        
        
        // Username Label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,50,150,25);
        add(lblusername);
        // Show username
        JLabel labelusername = new JLabel();
        labelusername.setBounds(230,50,150,25);
        add(labelusername);
        
        // Hotel Name Label
        JLabel lblhotel = new JLabel("Hotel Name");
        lblhotel.setBounds(40,90,150,25);
        add(lblhotel);
        
        // Show Hotel Name
        JLabel labelhotel = new JLabel();
        labelhotel.setBounds(230,90,150,25);
        add(labelhotel);
        
        
        // Total Persons Label
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40,130,150,25);
        add(lblpersons);
        // Show Person
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(230,130,150,25);
        add(labelpersons);
        
        
        // Total Days Label
        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(40,170,150,25);
        add(lbldays);
        // Show Total Days
        JLabel labeldays = new JLabel();
        labeldays.setBounds(230,170,150,25);
        add(labeldays);
        
        
        // AC/Non-AC Label
        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(40,210,150,25);
        add(lblac);
        // Show AC/Non-AC
        JLabel labelac = new JLabel();
        labelac.setBounds(230,210,150,25);
        add(labelac);
        
        
        // Food Included Label
        JLabel lblfood = new JLabel("Food Included ?");
        lblfood.setBounds(40,250,150,25);
        add(lblfood);
        // Show Food Included ?
        JLabel labelfood = new JLabel();
        labelfood.setBounds(230,250,150,25);
        add(labelfood);
        
        
        // Id Label
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,290,150,25);
        add(lblid);
        // Show Id
        JLabel labelid = new JLabel();
        labelid.setBounds(230,290,150,25);
        add(labelid);
        
        
        // Number Label
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,330,150,25);
        add(lblnumber);               
        // Show Number
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(230,330,150,25);
        add(labelnumber);
        
        
        // Phone Label
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(40,370,150,25);
        add(lblphone);
        // Show Phone Number
        JLabel labelphone = new JLabel();
        labelphone.setBounds(230,370,150,25);
        add(labelphone);
        
               
        // Total Cost Label
        JLabel lblcost = new JLabel("Total Cost");
        lblcost.setBounds(40,410,150,25);
        add(lblcost);
        // Show Total Cost
        JLabel labelcost = new JLabel();
        labelcost.setBounds(230,410,150,25);
        add(labelcost);
        
        
        // Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,480,100,25);
        back.addActionListener(this);
        add(back);
        
        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(590, 540, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420,50,490, 480);
        add(image);
       
        
        
        // For Insert Data From Database
        try 
        {
           Connector c = new Connector();
           String query = "SELECT * FROM bookhotel WHERE username = '"+username+"'";
           ResultSet rs = c.s.executeQuery(query);
           while (rs.next())
           {
               labelusername.setText(rs.getString("username"));
               labelhotel.setText(rs.getString("name"));
               labelpersons.setText(rs.getString("persons"));
               labelid.setText(rs.getString("id"));
               labelnumber.setText(rs.getString("number"));
               labelphone.setText(rs.getString("phone"));
               labelcost.setText(rs.getString("price"));
               labelfood.setText(rs.getString("food"));
               labelac.setText(rs.getString("ac"));
               labeldays.setText(rs.getString("days"));
               
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        setVisible(true);
    }
    
    // Because useing abstract methods
    @Override
    public void actionPerformed (ActionEvent ae)
    {
        setVisible(false);
        dispose();
    }
    
    public static void main (String[] args)
    {
        new ViewBookedHotel("").setVisible(true);
    }
}
