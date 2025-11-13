package tripmanagementsystem1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Paytm extends JFrame implements ActionListener
{
    JButton back;
    
    Paytm()
    {
        setBounds(380,180,1000,600);
        
        
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        try 
        {
            pane.setPage("https://paytm.com/rent-payment");                 //Passed URL of paytm, we also use some another payment application like googlePay as well as PhonePay
        }
        catch (Exception e)
        {
            pane.setContentType("text/html");
            pane.setText("<html> Could not load, Error 404</html>");
        }
        
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);
        
        // Back Button
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(850,20,80,30);
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed (ActionEvent ae)
    {
        setVisible(false);
        new Payment();
    }
    
    public static void main (String[] args)
    {
        new Paytm();
    }
}
