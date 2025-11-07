package tripmanagementsystem1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;  // ✅ correct



public class ForgetPassword extends JFrame implements ActionListener
{
    JTextField tfusername, tfquestion, tfname, tfanswer, tfpassword;
    JButton search, retrieve, back;
    
    ForgetPassword ()
    {
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color. WHITE);
        setLayout(null);
        setTitle("ForgetPassword"); // Title added 
        
        ImageIcon i1 = new ImageIcon (ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 70,200, 200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 450, 280);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40,20,400,25);
        lblusername.setFont(new Font("Tabona", Font.BOLD, 14));
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(200,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        //Search Button
        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(360,20,80,25);
        search.addActionListener(this);
        p1.add(search);
        
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(40,60,400,25);
        lblname.setFont(new Font("Tabona", Font.BOLD, 14));
        p1.add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        
        JLabel lblquestion = new JLabel("Security Question");
        lblquestion.setBounds(40,100,400,25);
        lblquestion.setFont(new Font("Tabona", Font.BOLD, 14));
        p1.add(lblquestion);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(200,100,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel lblanswer = new JLabel("Your Answer");
        lblanswer.setBounds(40,140,400,25);
        lblanswer.setFont(new Font("Tabona", Font.BOLD, 14));
        p1.add(lblanswer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(200,140,150,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        //Retrieve Button
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
//     retrieve.setFont(new Font("Tabona", Font.BOLD, 11));
        retrieve.setBounds(360,140,80,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,180,400,25);
        lblpassword.setFont(new Font("Tabona", Font.BOLD, 14));
        p1.add(lblpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(200,180,150,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        //Back Button
        back = new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(150,230,80,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed (ActionEvent ae)
    {
        if (ae.getSource() == search)
        {
            try 
            {
                String query = "select * from account where username = '"+tfusername.getText()+"'";
                Connector c = new Connector();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next())
                {
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == retrieve) 
        {
            try 
            {
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+ tfusername.getText()+"'";
                Connector c = new Connector();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next())
                {
                    tfpassword.setText(rs.getString("password"));
                    
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else
        {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main (String[] args)
    {
        new ForgetPassword ();
    }
}
