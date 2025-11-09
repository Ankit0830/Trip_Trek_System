package tripmanagementsystem1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener
{
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labelprice;
    JButton checkprice, bookpackage, back;

    public BookPackage(String username) 
    {
        this.username = username;
        setBounds(350,200,1050,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel text = new JLabel("BOOK PACKAGE", SwingConstants.CENTER);
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
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblpackage.setBounds(40,110,150,20);
        add(lblpackage);
        
        // DropDown
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setFont(new Font("Plan", getFont().BOLD, 15));
        cpackage.setBounds(250,110,180,20);
        add(cpackage);
        
        // Total Persons Label
        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblperson.setBounds(40,150,150,25);
        add(lblperson);
        
        // Text Field
        tfpersons = new JTextField("1");
        tfpersons.setFont(new Font("Tahome", getFont().BOLD, 16));
        tfpersons.setBounds(250,150,180,25);
        add(tfpersons);
        
        // Id Label
        JLabel lblid = new JLabel("Id");
        lblid.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblid.setBounds(41,190,150,20);
        add(lblid);
        
        // Show Id
        labelid = new JLabel();
        labelid.setFont(new Font("Tahome", getFont().BOLD, 16));
        labelid.setBounds(250,190,200,20);
        add(labelid);
        
        // Number Label
        JLabel lblnumber = new JLabel("Number");
        lblnumber.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblnumber.setBounds(40,230,150,25);
        add(lblnumber);
        
        // Show Number
        labelnumber = new JLabel();
        labelnumber.setFont(new Font("Tahome", getFont().BOLD, 16));
        labelnumber.setBounds(250,230,200,25);
        add(labelnumber);
        
        
        // Phone Label
        JLabel lblphone = new JLabel("Phone");
        lblphone.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblphone.setBounds(40,270,150,20);
        add(lblphone);
        
        // Show Phone
        labelphone = new JLabel();
        labelphone.setFont(new Font("Tahome", getFont().BOLD, 16));
        labelphone.setBounds(250,270,200,25);
        add(labelphone);
        
        // Price Label
        JLabel lblprice = new JLabel("Total Price");
        lblprice.setFont(new Font("Tahome", getFont().BOLD, 16));
        lblprice.setBounds(40,310,150,25);
        add(lblprice);
        
        // Show Price
        labelprice = new JLabel();
        labelprice.setFont(new Font("Tahome", getFont().BOLD, 16));
        labelprice.setBounds(250,310,200,25);
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
        checkprice.setBounds(40,380,120,25);
        checkprice.addActionListener(this);
        add(checkprice);
        
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(180,380,120,25);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(320,380,120,25);
        back.addActionListener(this);
        add(back);
        
        
         // Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/booking.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,50,500, 390);
        image.setLayout(null);
        add(image);
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed (ActionEvent ae)
    {
        if (ae.getSource() == checkprice)
        {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gold Package"))
            {
                cost += 12000;
            }
            else if (pack.equals("Silver Package"))
            {
                cost += 25000;
            }
            else 
            {
                cost += 32000;
            }
            
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs "+ cost);
        }
        else if (ae.getSource() == bookpackage)
        {
            try 
            {
                Connector c = new Connector();
//                String query = "UPDATE  customer SET username = '" + username + "',id = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', country = '" + country + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "'";
                c.s.executeUpdate("INSERT INTO bookpackage VALUES('" + labelusername.getText() + "','" + cpackage.getSelectedItem() + "', '" + tfpersons.getText() + "', '" + labelid.getText() + "', '" + labelnumber.getText() + "', '" + labelphone.getText() + "', '" + labelprice.getText() + "')");
                
                
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }
        else 
        {
            setVisible(false);
        }
    }
    
    public static void main (String[] args)
    {
        new BookPackage("abc@123gmail.com");
    }
}
