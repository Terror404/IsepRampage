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
    public int index;
    public double positionGunX;
    public double positionGunY;
    public int hp;
    
    
    public Tank(int positionX,int positionY,int index,double positionGunX, double positionGunY, int hp){
       this.positionX=positionX;
       this.positionY=positionY;
       this.positionGunX=positionGunX;
       this.positionGunY=positionGunY;
       this.index=index;
       
       this.hp=hp;
    }
    
    public void moveTankLeft(){
        index=index-1;
        positionGunX=positionGunX-(Environement.floorMemoryX[index]-Environement.floorMemoryX[index-1]);
        positionX=Environement.floorMemoryX[index];
        
        
        
        
        
    }
    public void moveTankRight(){
        index=index+1;
        positionGunX=positionGunX-(Environement.floorMemoryX[index]-Environement.floorMemoryX[index+1]);
        positionX=Environement.floorMemoryX[index];
        
        
        
        
        
    }
    
    public void moveGunUp(){
    
    if(positionGunY<=positionY+5 && positionGunX>positionX+5 && positionGunY>positionY-10){
        positionGunX=positionGunX-0.05;
        positionGunY=positionGunY-0.05;
        /*positionGunY=Math.sqrt(100-(positionGunX-positionX-5)*(positionGunX-positionX-5))+positionY;*/
        
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
        
        if(positionY!=Environement.floorMemoryY[index]||positionY!=Environement.floorMemoryY[index]-10){
            if(positionGunY>positionY-5 && positionGunY<positionY+15){
            positionGunY=positionGunY-positionY+Environement.floorMemoryY[index]-10;
            }
            
            positionY=Environement.floorMemoryY[index]-10;
            
        }
        
        
        
        
        
    }
    public void handleGun(){
        if(positionGunX>positionX+15){
            positionGunX=positionX+15;
        }
        if(positionGunX<positionX-10){
            positionGunX=positionX-5;
        }
        if(positionGunY<positionY-5){
            positionGunY=positionY-5;
        }
        if(positionGunY>positionY+15){
            positionGunY=positionY+15;
        }
    }
    public void loseHp(Shell shell){
        
        
        
    }
}
