package tripmanagementsystem1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;




public class About extends JFrame implements ActionListener
{
    About()
    {
        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        
        JLabel l1 = new JLabel("About");
        l1.setBounds(200,10,100,40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(l1);
        
        String s = "About Projects";
        
        
        TextArea area = new TextArea(s, 10,40,Scrollbar.VERTICAL);
        area.setBounds(20,100,450,300);
        add(area);
        
        
        // Back Button
        JButton back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,440,100,25);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
        
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        setVisible(false);
    }
    
    
    public static void main(String[] args) {
        new About();
    }

    
}
