
package Object;

import java.awt.Color;

public abstract class Shell {

	protected Color color;
	public int positionSx;
	public int positionSy;
	protected Color c;
	
	public Shell (int positionSx, int positionSy){
		this.positionSx = positionSx;
		this.positionSy = positionSy;
	}
	
	abstract void display();
	
	abstract void move();
}
