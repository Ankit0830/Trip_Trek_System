package tripmanagementsystem1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Payment extends JFrame implements ActionListener
{
    JButton pay, back;
    
    Payment()
    {
        setBounds(500,200,800,600);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800, 600);
        add(image);
        
        
        // Back Button
        pay = new JButton("Pay");
        pay.setBackground(Color.BLACK);
        pay.setForeground(Color.WHITE);
        pay.setBounds(420,0,80,40);
        pay.addActionListener(this);
        image.add(pay);
        
        
        // Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,0,80,40);
        back.addActionListener(this);
        image.add(back);
        
        
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed (ActionEvent ae)
    {
        if (ae.getSource()  == pay)
        {
            setVisible(false);
            new Paytm();
        }
        else 
        {
            setVisible(false);
        }
    }
    
    public static void main (String[] args)
    {
        new Payment().setVisible(true);
    }
}
