
package Object;

import java.awt.Color;

public abstract class Shell {

	protected Color color;
	public double positionSx;
	public double positionSy;
        public double initPosSx;
        public double initPosSy;
        public double gunAngle;
        public double time;
        public int radius;
	protected Color c;
	
	public Shell (double positionSx, double positionSy, double initPosSx, double initPosSy){
		this.positionSx = positionSx;
		this.positionSy = positionSy;
                this.initPosSx = initPosSx;
                this.initPosSy = initPosSy;
	}
	
	abstract void display();
	
	abstract void move(double gunAngle, double time);
        abstract void collideFloor();
}
