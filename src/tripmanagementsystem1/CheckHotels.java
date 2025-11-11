package tripmanagementsystem1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CheckHotels extends JFrame implements Runnable 
{
    Thread t1;
    JLabel[] label = new JLabel[9];
    JLabel caption;
    String[] text = 
    {
        "JW Marriott Hotel", "Mandarin Oriental Hotel", "Four Seasons Hotel",
        "Radisson Blu Hotel", "Classio Hotel", "The Bay Club Hotel",
        "The Taj Hotel", "Breeze Blow Hotel", "Happy Morning Hotel"
    };

    volatile boolean paused = false;   // flag for pause
    volatile long lastInteractionTime; // track last user interaction time
    final int RESUME_DELAY = 5000;     // n milliseconds (5 seconds)

    public void run() 
    {
        try 
        {
            int i = 0;
            while (true) 
            {
                if (paused) 
                {
                    Thread.sleep(500); // check again later
                    continue;
                }

                label[i].setVisible(true);
                caption.setText(text[i]);
                Thread.sleep(2500);
                label[i].setVisible(false);

                i = (i + 1) % label.length; // loop back to start

                // Auto-resume after n seconds of no interaction
                if (System.currentTimeMillis() - lastInteractionTime < RESUME_DELAY) {
                    paused = true; // pause when user recently interacted
                }
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    CheckHotels() 
    {
        setBounds(400, 100, 1000, 700);
        setLayout(null);

        caption = new JLabel();
        caption.setBounds(50, 500, 1000, 70);
        caption.setFont(new Font("Tahoma", Font.PLAIN, 40));
        caption.setForeground(Color.WHITE);
        add(caption);

        ImageIcon[] image = new ImageIcon[9];
        Image[] jimage = new Image[9];
        ImageIcon[] kimage = new ImageIcon[9];

        for (int i = 0; i < label.length; i++) 
        {
            image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/hotel" + (i + 1) + ".jpg"));
            jimage[i] = image[i].getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
            kimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(kimage[i]);
            label[i].setBounds(0, 0, 1000, 700);
            add(label[i]);
            label[i].setVisible(false);
        }

        // Detect user interactions
        addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) 
            {
                paused = true;
                lastInteractionTime = System.currentTimeMillis();
                new Timer(RESUME_DELAY, new ActionListener() 
                {
                    public void actionPerformed(ActionEvent evt) {
                        if (System.currentTimeMillis() - lastInteractionTime >= RESUME_DELAY) 
                        {
                            paused = false;
                            ((Timer) evt.getSource()).stop();
                        }
                    }
                }).start();
            }
        });

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                paused = true;
                lastInteractionTime = System.currentTimeMillis();
                new Timer(RESUME_DELAY, new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (System.currentTimeMillis() - lastInteractionTime >= RESUME_DELAY) {
                            paused = false;
                            ((Timer) evt.getSource()).stop();
                        }
                    }
                }).start();
            }
        });

        setFocusable(true);

        t1 = new Thread(this);
        t1.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckHotels();
    }
}
