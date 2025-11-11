package tripmanagementsystem1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




public class DashBoard extends JFrame implements ActionListener
{
    JButton viewPersonalDetails, addPersonalDetails, updatePersonalDetails, 
            checkpackages, bookpackage, viewpackage,viewhotels, destinations;
    
    String username;
    DashBoard(String username)
    {
        this.username = username;
//        setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        //Dashboard Panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(255, 255, 255, 40));
        p1.setBounds(0,0,1600,65);
        add(p1);
        
        //Dashboard Icon
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0,100, 90);
        p1.add(icon);
        
        //Dashboard 
        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading .setForeground(Color.WHITE);
        heading.setFont(new Font("taboma", Font.BOLD, 30));
        p1.add(heading);
        
        //Dashboard second panel
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,900);
        add(p2);
        
        // Add personal betails button 
        // Also known Add Customer 
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBackground(new Color (0,0,102));
        addPersonalDetails.setForeground(Color.WHITE);
        addPersonalDetails.setFont(new Font("Tahama", Font.PLAIN, 20));
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        // Update button
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBackground(new Color (0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahama", Font.PLAIN, 20));
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        // View Details button
        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBackground(new Color (0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahama", Font.PLAIN, 20));
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setMargin(new Insets(0,10,0,10)); 
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        // Delete button
        JButton deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBackground(new Color (0,0,102));
        deletePersonalDetails.setForeground(Color.WHITE);
        deletePersonalDetails.setFont(new Font("Tahama", Font.PLAIN, 20));
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        p2.add(deletePersonalDetails);
        
        
        //Check Package button
        checkpackages = new JButton("Check Package");
        checkpackages.setBackground(new Color (0,0,102));
        checkpackages.setForeground(Color.WHITE);
        checkpackages.setFont(new Font("Tahama", Font.PLAIN, 20));
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        
        // Booking Button
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(new Color (0,0,102));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahama", Font.PLAIN, 20));
        bookpackage.setBounds(0,250,300,50);
        bookpackage.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        bookpackage.addActionListener(this);
        p2.add(bookpackage);
        
        
        // View Package Button
        viewpackage = new JButton("View Package");
        viewpackage.setBackground(new Color (0,0,102));
        viewpackage.setForeground(Color.WHITE);
        viewpackage.setFont(new Font("Tahama", Font.PLAIN, 20));
        viewpackage.setBounds(0,300,300,50);
        viewpackage.setMargin(new Insets(0,10,0,10));                 //Using set Margin     
        viewpackage.addActionListener(this);
        p2.add(viewpackage);
        
        // View Hotels Botton
        viewhotels = new JButton("View Hotels");
        viewhotels.setBackground(new Color (0,0,102));
        viewhotels.setForeground(Color.WHITE);
        viewhotels.setFont(new Font("Tahama", Font.PLAIN, 20));
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        // Hotel Booking button
        JButton bookHotels = new JButton("Book Hotel");
        bookHotels.setBackground(new Color (0,0,102));
        bookHotels.setForeground(Color.WHITE);
        bookHotels.setFont(new Font("Tahama", Font.PLAIN, 20));
        bookHotels.setBounds(0,400,300,50);
        bookHotels.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        p2.add(bookHotels);
        
        
        // View Booked Hotel button
        JButton viewbookhotels = new JButton("View Booked Hotels");
        viewbookhotels.setBackground(new Color (0,0,102));
        viewbookhotels.setForeground(Color.WHITE);
        viewbookhotels.setFont(new Font("Tahama", Font.PLAIN, 20));
        viewbookhotels.setBounds(0,450,300,50);
        viewbookhotels.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        p2.add(viewbookhotels);
        
        // Destination button
        destinations = new JButton("Destination");
        destinations.setBackground(new Color (0,0,102));
        destinations.setForeground(Color.WHITE);
        destinations.setFont(new Font("Tahama", Font.PLAIN, 20));
        destinations.setBounds(0,500,300,50);
        destinations.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        destinations.addActionListener(this);
        p2.add(destinations);
        
        // Payments button
        JButton payments = new JButton("Payments");
        payments.setBackground(new Color (0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahama", Font.PLAIN, 20));
        payments.setBounds(0,550,300,50);
        payments.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        p2.add(payments);
        
        // Calculators button
        JButton calculators = new JButton("Calculators");
        calculators.setBackground(new Color (0,0,102));
        calculators.setForeground(Color.WHITE);
        calculators.setFont(new Font("Tahama", Font.PLAIN, 20));
        calculators.setBounds(0,600,300,50);
        calculators.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        p2.add(calculators);
        
        // NotePad button
        JButton notepad = new JButton("Notepad");
        notepad.setBackground(new Color (0,0,102));
        notepad.setForeground(Color.WHITE);
        notepad.setFont(new Font("Tahama", Font.PLAIN, 20));
        notepad.setBounds(0,650,300,50);
        notepad.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        p2.add(notepad);
        
        // About button
        JButton about = new JButton("About");
        about.setBackground(new Color (0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahama", Font.PLAIN, 20));
        about.setBounds(0,700,300,50);
        about.setMargin(new Insets(0,10,0,10));                 //Using set Margin 
        p2.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/XPosC9.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0,1650, 1000);
        add(image);
        
        JLabel text = new JLabel("Trip Management System");
        text.setBounds(400,60,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN,55));
        image.add(text);
        
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed (ActionEvent ae)
    {
        if (ae.getSource() == addPersonalDetails)
        {
//            System.out.println("Add ");
            new AddCustomer(username);
        }
        else if (ae.getSource() == viewPersonalDetails)
        {
            new ViewCustomer(username);
        }
        else if (ae.getSource() == updatePersonalDetails)
        {
            new UpdateCustomer(username);
        }
        else if (ae.getSource() == checkpackages)
        {
            new CheckPackage();
        }
        else if (ae. getSource() == bookpackage)
        {
            new BookPackage(username);
        }
        else if (ae.getSource() == viewpackage)
        {
            new ViewPackage(username);
        }
        else if (ae.getSource() == viewhotels)
        {
            new CheckHotels();
        }
        else if (ae.getSource() == destinations)
        {
            new Destinations();
        }
    }
    
    public static void main (String[] args)
    {
       new DashBoard("");
       
    }
}
