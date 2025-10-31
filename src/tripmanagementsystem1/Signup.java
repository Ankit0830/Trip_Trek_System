package tripmanagementsystem1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class Signup extends JFrame implements ActionListener{
    
    JButton create, back;
    JTextField tfusername, tfname, tfpassword, tfanswer;
    Choice security;
    // Define the Constructor
    Signup() {
        setBounds(350, 200, 850, 500);
        setLayout(null);
        setTitle("Signup"); // Title added 
        setFont(new Font("SansSerif", Font.BOLD, 20));
        getContentPane().setBackground(Color.white);
        
        
        // Creating a Pannel 
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0,0,500,500);
        p1.setLayout(null);
        add(p1);
        
        //Creating a Username Label
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 45, 120, 30);         //(X, Y, Width, Hight) 
        lblusername.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblusername.setForeground(Color.BLACK);
        p1.add(lblusername);
        
        //Creating a Username TextField 
//     JTextField tfusername = new JTextField();
        tfusername = new JTextField();
        tfusername.setBounds(200, 45, 200, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        //Name Label 
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 95, 120, 30);
        lblname.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblname.setForeground(Color.BLACK);
        p1.add(lblname);
        
        //Name Textfield 
//     JTextField tfname = new JTextField();
        tfname = new JTextField();
        tfname.setBounds(200, 95, 200, 30);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        //Password Label
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 145, 120, 30);
        lblpassword.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblpassword.setForeground(Color.BLACK);
        p1.add(lblpassword);
        
        //Password Textfield 
//     JTextField tfpassword = new JTextField();
        tfpassword = new JTextField();
        tfpassword.setBounds(200, 145, 200, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        
        //Security Question
        JLabel lblsecurity = new JLabel("Security Question");
        lblsecurity.setBounds(60, 185, 130, 30);
        lblsecurity.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblsecurity.setForeground(Color.BLACK);
        p1.add(lblsecurity);
        
//     Choice security = new Choice();
        security = new Choice();
        security.setFont(new Font("SansSerif", Font.PLAIN, 15));
        security.add("Your BestFriend:");
        security.add("Your Faveret SuperHero:");
        security.add("Your Lucy Number:");
        security.add("Your ChildHood SuperHero:");
        security.setBounds(200, 190, 200, 35);
        p1.add(security);
        
        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setBounds(60, 230, 130, 30);
        lblanswer.setFont(new Font("SansSerif", Font.PLAIN, 16));
        lblanswer.setForeground(Color.BLACK);
        p1.add(lblanswer);
        
        
//     JTextField tfanswer = new JTextField();
        tfanswer = new JTextField();
        tfanswer.setBounds(200, 235, 200, 30);
        tfanswer.setFont(new Font("SansSerif", Font.PLAIN, 16));
        tfanswer.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        p1.add(tfanswer);
        
        
        //Creating a Button Of Create
//     JButton create = new JButton ("Create");
        create = new JButton ("Create");
        create.setBounds(80, 325, 120, 36);
        create.setBackground(Color.white);
        create.setForeground(new Color(133, 193, 233));
        create.setBorder (new LineBorder(new Color(131, 193, 233)));
        create.addActionListener(this);         //For Button Perform Action
        p1.add(create); 
        
        
        //Creating a Button Of Back
//        JButton back = new JButton ("Back");
        back = new JButton ("Back");
        back.setBounds(240, 325, 120, 36);
        back.setBackground(Color.white);
        back.setForeground(new Color(133, 193, 233));
        back.setBorder (new LineBorder(new Color(131, 193, 233)));
        back.addActionListener(this);           //For Button Perform Action
        p1.add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup1.png"));
        Image i2 = i1.getImage() .getScaledInstance(240, 240, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(540, 110, 250, 250);
        add(image);
        
        
        
        setVisible(true); // Visible must be last
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == create)
        {
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getName();
            
            String query = "insert into account values ('"+username+"', '"+name+"', '"+password+"', '"+question+"', '"+answer+"' )";
            try
            {
                Connector c = new Connector();
                c.s.execute(query);
                
                JOptionPane.showInternalMessageDialog(null, "Account Created Successfully");
                setVisible(true);
                new Login();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else if (ae.getSource() == back)
        {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}

