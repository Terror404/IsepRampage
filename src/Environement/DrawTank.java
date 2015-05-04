package Environement;


import Object.Tank;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JComponent;



    public class DrawTank extends JComponent{
   
    
    public DrawTank(Graphics2D g2d,Tank tank,int positionX, int positionY,int hp){
        
        
        g2d.setColor(Color.green);
        g2d.fillOval(positionX,positionY,10,10 );
        g2d.setColor(Color.red);
        g2d.fillRect(positionX,positionY-5,hp/10,2);
        g2d.drawLine(tank.positionX+5,tank.positionY+5,(int)tank.positionGunX,(int)tank.positionGunY);
        
        //System.out.println("je me dessine bien");
    }
}

