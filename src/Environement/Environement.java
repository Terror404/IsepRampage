package Environement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import IsepRampage.IsepRampage;
import static IsepRampage.IsepRampage.window;
import Object.ClusterShell;
import Object.HeavyShell;
import Object.NormalShell;
import Object.SabotShell;
import Object.Shell;
import Object.Tank;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class Environement extends JComponent {

    public static final long serialVersionUID = 1L;
    public static boolean Generation = false;
    public static int floorMemoryX[] = new int[2000];
    public static int floorMemoryY[] = new int[2000];
    public static int floorMemoryIndexAdd[]=new int[2000];
    public static ArrayList<Tank> tankList;
    
    
    public static int positionXleftTank = 5 * 10 + 5 * (int) ((Math.random() - 0.5));
    public static int positionYleftTank;
    public static int positionXrightTank = 5 * 240 + 5 * (int) ((Math.random() - 0.5));
    public static int positionYrightTank;
    public static double positionGunXleftTank;
    public static double positionGunYleftTank;
    public static double positionGunXrightTank;
    public static double positionGunYrightTank;
    public static int indexLeftTank;
    public static int indexRightTank;
    public static int speedLeftTank = 1;
    public static int f = 0;
    
    public static boolean drawEnvironement = false;
    public static boolean setTank = false;
    public static int playerTurn=0;
     public static int shellCollided=0;    
    public static int setWind = 0;
    public Wind vent;
    public static int windForce;
    
    private int colorShell;
    private int fired;
    private int typeShell;
    private int setShell;
    public static double powerShoot=0;
    public static double positionXShell;
    private double positionYShell;
    private double initPosSx = positionXleftTank;
    private double initPosSy = positionYleftTank;
    public double gunAngle;
    public double gunAngle2;
    public double time = 0;
    public double incrementTime = 0.05;
    
   

    public static Image BACKGROUND = Toolkit.getDefaultToolkit().createImage("nom.jpg");

    public void paintComponent(Graphics g) {
        
        
        Graphics2D g2d = (Graphics2D) g;

        InitDefaultBackground(g2d);
        //************ SET THE TANK IF IT IS NOT ALREADY DONE ************************
        
        if (setTank == false) { //set the tanks position randomly

                tankList=setTanks();
                setTank=true;
            }
        
        //**************** WIND CREATION **************************
        Wind vent = new Wind(setWind); 
        if(setWind == 0){
           
       
        vent= new Wind(setWind);
    
        
        
        setWind = 1;
        }
        vent.WindCreation(g2d);

        if (Generation == false) {
            new Generator(g2d);

        } else {
            System.out.print("fuck");
        }

        if (drawEnvironement == true) {
            
            f=f+1;
            
            
            new DrawG(g2d);
            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                Logger.getLogger(Environement.class.getName()).log(Level.SEVERE, null, ex);
            }
        window.repaint();
        

        

        
//************  HANDLE THE GRAVITY  **********************************************        
        
            //Tank leftTank = new Tank(tankList.get(playerTurn%2).positionX, positionYleftTank - (floorMemoryY[indexLeftTank] - floorMemoryY[(indexLeftTank) + 1]),indexLeftTank,positionGunXleftTank,positionGunYleftTank,100);
            tankList.get(0).handleGravity();
            tankList.get(0).handleGun();
            tankList.get(1).handleGravity();
            tankList.get(1).handleGun();
            //rightTank.handleGravity();

            


//************ HANDLE KEYBOARD EVENTS - FREE MOVE AND AIM *********************            

               if(IsepRampage.keyPressed==37 && tankList.get(playerTurn%2).positionY<floorMemoryY[(int)(tankList.get(playerTurn%2).index)-1]+10){ //if we press the left button and there isn't a mountain ahead of the tank
                    tankList.get(playerTurn%2).moveTankLeft();
                   // indexLeftTank=tankList.get(playerTurn%2).index;
                    
                    
                    
                }
                else if(IsepRampage.keyPressed==39 && tankList.get(playerTurn%2).positionY<floorMemoryY[(int)(tankList.get(playerTurn%2).index)+1]+10){//if we press the right button and there isn't a mountain ahead of the tank
                    tankList.get(playerTurn%2).moveTankRight();
                    //indexLeftTank=tankList.get(playerTurn%2).index;
                    
                    
                
                }
               else if(IsepRampage.keyPressed==38){
                    
                    tankList.get(playerTurn%2).moveGunUp();
                }
               else if(IsepRampage.keyPressed==40){
                    
                    tankList.get(playerTurn%2).moveGunDown();
                }
               
            
               
               //**********************************************
               
         
        

// ********* HANDLE KEYBOARD EVENTS - SHELL CHOICE AND TRIGGER *************
        if (fired == 0){
            if(IsepRampage.keyPressed == 49){           /*  touche "&"  */
                typeShell = 1;
                colorShell = 1;
                
            }
            else if(IsepRampage.keyPressed == 50){      /*  touche "é"  */
                typeShell = 2;
                colorShell = 2;
            }
            else if (IsepRampage.keyPressed == 51){     /*  touche """  */
                typeShell = 3;
                colorShell = 3;
            }
            else if (IsepRampage.keyPressed == 52){     /*  touche"'"   */
                typeShell = 4;
                colorShell = 4; 
            }

            if(IsepRampage.keyPressed == 61 && (typeShell == 1 || typeShell == 2 || typeShell == 3 || typeShell == 4)&& IsepRampage.keyReleased!=61 ){           /*  Touche "="  */
                
                if(powerShoot<200.0){
                powerShoot=powerShoot+0.4;
                }
            }
            if(IsepRampage.keyReleased==61 && (typeShell == 1 || typeShell == 2 || typeShell == 3 || typeShell == 4)&& IsepRampage.keyPressed==61 ){
                fired = 1;
                }
        }
        
        // ************* DETERMINATION OF THE GUN ANGLE *******************
        
        if (tankList.get(playerTurn%2).positionY+ 5 <= tankList.get(playerTurn%2).positionGunY){
            if (tankList.get(playerTurn%2).positionGunX <= tankList.get(playerTurn%2).positionX + 5){
                gunAngle2 = (Math.atan2((tankList.get(playerTurn%2).positionGunY - tankList.get(playerTurn%2).positionY + 5), (tankList.get(playerTurn%2).positionX + 5 - tankList.get(playerTurn%2).positionGunX)));
                gunAngle =  (Math.PI + gunAngle2);
            }
            else{
                gunAngle2 = (Math.atan2((tankList.get(playerTurn%2).positionGunY - tankList.get(playerTurn%2).positionY  + 5), (tankList.get(playerTurn%2).positionGunX - tankList.get(playerTurn%2).positionX  + 5 )));
                gunAngle =  (2 * Math.PI - gunAngle2);
            }
            
        }
        else{
            if(tankList.get(playerTurn%2).positionGunX <= tankList.get(playerTurn%2).positionX + 5){
                gunAngle2 = (Math.atan2((tankList.get(playerTurn%2).positionY + 5 - tankList.get(playerTurn%2).positionGunY), (tankList.get(playerTurn%2).positionX + 5 - tankList.get(playerTurn%2).positionGunX)));
                gunAngle =  (Math.PI - gunAngle2);
            }
            else{
                gunAngle = (2*Math.atan2((tankList.get(playerTurn%2).positionY - tankList.get(playerTurn%2).positionGunY + 5), (tankList.get(playerTurn%2).positionGunX - tankList.get(playerTurn%2).positionX  + 5)));
            }
        }
        System.out.println(Math.toDegrees(gunAngle));
        System.out.println(Math.cos(gunAngle));
        /*
        System.out.println((10* time * time)/2);*/
        /*System.out.println( indexLeftTank);
        System.out.println(floorMemoryY[indexLeftTank]);
        System.out.println(tankList.get(playerTurn%2).positionY);
        System.out.println("-------------------------------");*/
        
        
        
        
        
        // ************* SHELL CREATION AND TRAJECTORY ********************
        if (fired == 1){
            
       
            
            if (setShell == 0){
                positionXShell = tankList.get(playerTurn%2).positionGunX;
                positionYShell = tankList.get(playerTurn%2).positionGunY;
                initPosSx = tankList.get(playerTurn%2).positionX+windForce;
                initPosSy = tankList.get(playerTurn%2).positionY;
                setShell = 1;
            }
            else{
            
            
            if(IsepRampage.keyPressed != 522 && positionXShell < 1300 && positionXShell > 0 && positionYShell-5< floorMemoryY[(int)(positionXShell+15)/5] && shellCollided==0){
                 /*System.out.println("position en y : " + positionYShell+5 );
                 System.out.println(floorMemoryY[(int)(positionXShell-15)/5]);*/
                if(typeShell == 1){ 
                    NormalShell launchedShell = new NormalShell(positionXShell, positionYShell, initPosSx, initPosSy);
/*
                    System.out.println("position en x : " + positionXShell);*/
                   /*
                    System.out.println("temps : " + time);*/

                    launchedShell.move(gunAngle, time);
                    new DrawShell(g2d, launchedShell, positionXShell, positionYShell, colorShell);
                    positionXShell = launchedShell.positionSx;
                    positionYShell = launchedShell.positionSy;
                    time = time + incrementTime;
                    launchedShell.collideFloor(tankList.get((playerTurn+1)%2));
                    
                }

                else if (typeShell == 2){        
                    HeavyShell launchedShell = new HeavyShell(positionXShell, positionYShell, initPosSx, initPosSy);
                    launchedShell.move(gunAngle, time);
                    new DrawShell(g2d, launchedShell, launchedShell.positionSx, launchedShell.positionSy, colorShell);
                    
                    positionXShell = launchedShell.positionSx;
                    positionYShell = launchedShell.positionSy;
                    time = time + incrementTime;
                    launchedShell.collideFloor(tankList.get((playerTurn+1)%2));
                }

                else if (typeShell == 3){
                    ClusterShell launchedShell = new ClusterShell(positionXShell, positionYShell, initPosSx, initPosSy);

                    launchedShell.move(gunAngle, time);
                    new DrawShell(g2d, launchedShell, positionXShell, positionYShell, colorShell);

                    positionXShell = launchedShell.positionSx;
                    positionYShell = launchedShell.positionSy;
                    time = time + incrementTime;
                    launchedShell.collideFloor(tankList.get((playerTurn+1)%2));
                }
                else if (typeShell == 4){
                    SabotShell launchedShell = new SabotShell(positionXShell, positionYShell, initPosSx, initPosSy);
                    launchedShell.move(gunAngle, time/5);
                    new DrawShell(g2d, launchedShell, launchedShell.positionSx, launchedShell.positionSy, colorShell);
                    
                    positionXShell = launchedShell.positionSx;
                    positionYShell = launchedShell.positionSy;
                    time = time + incrementTime;
                    launchedShell.collideFloor(tankList.get((playerTurn+1)%2));
                    
                }
            }
            else{
                typeShell = 0;
                colorShell = 0;
                
                positionXShell = tankList.get(playerTurn%2).positionX;
                positionYShell = tankList.get(playerTurn%2).positionY; 
                time = 0;
                setShell=0;
                powerShoot=0;
                if(shellCollided==1){
                
                fired=0;
                shellCollided=0;
            }
            }
            }
            
            
        }
        
        
        
        
               
               
            //****************************************************
            if (tankList.get(playerTurn%2).positionX > 1250) {
            tankList.get(playerTurn%2).positionX=1250;
        }
        else if(tankList.get(playerTurn%2).positionX < 15){
            tankList.get(playerTurn%2).positionX=15;
        }
            /*
            positionXleftTank=tankList.get(0).positionX; 
            positionXrightTank=tankList.get(1).positionX;
            positionGunXleftTank=tankList.get(0).positionGunX;
            positionGunYleftTank=tankList.get(0).positionGunY;
            positionGunXrightTank=tankList.get(1).positionGunX;
            positionGunYrightTank=tankList.get(1).positionGunY;*/
            new DrawTank(g2d, tankList.get(0) /*tankList.get(0).positionX, tankList.get(0).positionY - (floorMemoryY[tankList.get(0).index] - floorMemoryY[tankList.get(0).index + 1])*/,tankList.get(0).hp);
            new DrawTank(g2d, tankList.get(1),/* tankList.get(1).positionX, tankList.get(1).positionY - (floorMemoryY[tankList.get(1).index] - floorMemoryY[tankList.get(1).index + 1]),*/tankList.get(1).hp);
            
            
        
        }

            



    
    }

    

    public void InitDefaultBackground(Graphics2D g2d){ //defines the background of the game
        
        g2d.drawImage(BACKGROUND, 0,0,IsepRampage.window.getWidth(),IsepRampage.window.getHeight(),null);
        IsepRampage.window.repaint();
    }
    
    private ArrayList<Tank> setTanks(){
        
        ArrayList<Tank> tankList=new ArrayList<Tank>();
                indexLeftTank=(int)(positionXleftTank/5 );
                indexRightTank=(int)(positionXrightTank/5 );
                positionYleftTank = floorMemoryY[indexLeftTank] - 10;
                positionYrightTank = floorMemoryY[indexRightTank] - 10;
                positionGunXleftTank=(double)positionXleftTank+15;
                positionGunYleftTank=(double)positionYleftTank+5;
                positionGunXrightTank=(double)positionXrightTank-5;
                positionGunYrightTank=(double)positionYrightTank+5;
                System.out.print("done");
                
                Tank rightTank = new Tank(positionXrightTank, positionYrightTank+(floorMemoryY[indexRightTank] - floorMemoryY[(indexRightTank) + 1]),indexRightTank,positionGunXrightTank,positionGunYrightTank,100);
                Tank leftTank = new Tank(positionXleftTank, positionYleftTank +(floorMemoryY[indexLeftTank] - floorMemoryY[(indexLeftTank) + 1]),indexLeftTank,positionGunXleftTank,positionGunYleftTank,100);
                tankList.add(leftTank);
                tankList.add(rightTank);
                
                
                return tankList;
    }
    
}   
    
    
    
  
