package tripmanagementsystem1;
import java.awt.*;
import javax.swing.*;           //Import class 
import javax.swing.border.*;            //import class sub package

public class Login extends JFrame
{
    Login()
    {
        setSize(900, 400);
        setLocation(300, 200);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
//        p1.setBackground(Color.white);
        p1.setBounds(0, 0, 900, 400);
        p1.setLayout(null);
        add(p1);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage() .getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(i2));
        image.setBounds(100, 80, 200, 200);
        p1.add(image);
        
        JPanel p2 = new JPanel(null);
        p2.setBounds(400, 30,450,300);
//        p2.setBackground(new Color(131, 193, 233));
        p2.setBackground(Color.white);
        p1.add(p2);
        
        
        // For Creating a UserName
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 150, 25);
        lblusername.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblusername.setForeground(Color.BLACK);
        p2.add(lblusername);
        
        // For Creating a TextField from Username
        JTextField tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
//        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);
        
        
        // For Creating a Password Pannel
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110, 150, 25);
        lblpassword.setFont(new Font("SansSerif", Font.PLAIN, 20));
        lblpassword.setForeground(Color.BLACK);
        p2.add(lblpassword);
        
        // For Creating a TextField from Password
        JTextField tfpassword = new JTextField();
        tfpassword.setBounds(60, 150, 300, 30);
//        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        
        // Login Button
        JButton login = new JButton ("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(131, 193, 233));
        login.setForeground(Color.white);
        login.setBorder (new LineBorder(new Color(131, 193, 233)));
        p2.add(login);
        
        
        //Creating a Signup Button
        JButton signup = new JButton ("Signup");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(131, 193, 233));
        signup.setForeground(Color.white);
        signup.setBorder (new LineBorder(new Color(131, 193, 233)));
        p2.add(signup);
        
        
        // Forget Password Button
        JButton password = new JButton ("Forget Password");
        password.setBounds(125, 250, 180, 30);
        password.setBackground(new Color(131, 193, 233));
        password.setForeground(Color.white);
        password.setBorder (new LineBorder(new Color(131, 193, 233)));
        p2.add(password);
        
        
        setVisible(true);
    }
    public static void main(String[] args)
    {
        Login l1 = new Login();
        // if we have using only new Login() it will allow and also called Anonoms Object
    }
}
