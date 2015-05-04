package Object;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NormalShell extends Shell {
    
    private double loopVarShell = 0;
	
    public NormalShell(double positionSx, double positionSy, double initPosSx, double initPosSy){
            super(positionSx,positionSy,initPosSx,initPosSy);
            this.positionSx = positionSx;
            this.positionSy = positionSy;
            this.initPosSx = initPosSx;
            this.initPosSy = initPosSy;
    }

    public void display(){

    }

    public void move(){
        if (positionSx < initPosSx + 100){        
            positionSx = positionSx + 1;
            positionSy = positionSy; 
        }
        else{
            positionSx = positionSx + 1;
            positionSy = positionSy + 0.2;
        }
    }
}



