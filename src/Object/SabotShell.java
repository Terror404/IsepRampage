package Object;

import java.awt.Color;

public class SabotShell extends Shell {
	
	public SabotShell(int positionSx, int positionSy, double initPosSx, double initPosSy){
		super(positionSx,positionSy,initPosSx,initPosSy);
	}
	
	public void display(){
		
	}
	
	public void move(){
            positionSx = positionSx + 1;
            positionSy = positionSy;
	}

}