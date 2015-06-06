package Environement;

import Object.Shell;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JComponent;



    public class DrawShell extends JComponent{
        
        public int widthShell = 15;
        public int heightShell = 5;
   
    
    public DrawShell(Graphics2D g2d,Shell shell,double positionX, double positionY, int c){
        
        if (c == 1){
            g2d.setColor(Color.yellow);
            
        }
        else if (c == 2){
            g2d.setColor(Color.red);
            
        }
        else if (c ==3){
            g2d.setColor(Color.black);
                               
        }
        else if (c == 4){
            g2d.setColor(Color.gray);
           
        }
        g2d.fillOval((int)positionX,(int)positionY,widthShell,heightShell);
        g2d.setColor(Color.black);
        g2d.drawOval((int)positionX,(int)positionY,widthShell,heightShell);
        
        
        
    }
}
