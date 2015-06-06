package IsepRampage;




import Action.ClavierListener;
import Environement.Environement;

import java.awt.Component;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class IsepRampage {

    final static int X_MAX=1280;
    final static int Y_MAX=720;
    public static int v=0;
    public static int keyPressed;
    public static int keyReleased;
    public static int endGame=0;
    
    public static JFrame window = new JFrame(".");
    
    
    public static void main(String[] args) throws InterruptedException {           
      
      
       setWindow(window);
       
      
       window.add(new Environement());
       new IsepRampage();window.setVisible(true);
     
       
       
       
       
       
       
       
    }
    public IsepRampage() throws InterruptedException{
        
        
    }
    public static void setWindow(JFrame window){
         window.setTitle("IsepRampage");
       window.setSize(IsepRampage.X_MAX,IsepRampage.Y_MAX);
       window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       window.setLocationRelativeTo(null);
       window.setResizable(false);  
       
       
       
       JTextField jtf = new JTextField();
       window.add(jtf);
       jtf.addKeyListener(new ClavierListener()); 
    }
    
}


