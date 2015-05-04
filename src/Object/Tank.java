package Object;

import Environement.Environement;
import javax.swing.JComponent;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Maktor
 */
public class Tank extends JComponent{
    private static final long serialVersionUID = 1L;
    public int positionX;
    public int positionY;
    public double positionGunX;
    public double positionGunY;
    public int hp;
    
    
    public Tank(int positionX,int positionY,double positionGunX, double positionGunY, int hp){
       this.positionX=positionX;
       this.positionY=positionY;
       this.positionGunX=positionGunX;
       this.positionGunY=positionGunY;
       
       this.hp=hp;
    }
    
    public void moveTankLeft(){
        
        positionX=positionX-1;
        positionGunX=positionGunX-1;
        
        
        
    }
    public void moveTankRight(){
        
        positionX=positionX+1;
        positionGunX=positionGunX+1;
        
        
        
    }
    
    public void moveGunUp(){
    
    if(positionGunY<=positionY+5 && positionGunX>positionX+5 && positionGunY>positionY-10){
        positionGunX=positionGunX-0.05;
        positionGunY=positionGunY-0.05;
        
    }
    else if(positionGunY>positionY+5 && positionGunX>positionX+5){
        positionGunX=positionGunX+0.05;
        positionGunY=positionGunY-0.05;
    }
    else if(positionGunY<=positionY+5 && positionGunX<=positionX+5 && positionGunY>positionY-10){
        positionGunX=positionGunX+0.05;
        positionGunY=positionGunY+0.05;
    }
    else if(positionGunY>positionY+5 && positionGunX<=positionX+5 ){
        positionGunX=positionGunX+0.05;
        positionGunY=positionGunY-0.05;
    }
    if (positionGunX==positionX+5){
        positionGunX=positionGunX+1;
    }
        
    }
    public void moveGunDown(){
    
    if(positionGunY<=positionY+5 && positionGunX>positionX+5 ){
        positionGunX=positionGunX+0.05;
        positionGunY=positionGunY+0.05;
    }
    else if(positionGunY>positionY+5 && positionGunX>positionX+5 && positionGunY<positionY+15){
        positionGunX=positionGunX-0.05;
        positionGunY=positionGunY+0.05;
    }
    else if(positionGunY<=positionY+5 && positionGunX<positionX+5){
        positionGunX=positionGunX-0.05;
        positionGunY=positionGunY+0.05;
    }
    else if(positionGunY>positionY+5 && positionGunX<positionX+5 && positionGunY<=positionY+15){
        positionGunX=positionGunX+0.05;
        positionGunY=positionGunY+0.05;
    }
    
    if (positionGunX==positionX+5){
        positionGunX=positionGunX+0.1;
    }
        
    
    }
    
    public void handleGravity(){
        
        if(Environement.positionYleftTank!=Environement.floorMemoryY[Environement.positionXleftTank/5]-10){
            positionGunY=positionGunY-Environement.positionYleftTank+Environement.floorMemoryY[Environement.positionXleftTank/5]-10;
            Environement.positionYleftTank=Environement.floorMemoryY[Environement.positionXleftTank/5]-10;
            
        }
        if(Environement.positionYrightTank!=Environement.floorMemoryY[Environement.positionXrightTank/5]-10){
            Environement.positionYrightTank=Environement.floorMemoryY[Environement.positionXrightTank/5]-10;
        }
        
        
        
        
    }
    public void handleGun(){
        if(positionGunX>positionX+15){
            positionGunX=positionGunX-0.1;
        }
    }
    public void loseHp(Shell shell){
        
        
        
    }
}
