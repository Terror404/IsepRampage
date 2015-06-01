package Environement;





import Object.Shell;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JComponent;


public class Generator extends JComponent{
    
     private static final long serialVersionUID = 1L;
     private static boolean generatePolygon=false;
     
     public static ArrayList<Polygon> TilesG= new ArrayList<Polygon>();
     /*private int floorMemory[][]=new int[200][300];*/
     private static int a =100;
     private static int i =2;
     private static int k =0;
     public static int nbrPoints=271;
     public static boolean setMap=false;
     public static boolean damageMap=false;
     public static int impactX=100;
     public static int impactY;
     
     
     
     public Generator(Graphics2D g2d){
     if(setMap==false || i<nbrPoints+1){
         Environement.floorMemoryIndexAdd[i]=0;
         if(i<nbrPoints+1){
         
         Environement.floorMemoryX[0]=0;
         Environement.floorMemoryY[0]=720;
         Environement.floorMemoryX[1]=-5;
         Environement.floorMemoryY[1]=500;
         
         Environement.floorMemoryX[nbrPoints-1]=5*271;
         Environement.floorMemoryY[nbrPoints-1]=720;
         
         if(i<nbrPoints){
           if(i%4==0 && (i<75||(i>200 && i<nbrPoints))){
           a= (int) ((int) a+ (int) 4.0*(Math.random()-0.35));
           }
           else if(i%2==0 && i<140 && i>75){
               a= (int) ((int) a+ (int) 7.0*(Math.random()-0.75));
           }
           else if(i%2==0 && i>140 && i<nbrPoints){
               a= (int) ((int) a+ (int) 7.0*(Math.random()-0.05));
           }
           
           if(a<0){
               a=a+1;
           }
           if(a>110){
               a=a-1;
           }
           Environement.floorMemoryX[i]=5*i;
           Environement.floorMemoryY[i]=5*a;
           
           if(i==270){
               Environement.drawEnvironement=true;
           }
            
           
           
         i=i+1;
     }
         TilesG.add(new Polygon());
         generatePolygon=true;
         }setMap = true;
     } 
     
    }
     
     
}
    

