package Object;

import Environement.Environement;
import static Environement.Environement.floorMemoryY;
import java.awt.Color;

public class ClusterShell extends Shell {
    
    private double initialSpeed = 200+ Environement.powerShoot;
    public double gravity = 9.81;
    public double timeMultiplerXpos = 2;
    public int radius = 10;
	
	public ClusterShell(double positionSx, double positionSy, double initPosSx, double initPosSy){
		super(positionSx,positionSy,initPosSx,initPosSy);
                this.positionSx = positionSy;
                this.positionSy = positionSy;
                this.initPosSx = initPosSx;
                this.initPosSy = initPosSy;
	}
	
	public void display(){
		
	}
	
	public void move(double gunAngle, double time){
        if (Math.toDegrees(gunAngle) > 0 && Math.toDegrees(gunAngle) < 90){
            positionSx = initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (gravity * 10 * time * time)/2 - initialSpeed *Math.sin(gunAngle) * time + initPosSy;
        }
        else if (Math.toDegrees(gunAngle) > 90 && Math.toDegrees(gunAngle) < 180){
            positionSx = initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (gravity *10* time * time)/2 + initialSpeed * Math.sin(gunAngle) * time - initPosSy;
        }
        else if (Math.toDegrees(gunAngle) > 180 && Math.toDegrees(gunAngle) < 270){
            positionSx = initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (gravity *10* time * time)/2 - initialSpeed * Math.sin(gunAngle) * time + initPosSy;
        }
        else if (Math.toDegrees(gunAngle) > 270 && Math.toDegrees(gunAngle) < 360){
            positionSx = initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (-gravity * 10* time * time)/2 - initialSpeed * Math.sin(gunAngle) * time + initPosSy;
        }
        }
        
        
        

}
