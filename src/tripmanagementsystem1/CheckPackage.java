package tripmanagementsystem1;

import java.awt.*;          // Colors
import javax.swing.*;

public class CheckPackage extends JFrame
{

    CheckPackage()
    {
        // Frame Layout
        setBounds(450,200,900,600);    
        
        String[] package1 = new String[]{"Package.jpg","GOLD PACKAGE","6 days and 7 Nights", "Airport Assistance at Aiport", "Half Day City Tour", "Welcome drinks on Arrival", "Daily Buffet", "Full Day 3 Island Cruise", "English Speaking Guide", "BOOK NOW", "Summer Special", "Rs 12000 only"};
        String[] package2 = new String[]{"package2.jpg","SILVER PACKAGE","4 days and 3 Nights", "Toll Free and Entrance Free Tickets", "Meet and Greet at Aiport", "Welcome drinks on Arrival", "Night Safari", "Full Day 3 Island Cruise", "Cruise with Dinner", "BOOK NOW", "Winter Special", "Rs 25000 only"};
        String[] package3 = new String[]{"package3.jpg","BRONZE PACKAGE","6 days and 5 Nights", "Return Airfare", "Free Clubbing, Horse Riding & other Games", "Welcome drinks on Arrival", "Daily Buffet", "Stay in 5 Star Hotel", "BBQ Dinner", "BOOK NOW", "Winter Special", "Rs 32000 only"};
        
         
        JTabbedPane tab = new JTabbedPane();
        JPanel p1 = createPackage(package1);
        tab.addTab("Package 1", null, p1);
        
        JPanel p2 = createPackage(package2);
        tab.addTab("Package 2", null, p2);
        
        JPanel p3 = createPackage(package3);
        tab.addTab("Package 3", null, p3);
        
        add(tab);
        

        setVisible(true);
    }
    
    public JPanel createPackage(String[] pack)
    {
        // 
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        
        // GOLD PACKAGE
//        JLabel l1 = new JLabel(pack [1], SwingConstants.CENTER );
////        l1.setBounds(50,5,300,30);
//        l1.setForeground(Color.MAGENTA);
//        l1.setFont(new Font("Tahama", Font.BOLD, 30));
//        l1.setBounds(0, 5, 900, 40);
//        p1.add(l1);
        
        // === RIBBON + CENTERED TITLE ===
        JLabel l1 = new JLabel(pack[1], SwingConstants.CENTER);
        l1.setOpaque(true);                        // allow background color
        l1.setBackground(new Color(255, 215, 0));  // gold ribbon color
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        l1.setBounds(0, 0, 900, 50);               // full width, ribbon height
        p1.add(l1);

        // First Line
        JLabel l2 = new JLabel(pack [2]);
        l2.setBounds(30,60,300,30);
        l2.setForeground(Color.BLUE);
        l2.setFont(new Font("Tahama", Font.BOLD, 20));
        p1.add(l2);
        
        // Second Line
        JLabel l3 = new JLabel(pack [3]);
        l3.setBounds(30,110,300,30);
        l3.setForeground(Color.BLUE);
        l3.setFont(new Font("Tahama", Font.BOLD, 20));
        p1.add(l3);
        
        //Third Line
        JLabel l4 = new JLabel(pack [4]);
        l4.setBounds(30,160,300,30);
        l4.setForeground(Color.BLUE);
        l4.setFont(new Font("Tahama", Font.BOLD, 20));
        p1.add(l4);
        
        // Forth Line
        JLabel l5 = new JLabel(pack [5]);
        l5.setBounds(30,210,300,30);
        l5.setForeground(Color.BLUE);
        l5.setFont(new Font("Tahama", Font.BOLD, 20));
        p1.add(l5);
        
        // Fifth Line
        JLabel l6 = new JLabel(pack [6]);
        l6.setBounds(30,260,300,30);
        l6.setForeground(Color.BLUE);
        l6.setFont(new Font("Tahama", Font.BOLD, 20));
        p1.add(l6);
        
        // Six Line
        JLabel l7 = new JLabel(pack [7]);
        l7.setBounds(30,310,300,30);
        l7.setForeground(Color.BLUE);
        l7.setFont(new Font("Tahama", Font.BOLD, 20));
        p1.add(l7);
        
        // Seven Line
        JLabel l8 = new JLabel(pack [8]);
        l8.setBounds(30,360,300,30);
        l8.setForeground(Color.BLUE);
        l8.setFont(new Font("Tahama", Font.BOLD, 20));
        p1.add(l8);
        
        // Book Now Button
        JButton book = new JButton(pack [9]);
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        book.setBounds(60,430,200,40);
        book.setFont(new Font("Tahama", Font.BOLD, 25));
//        back.addActionListener(this);
        p1.add(book);
        
        // Nine Line
        JLabel l10 = new JLabel(pack [10]);
        l10.setBounds(60,480,300,30);
        l10.setForeground(Color.BLUE);
        l10.setFont(new Font("Tahama", Font.BOLD, 20));
        p1.add(l10); 
        
        // Price Line
        JLabel l11 = new JLabel(pack[11], SwingConstants.CENTER);
        l11.setBounds(480, 450, 300, 40);
        l11.setOpaque(true);                        // allow background color
        l11.setBackground(new Color(255, 215, 0));  // gold background for price
        l11.setForeground(Color.BLACK);
        l11.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(l11);
        
        // Image 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack [0]));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,120,500, 300);
        p1.add(image);
        
        
        return p1;
    }
    
    public static void main(String[] args)
    {
        new CheckPackage();
    }
}
