package Environement;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class Wind {
    
    public static int windPicker;
    public static int windDirection;
    public static int randomWp;
    public static int randomWd;
    
    
    public Wind(int setWind){
        if(setWind !=1){
            randomWp = (int) (Math.random() * 4);
            randomWd = (int) (Math.random() * 2);
            windPicker = randomWp;
            windDirection = randomWd;  
        }
        
    }
    
    
    public void WindCreation(Graphics2D g2d){
        
        
        switch (windPicker){
            case 0 :
                g2d.setColor(Color.BLUE);
                g2d.drawString("Pas de vent", 30, 35);
                g2d.fillOval(50, 50, 10, 10);
                Environement.windForce=1;
                
                break;
            case 1 :
                g2d.setColor(Color.BLUE);
               g2d.drawString("Vent force 10", 30, 35);
                
                if (windDirection == 0){
                    int xpoints[] = {50,60,60,90,90,60,60};
                    int ypoints[] = {50,30,40,40,60,60,70};  
                    g2d.fillPolygon(xpoints, ypoints, 7);
                    Environement.windForce=-10;
                   
                }
                else if (windDirection == 1){
                    int xpoints[] = {90,80,80,50,50,80,80};
                    int ypoints[] = {50,70,60,60,40,40,30};
                    g2d.fillPolygon(xpoints, ypoints, 7);
                    Environement.windForce=10;
                    
                }
                
                break;
            case 2 :
                g2d.setColor(Color.BLUE);
                g2d.drawString("Vent force 20", 30, 35);
                
                if (windDirection == 0){
                    int xpoints[] = {50,60,60,90,90,60,60};
                    int ypoints[] = {50,30,40,40,60,60,70};  
                    g2d.fillPolygon(xpoints, ypoints, 7);
                    Environement.windForce=-20;
                }
                else if (windDirection == 1){
                    int xpoints[] = {90,80,80,50,50,80,80};
                    int ypoints[] = {50,70,60,60,40,40,30};
                    g2d.fillPolygon(xpoints, ypoints, 7);
                    Environement.windForce=20;
                }
                
                break;
            case 3 : 
                g2d.setColor(Color.BLUE);
                g2d.drawString("Vent force 30", 30, 35);
                
                if (windDirection == 0){
                    int xpoints[] = {50,60,60,90,90,60,60};
                    int ypoints[] = {50,30,40,40,60,60,70};  
                    g2d.fillPolygon(xpoints, ypoints, 7);
                    Environement.windForce=-30;
                }
                else if (windDirection == 1){
                    int xpoints[] = {90,80,80,50,50,80,80};
                    int ypoints[] = {50,70,60,60,40,40,30};
                    g2d.fillPolygon(xpoints, ypoints, 7);
                    Environement.windForce=30;
                }
                
                break;
        }
    }
    
}
