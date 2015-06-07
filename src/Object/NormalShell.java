package Object;

import Environement.Environement;
import static Environement.Environement.floorMemoryY;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NormalShell extends Shell {
    
    private double initialSpeed = 50+ Environement.powerShoot;
    public double gravity = 9.81;
    public double timeMultiplerXpos = 2;
    public int radius = 10;
	
    public NormalShell(double positionSx, double positionSy, double initPosSx, double initPosSy){
            super(positionSx,positionSy,initPosSx,initPosSy);
    }

    public void display(){

    }

    public void move(double gunAngle, double time){
        if (Math.toDegrees(gunAngle) > 0 && Math.toDegrees(gunAngle) <= 90){
            positionSx = initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (gravity * 10 * time * time)/2 - initialSpeed *Math.sin(gunAngle) * time + initPosSy;
        }
        else if (Math.toDegrees(gunAngle) > 90 && Math.toDegrees(gunAngle) < 180){
            positionSx = initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (gravity *10* time * time)/2 - initialSpeed * Math.sin(gunAngle) * time + initPosSy;
        }
        else if (Math.toDegrees(gunAngle) > 180 && Math.toDegrees(gunAngle) < 270){
            positionSx = initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (gravity *10* time * time)/2 - initialSpeed * Math.sin(gunAngle) * time + initPosSy;
        }
        else if (Math.toDegrees(gunAngle) > 270 && Math.toDegrees(gunAngle) < 360){
            positionSx = initialSpeed * Math.cos(gunAngle)*time*timeMultiplerXpos + initPosSx;
            positionSy = (gravity * 10* time * time)/2 - initialSpeed * Math.sin(gunAngle) * time + initPosSy;
        }
        }
        

       
}



