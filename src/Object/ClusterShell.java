package Object;

import static Environement.Environement.floorMemoryY;
import java.awt.Color;

public class ClusterShell extends Shell {
    
    private double initialSpeed = 50;
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
        if (gunAngle > 0 && gunAngle < 90){
            positionSx = initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (gravity * time * time)/2 + initialSpeed * Math.sin(gunAngle) * time + initPosSy;
        }
        else if (gunAngle > 90 && gunAngle < 180){
            positionSx = - initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (gravity * time * time)/2 + initialSpeed * Math.sin(gunAngle) * time + initPosSy;
        }
        else if (gunAngle > 180 && gunAngle < 270){
            positionSx = - initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (gravity * time * time)/2 - initialSpeed * Math.sin(gunAngle) * time + initPosSy;
        }
        else if (gunAngle > 270 && gunAngle < 360){
            positionSx = initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (gravity * time * time)/2 - initialSpeed * Math.sin(gunAngle) * time + initPosSy;
        }
        }
        
        

}
