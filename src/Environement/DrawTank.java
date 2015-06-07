package Environement;


import Object.Tank;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.JComponent;



    public class DrawTank extends JComponent{
   
    
    public DrawTank(Graphics2D g2d,Tank tank,int hp){
        
        if(tank.hp>0){
        g2d.setColor(Color.green);
        g2d.fillRect(tank.positionX,tank.positionY,10,10 );
        g2d.setColor(Color.red);
        g2d.fillRect(tank.positionX,tank.positionY-5,hp/10,2);
        g2d.drawLine(tank.positionX+5,tank.positionY+5,(int)tank.positionGunX,(int)tank.positionGunY);
        g2d.setColor(Color.blue);
        g2d.fillRect(tank.positionX,tank.positionY-3,tank.fuel/10,2);
        }
        else{
            g2d.setColor(Color.black);
            g2d.fillRect(tank.positionX,tank.positionY,15,15);
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("default", Font.BOLD, 54));
            g2d.drawString("GAME OVER", 500, 300);
            
        }
        
        //System.out.println("je me dessine bien");
    }
}

