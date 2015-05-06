package Object;

import java.awt.Color;

public class HeavyShell extends Shell {
	
	public HeavyShell(int positionSx, int positionSy){
		super(positionSx,positionSy);
                this.positionSx = positionSx;
                this.positionSy = positionSy;
	}
	
	public void display(){
		
	}
	
	public void move(){
            positionSx = positionSx + 1;
            positionSy = positionSy;
	}

}
