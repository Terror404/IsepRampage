package Environement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import IsepRampage.IsepRampage;
import static IsepRampage.IsepRampage.window;
import Object.Shell;
import Object.Tank;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.reflect.Array;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;


public class Environement extends JComponent {

    public static final long serialVersionUID = 1L;
    public static boolean Generation = false;
    public static int floorMemoryX[] = new int[Generator.nbrPoints];
    public static int floorMemoryY[] = new int[Generator.nbrPoints];
    public static int positionXleftTank = 5 * 10 + 5 * (int) ((Math.random() - 0.5));
    public static int positionYleftTank;
    public static int positionXrightTank = 5 * 240 + 5 * (int) ((Math.random() - 0.5));
    public static int positionYrightTank;
    public static double positionGunXleftTank;
    public static double positionGunYleftTank;
    public static int speedLeftTank = 1;
    public static int f = 0;
    public static boolean drawEnvironement = false;
    public static boolean setTank = false;

    public static Image BACKGROUND = Toolkit.getDefaultToolkit().createImage("nom.jpg");

    public void paintComponent(Graphics g) {
        
        
        Graphics2D g2d = (Graphics2D) g;

        InitDefaultBackground(g2d);

        if (Generation == false) {
            new Generator(g2d);

        } else {
            System.out.print("fuck");
        }

        if (drawEnvironement == true) {
            
            f=f+1;
            System.out.println(f);
            
            new DrawG(g2d);
            try {
                Thread.sleep(9);
            } catch (InterruptedException ex) {
                Logger.getLogger(Environement.class.getName()).log(Level.SEVERE, null, ex);
            }
        window.repaint();
        
//************ SET THE TANK IF IT IS NOT ALREADY DONE ************************
        
        if (setTank == false) { //set the tanks position randomly

                positionYleftTank = floorMemoryY[positionXleftTank / 5] - 10;
                positionYrightTank = floorMemoryY[positionXrightTank / 5] - 10;
                positionGunXleftTank=(double)positionXleftTank+15;
                positionGunYleftTank=(double)positionYleftTank+5;
                
                setTank = true;
            }
        

        
//************  CREATE THE TANKS **********************************************        
            Tank leftTank = new Tank(positionXleftTank, positionYleftTank - (floorMemoryY[positionXleftTank / 5] - floorMemoryY[(positionXleftTank / 5) + 1]),positionGunXleftTank,positionGunYleftTank,100);
            Tank rightTank = new Tank(positionXrightTank, positionYrightTank - (floorMemoryY[positionXrightTank / 5] - floorMemoryY[(positionXrightTank / 5) + 1]),positionXrightTank-2,positionYrightTank - (floorMemoryY[positionXrightTank / 5] - floorMemoryY[(positionXrightTank / 5) + 1])+5,100);

            leftTank.handleGravity();
            leftTank.handleGun();
            rightTank.handleGravity();

            


//************ HANDLE KEYBOARD EVENTS - FREE MOVE AND AIM *********************            

               if(IsepRampage.keyPressed==37 && leftTank.positionY<floorMemoryY[(int)(leftTank.positionX/5)-1]+5){ //if we press the left button and there isn't a mountain ahead of the tank
                    leftTank.moveTankLeft();
                    
                    
                }
                else if(IsepRampage.keyPressed==39 && leftTank.positionY<floorMemoryY[(int)(leftTank.positionX/5)+2]+5){//if we press the right button and there isn't a mountain ahead of the tank
                    leftTank.moveTankRight();
                    
                
                }
               else if(IsepRampage.keyPressed==38){
                    
                    leftTank.moveGunUp();
                }
               else if(IsepRampage.keyPressed==40){
                    
                    leftTank.moveGunDown();
                }
               
            
            
            if (positionXleftTank > 1250) {
            leftTank.positionX=1250;
        }
        else if(positionXleftTank < 15){
            leftTank.positionX=15;
        }
            new DrawTank(g2d, leftTank, leftTank.positionX, positionYleftTank - (floorMemoryY[positionXleftTank / 5] - floorMemoryY[(positionXleftTank / 5) + 1]),leftTank.hp);
            new DrawTank(g2d, rightTank, positionXrightTank, positionYrightTank - (floorMemoryY[positionXrightTank / 5] - floorMemoryY[(positionXrightTank / 5) + 1]),rightTank.hp);
            
            positionXleftTank=leftTank.positionX;
            positionGunXleftTank=leftTank.positionGunX;
            positionGunYleftTank=leftTank.positionGunY;
        }
    
    }

    

    public void InitDefaultBackground(Graphics2D g2d){ //defines the background of the game
        
        g2d.drawImage(BACKGROUND, 0,0,IsepRampage.window.getWidth(),IsepRampage.window.getHeight(),null);
        IsepRampage.window.repaint();
    }
    
    
}   
    
    
    
  