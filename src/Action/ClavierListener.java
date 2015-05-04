
package Action;

import Environement.Environement;
import static Environement.Environement.speedLeftTank;
import IsepRampage.IsepRampage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;


public class ClavierListener implements KeyListener{

    public void keyPressed(KeyEvent event) {
      
      IsepRampage.keyPressed=event.getKeyCode();
      
      
    }

    public void keyReleased(KeyEvent event) {
               
       IsepRampage.keyPressed=0;                
    }

    public void keyTyped(KeyEvent event) {
      
      
    }   	
  }  


