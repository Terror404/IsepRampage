
package Object;

import Environement.Environement;
import static Environement.Environement.floorMemoryX;
import static Environement.Environement.floorMemoryY;
import java.awt.Color;

public abstract class Shell {

	protected Color color;
	public double positionSx;
	public double positionSy;
        public double initPosSx;
        public double initPosSy;
        public double gunAngle;
        public double time;
        protected int radius = 10 ;
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
                for(int i = 0; i < radius; i++){
                    if(floorMemoryY[(int)((positionSx+15)/5)-i]<floorMemoryY[(int)((positionSx+15)/5)-i+1]-i)
                    floorMemoryY[(int)((positionSx+15)/5)-i]=floorMemoryY[(int)((positionSx+15)/5)-i+1]-i;
                }
                for(int i = 0; i < radius; i++){
                    if(floorMemoryY[(int)((positionSx+15)/5)+i]<floorMemoryY[(int)((positionSx+15)/5)+i-1]-i){
                    floorMemoryY[(int)((positionSx+15)/5)+i]=floorMemoryY[(int)((positionSx+15)/5)+i-1]-i;
                }
                }
                Environement.shellCollided=1;
                System.out.print("..............................................................................................");
            }
            
            
        }
        
        
        
}
