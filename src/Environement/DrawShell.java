package Environement;

import Object.Shell;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JComponent;



    public class DrawShell extends JComponent{
   
    
    public DrawShell(Graphics2D g2d,Shell shell,double positionX, double positionY, int c){
        
        if (c == 1){
            g2d.setColor(Color.yellow);
            g2d.fillOval((int)positionX,(int)positionY,15,5);
        }
        else if (c == 2){
            g2d.setColor(Color.red);
            g2d.fillOval((int)positionX,(int)positionY,15,5);
        }
        else if (c ==3){
            g2d.setColor(Color.black);
            g2d.fillOval((int)positionX,(int)positionY,15,5);                    
        }
        else if (c == 4){
            g2d.setColor(Color.gray);
            g2d.fillOval((int)positionX,(int)positionY,15,5);
        }
        
        
        
        System.out.println("je me dessine bien");
    }
}
