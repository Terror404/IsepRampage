
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
        private double shellAngle;
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
        
        public void collideFloor(Tank tank){
            
            if( positionSx<10 || positionSx>1250){
               Environement.shellCollided=1;
                Environement.playerTurn+=1; 
                Environement.setWind=0;
            }
            else if(positionSy-5> floorMemoryY[(int)(positionSx+15)/5]){
                
                //calcul du premier point
                
                shellAngle=Math.atan2(5*radius,5);
                
                if(tank.positionX<positionSx+radius+5 && tank.positionX>positionSx-radius-5){
                    tank.loseHp(40);
                }
                
                
                
                
                
                floorMemoryY[(int)((positionSx+15)/5)]=floorMemoryY[(int)((positionSx+15)/5)]+5*radius;
                /* First, save previous and following points
                
                for(int i=nbrPoints; i>(int)((positionSx+15)/5)+radius;i--){
                    floorMemoryX[i+2*radius]=floorMemoryX[i];
                    floorMemoryY[i+2*radius]=floorMemoryY[i];
                    
                }
                
                
                //then, add some more points to the list
                
                for(int i = 0; i < radius; i++){
                    //if(floorMemoryY[(int)((positionSx+15)/5)-i]==(int)(positionSy+5+Math.sqrt(radius*radius -(floorMemoryY[(int)((positionSx+15)/5)-i]-positionSx-15)*(floorMemoryY[(int)((positionSx+15)/5)-i]-positionSx-15))) ){
                        for(int j=i;j>0;j--){
                            floorMemoryY[(int)((positionSx+15)/5)-j]=(int)(positionSy+5+Math.sqrt(radius*radius -(floorMemoryY[(int)((positionSx+15)/5)-j]-positionSx-15)*(floorMemoryY[(int)((positionSx+15)/5)-i]-positionSx-15)));
                        }
                        for(int j=0;j<radius;j++){
                            floorMemoryY[(int)((positionSx+15)/5)+j]=(int)(positionSy+5+Math.sqrt(radius*radius -(floorMemoryY[(int)((positionSx+15)/5)+j]-positionSx-15)*(floorMemoryY[(int)((positionSx+15)/5)-i]-positionSx-15)));
                        }
                    
               // }
                     System.out.println("..............................................................................................");
                      System.out.println("..............................................................................................");
                    System.out.println(floorMemoryY[(int)((positionSx+15)/5)-i]);
                     System.out.println("..............................................................................................");
                    System.out.println((int)(positionSy+5+Math.sqrt(radius*radius -(floorMemoryY[(int)((positionSx+15)/5)-i]-positionSx-15)*(floorMemoryY[(int)((positionSx+15)/5)-i]-positionSx-15))));
            }
                
                */
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
                Environement.playerTurn+=1;
                Environement.setWind=0;
                System.out.print("..............................................................................................");
            }
            
            
        }
        
        
        
}
