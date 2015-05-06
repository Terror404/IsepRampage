package Environement;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JComponent;

public class Wind {
    
    public int windPicker;
    public int windPower;
    public String force0 = "Pas de vent";
    public String force1 = "Vent force 10";
    public String force2 = "Vent force 20";
    public String force3 = "Vent force 30";
    
    
    public Wind(int setWind, Graphics2D g2d){
        if (setWind == 0){
            windPicker = (int) (Math.random() * 3);
        }
        
            switch (windPicker){
                case 0 :
                    windPower = 0;
                    break;
                case 1 : 
                    windPower = 10;
                    break;
                case 2 :
                    windPower = 20;
                    break;
                case 3 :
                    windPower = 30;
                    break;
            }

        
        System.out.println("nombre aléatoire = " + windPicker);
        System.out.println("Force du vent = " + windPower);
        
        switch (windPower){
            case 0 :
                g2d.setColor(Color.BLUE);
                g2d.fillOval(50,50,30,30);
                g2d.drawString("Pas de vent", 30, 35);
                break;
            case 10 :
                g2d.setColor(Color.BLUE);
                g2d.fillOval(50,50,30,30);
                g2d.drawString("Vent force 10", 30, 35);
                break;
            case 20 :
                g2d.setColor(Color.BLUE);
                g2d.fillOval(50,50,30,30);
                g2d.drawString("Vent force 20", 30, 35);
                break;
            case 30 : 
                g2d.setColor(Color.BLUE);
                g2d.fillOval(50,50,30,30);
                g2d.drawString("Vent force 30", 30, 35);
                break;
        }
    }
    
}
