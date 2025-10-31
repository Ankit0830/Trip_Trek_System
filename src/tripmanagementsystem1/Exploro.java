package tripmanagementsystem1;
import javax.swing.*;
import java.awt.*;

public  class Exploro extends JFrame implements Runnable 
{
    Thread thread;
    Exploro() {
        setSize(1200,600);
        setLocation(200,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // good practice
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/explora.png"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        setVisible(true); // 👈 move this line to the end
        thread = new Thread(this);
        thread.start(  );
    }
    public void run()
    {
        try
        {
            Thread.sleep(2000);
            new Login();
            setVisible(false);
        }
        catch(Exception e)
        {
            
        }
    }

    public static void main(String[] args) {
        new Exploro();
    }
}
