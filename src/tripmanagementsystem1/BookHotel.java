package tripmanagementsystem1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener
{
    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookhotel, back;

    public BookHotel(String username) 
    {
        this.username = username;
        setBounds(350,200,1050,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel text = new JLabel("BOOK HOTEL", SwingConstants.CENTER);
        text.setOpaque(true);
        text.setBounds(0,0,getWidth(),30);
        text.setFont(new Font("Tahome", getFont().BOLD, 20));
        add(text);
        
        // Username Label
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblusername.setBounds(40,70,100,20);
        add(lblusername);
        
        // Show username
        labelusername = new JLabel();
        labelusername.setFont(new Font("Tahome", getFont().BOLD, 16));
        labelusername.setBounds(250,70,200,20);
        add(labelusername);
        
        // Select Package Label
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblpackage.setBounds(40,110,150,20);
        add(lblpackage);
        
        // DropDown
        chotel = new Choice();
        chotel.setBounds(250,110,180,20);
        add(chotel);
        
        try 
        {
            Connector c = new Connector();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next())
            {
                chotel.add(rs.getString("name"));
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        // Total Persons Label
        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblperson.setBounds(40,150,150,25);
        add(lblperson);
        
        // Text Field
        tfpersons = new JTextField("1");
        tfpersons.setFont(new Font("Tahome", getFont().BOLD, 14));
        tfpersons.setBounds(250,150,180,25);
        add(tfpersons);
        
        
        // Total Day Label
        JLabel lblday = new JLabel("No. Of Days");
        lblday.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblday.setBounds(40,190,150,25);
        add(lblday);
        
        // Text Field
        tfdays = new JTextField("1");
        tfdays.setFont(new Font("Tahome", getFont().BOLD, 14));
        tfdays.setBounds(250,190,180,25);
        add(tfdays);
        
        
        // Total AC / Non-Ac Label
        JLabel lblac = new JLabel("AC / Non-AC");
        lblac.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblac.setBounds(40,230,150,25);
        add(lblac);
        
        // DropDown
        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setFont(new Font("Tahome", getFont().BOLD, 14));
        cac.setBounds(250,230,180,20);
        add(cac);
        
        
        // Total Food Included (yes or no) Label
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblfood.setBounds(40,270,150,25);
        add(lblfood);
        
        // DropDown
        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setFont(new Font("Tahome", getFont().BOLD, 14));
        cfood.setBounds(250,270,180,20);
        add(cfood);
        
        
        
        // Id Label
        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblid.setBounds(41,310,150,20);
        add(lblid);
        
        // Show Id
        labelid = new JLabel();
        labelid.setFont(new Font("Tahome", getFont().BOLD, 16));
        labelid.setBounds(250,310,200,20);
        add(labelid);
        
        // Number Label
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblnumber.setBounds(40,350,150,25);
        add(lblnumber);
        
        // Show Number
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahome", getFont().BOLD, 16));
        labelnumber.setBounds(250,350,200,25);
        add(labelnumber);
        
        
        // Phone Label
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblphone.setBounds(40,390,150,20);
        add(lblphone);
        
        // Show Phone
        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahome", getFont().BOLD, 16));
        labelphone.setBounds(250,390,200,25);
        add(labelphone);
        
        // Price Label
        JLabel lblprice = new JLabel("Total Price");
        lblprice.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblprice.setBounds(40,430,150,25);
        add(lblprice);
        
        // Show Price
        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahome", getFont().BOLD, 16));
        labelprice.setBounds(250,430,200,25);
        add(labelprice);
        
        
        // For Insert Data From Database
        try 
        {
           Connector c = new Connector();
           String query = "SELECT * FROM customer WHERE username = '"+username+"'";
           ResultSet rs = c.s.executeQuery(query);
           while (rs.next())
           {
               labelusername.setText(rs.getString("username"));
               labelid.setText(rs.getString("id"));
               labelnumber.setText(rs.getString("number"));
               labelphone.setText(rs.getString("phone"));
           }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(40,490,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBackground(Color.BLACK);
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setBounds(180,490,120,25);
        bookhotel.addActionListener(this);
        add(bookhotel);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(320,490,120,25);
        back.addActionListener(this);
        add(back);
        
        
         // Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,500, 470);
        image.setLayout(null);
        add(image);
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed (ActionEvent ae)
    {
        if (ae.getSource() == checkprice)
        {
            try
            {
                Connector con = new Connector();
//                ResultSet rs = c.s.executeQuery("SELECT * FROM WHERE NAME = '" + chotel.getSelectedItem() + "'");
                ResultSet rs = con.s.executeQuery("SELECT * FROM hotel WHERE name = '" + chotel.getSelectedItem() + "'");
                while(rs.next())
                {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    
                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    
                    String acselected = cac.getSelectedItem();
                    String foodslected = cfood.getSelectedItem();
                    
                    
                    if (persons * days > 0)
                    {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;          //Use Turnary operater
                        total += foodslected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons *days;
                        labelprice.setText("Rs " + total);
                    }
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "Please enter valid number of persons and days");
                    }
                }
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        } 
        else if (ae.getSource() == bookhotel) 
        {
            try 
            {
                Connector c = new Connector();
                c.s.executeUpdate
                (
                    "INSERT INTO bookhotel VALUES('" 
                    + labelusername.getText() + "','" 
                    + chotel.getSelectedItem() + "', '" 
                    + tfpersons.getText() + "', '" 
                    + tfdays.getText() + "', '" 
                    + cac.getSelectedItem() + "', '" 
                    + cfood.getSelectedItem() + "', '" 
                    + labelid.getText() + "', '" 
                    + labelnumber.getText() + "', '" 
                    + labelphone.getText() + "', '" 
                    + labelprice.getText() + "')"
                );

                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error while booking hotel: " + e.getMessage());
            }
        } 
        else if (ae.getSource() == back) 
        {
            setVisible(false);
        }
    }
    
    public static void main (String[] args)
    {
        new BookHotel("abc@123gmail.com");
    }
}
