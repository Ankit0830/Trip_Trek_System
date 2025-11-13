package tripmanagementsystem1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class ViewPackage extends JFrame implements ActionListener
{
    JButton back;
    ViewPackage (String username)
    {
        setBounds(450,200,880,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS", SwingConstants.LEFT);
        text.setOpaque(true);
        text.setFont(new Font("Taboma", Font.BOLD,20));
        text.setBounds(40,5, 300, 25);
        add(text);
       
        
        
        // Username Label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,50,150,25);
        add(lblusername);
        // Show username
        JLabel labelusername = new JLabel();
        labelusername.setBounds(230,50,150,25);
        add(labelusername);
        
        // Package Label
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(40,90,150,25);
        add(lblpackage);
        
        // Show Package
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(230,90,150,25);
        add(labelpackage);
        
        
        // Total Persons Label
        JLabel lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40,130,150,25);
        add(lblpersons);
        // Show Person
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(230,130,150,25);
        add(labelpersons);
        
        
        // Id Label
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(40,170,150,25);
        add(lblid);
        // Show Id
        JLabel labelid = new JLabel();
        labelid.setBounds(230,170,150,25);
        add(labelid);
        
        
        // Number Label
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40,210,150,25);
        add(lblnumber);               
        // Show Number
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(230,210,150,25);
        add(labelnumber);
        
        
        // Phone Label
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(40,250,150,25);
        add(lblphone);
        // Show Phone Number
        JLabel labelphone = new JLabel();
        labelphone.setBounds(230,250,150,25);
        add(labelphone);
        
               
        // Price Label
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(40,290,150,25);
        add(lblprice);
        // Show Price
        JLabel labelprice = new JLabel();
        labelprice.setBounds(230,290,150,25);
        add(labelprice);
        
        
        // Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,360,100,25);
        back.addActionListener(this);
        add(back);
        
        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(420,10,400, 390);
        add(image);
       
        
        
        // For Insert Data From Database
        try 
        {
           Connector c = new Connector();
           String query = "SELECT * FROM bookpackage WHERE username = '"+username+"'";
           ResultSet rs = c.s.executeQuery(query);
           while (rs.next())
           {
               labelusername.setText(rs.getString("username"));
               labelpackage.setText(rs.getString("package"));
               labelpersons.setText(rs.getString("persons"));
               labelid.setText(rs.getString("id"));
               labelnumber.setText(rs.getString("number"));
               labelphone.setText(rs.getString("phone"));
               labelprice.setText(rs.getString("price"));
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
        new ViewPackage("").setVisible(true);
    }
}
