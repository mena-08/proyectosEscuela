import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class panels
{
    public static void main(String[] args)
    {   
        
        
        
        
        /*
        JFrame f = new JFrame("Prueba");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JLabel menu = new JLabel("Menu");
        JLabel menu1 = new JLabel("00000");
        panel1.add(menu,BorderLayout.NORTH);
        panel2.add(menu1,BorderLayout.WEST);
        f.add(panel1);
        f.add(panel2);
        f.pack();
        f.setVisible(true);
        */
   }
   
   public void createPanel1()
   {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(3,4,2,2));
        panel1.add( new JButton( "1" ));
        panel1.add( new JButton( "2" ));
        panel1.add( new JButton( "3" ));
        panel1.add( new JButton( "4" ));
        panel1.add( new JButton( "5" ));
        panel1.add( new JButton( "6" ));
        panel1.add( new JButton( "7" ));
        panel1.add( new JButton( "8" ));
        panel1.add( new JButton( "9" ));
        panel1.add( new JButton( "0" ));
        panel1.add( new JButton( "Enter" ));
   }
}