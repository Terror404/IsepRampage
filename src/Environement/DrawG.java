package Environement;


import static Environement.Environement.floorMemoryX;
import static Environement.Environement.floorMemoryY;
import IsepRampage.IsepRampage;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JComponent;


public class DrawG extends JComponent{
    
    private static final long serialVersionUID = 1L;
    
    public DrawG(Graphics2D g2d){
        
        //for(int i =0; i < Generator.TilesG.size();i++){
            /*
            g2d.setColor(Color.red);
            g2d.fillRect(Generator.TilesG.get(i).x,Generator.TilesG.get(i).y,Generator.TilesG.get(i).width,Generator.TilesG.get(i).height);
            g2d.setColor(Color.black);
            g2d.drawRect(Generator.TilesG.get(i).x,Generator.TilesG.get(i).y,Generator.TilesG.get(i).width,Generator.TilesG.get(i).height);
            */
            g2d.setColor(Color.DARK_GRAY);
            g2d.fillPolygon(Environement.floorMemoryX,Environement.floorMemoryY,Generator.nbrPoints);
            g2d.setColor(Color.black);
            g2d.drawPolygon(Environement.floorMemoryX,Environement.floorMemoryY,Generator.nbrPoints);
            
            
            
            
            //System.out.println("je suis un polygon bien généré");
            
        //}
    }
    
}

