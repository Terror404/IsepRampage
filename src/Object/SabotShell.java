package Object;

import java.awt.Color;

public class SabotShell extends Shell {
    
    private double initialSpeed = 100;
    public double gravity = 2;
    public double timeMultiplerXpos = 2;
	
	public SabotShell(double positionSx, double positionSy, double initPosSx, double initPosSy){
		super(positionSx,positionSy,initPosSx,initPosSy);
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