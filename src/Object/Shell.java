
package Object;

import Environement.Environement;
import static Environement.Environement.floorMemoryX;
import static Environement.Environement.floorMemoryY;
import static Environement.Generator.nbrPoints;
import java.awt.Color;

public abstract class Shell {

	protected Color color;
	public double positionSx;
	public double positionSy;
        public double initPosSx;
        public double initPosSy;
        public double gunAngle;
        public double time;
        protected int radius = 7 ;
	protected Color c;
	
	public Shell (double positionSx, double positionSy, double initPosSx, double initPosSy){
		this.positionSx = positionSx;
		this.positionSy = positionSy;
                this.initPosSx = initPosSx;
                this.initPosSy = initPosSy;
	}
	
	abstract void display();
	
	abstract void move(double gunAngle, double time);
        
        public void collideFloor(){
            
            
            
            if(positionSy-5> floorMemoryY[(int)(positionSx+15)/5]){
                floorMemoryY[(int)((positionSx+15)/5)]=floorMemoryY[(int)((positionSx+15)/5)]+5*radius;
                // First, save previous and following points
                
                for(int i=nbrPoints; i>(int)((positionSx+15)/5)+radius;i--){
                    floorMemoryX[i+2*radius]=floorMemoryX[i];
                    floorMemoryY[i+2*radius]=floorMemoryY[i];
                    
                }
                
                
                //then, add some more points to the list
                
                
                for(int i = 0; i < radius; i++){
                    if(floorMemoryY[(int)((positionSx+15)/5)-i]<floorMemoryY[(int)((positionSx+15)/5)-i+1]-i)
                    floorMemoryY[(int)((positionSx+15)/5)-i]=floorMemoryY[(int)((positionSx+15)/5)-i+1]-i;
                    else if(floorMemoryY[(int)((positionSx+15)/5)-i]>floorMemoryY[(int)((positionSx+15)/5)-i+1]+i){
                    floorMemoryY[(int)((positionSx+15)/5)-i]=floorMemoryY[(int)((positionSx+15)/5)-i+1]+i;
                    }
                }
                for(int i = 0; i < radius; i++){
                    if(floorMemoryY[(int)((positionSx+15)/5)+i]<floorMemoryY[(int)((positionSx+15)/5)+i-1]-i){
                    floorMemoryY[(int)((positionSx+15)/5)+i]=floorMemoryY[(int)((positionSx+15)/5)+i-1]-i;
                }
                }
                Environement.shellCollided=1;
                nbrPoints+=2*radius;
                System.out.print("..............................................................................................");
            }
            
            
        }
        
        
        
}
