package tripmanagementsystem1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeleteDetails extends JFrame implements ActionListener
{
    JButton delete;
    String username;
    DeleteDetails (String username)
    {
        this.username = username;
        setBounds(380,170,870,610);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        // Username Label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        // Show username
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        // Id Label
        JLabel lblid = new JLabel("Id");
        lblid.setBounds(30,110,150,25);
        add(lblid);
        // Show Id
        JLabel labelid = new JLabel();
        labelid.setBounds(220,110,150,25);
        add(labelid);
        
        // Number Label
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,170,150,25);
        add(lblnumber);
        // Show Number
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,170,150,25);
        add(labelnumber);
        
        // Name Label
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30,230,150,25);
        add(lblname);
        // Show Name
        JLabel labelname = new JLabel();
        labelname.setBounds(220,230,150,25);
        add(labelname);
        
        // Gender Label
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30,290,150,25);
        add(lblgender);
        // Show Gender
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220,290,150,25);
        add(labelgender);
        
        
        
        // Country Label
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500,50,150,25);
        add(lblcountry);
        // Show Country
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(690,50,150,25);
        add(labelcountry);
        
        // Address Label
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500,110,150,25);
        add(lbladdress);
        // Show Address
        JLabel labeladdress= new JLabel();
        labeladdress.setBounds(690,110,150,25);
        add(labeladdress);
        
        // Phone Label
        JLabel lblphone = new JLabel("Phone No.");
        lblphone.setBounds(500,170,150,25);
        add(lblphone);
        // Show Phone Number
        JLabel labelphone = new JLabel();
        labelphone.setBounds(690,170,150,25);
        add(labelphone);
        
        // Email Label
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(500,230,150,25);
        add(lblemail);
        // Show Email Id
        JLabel labelemail = new JLabel();
        labelemail.setBounds(690,230,150,25);
        add(labelemail);
        
        // Back Button
        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(350,350,100,25);
        delete.addActionListener(this);
        add(delete);
        
        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 185, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,400,600, 185);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i2);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600, 400,600,185);
        add(image2);
        
        
        // For Insert Data From Database
        try 
        {
           Connector c = new Connector();
           String query = "SELECT * FROM customer WHERE username = '"+username+"'";
           java.sql.ResultSet rs = c.s.executeQuery(query);
           while (rs.next())
           {
               labelusername.setText(rs.getString("username"));
               labelid.setText(rs.getString("id"));
               labelnumber.setText(rs.getString("number"));
               labelname.setText(rs.getString("name"));
               labelgender.setText(rs.getString("gender"));
               labelcountry.setText(rs.getString("country"));
               labeladdress.setText(rs.getString("address"));
               labelphone.setText(rs.getString("phone"));
               labelemail.setText(rs.getString("email"));
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
        try 
        {
           Connector c = new Connector();
           c.s.executeUpdate("delete from account where username = '"+username+"'");
           c.s.executeUpdate("delete from customer where username = '"+username+"'");
           c.s.executeUpdate("delete from bookpackage where username = '"+username+"'");
           c.s.executeUpdate("delete from bookhotel where username = '"+username+"'");
           
           JOptionPane.showMessageDialog(null, "Data Deleted Successfuly");
           System.exit(0);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public static void main (String[] args)
    {
        new DeleteDetails("").setVisible(true);
    }
}
