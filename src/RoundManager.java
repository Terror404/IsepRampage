
import IsepRampage.IsepRampage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Pierre P
 */
public class RoundManager {
    
    public int setRound = 0;
    public int player = 0;
    public int rCounter = 0;
    
    public RoundManager(){
        
        switch (player){
            case 0 :
                player = (int) Math.random()*2+1;
                break;
            case 1 :
                player = 2;
                break;
            case 2 :
                player = 1;
                break;
        }
    }
    
    public void RoundCounter(){
        if (IsepRampage.keyPressed != 0 && rCounter < 1000){
            rCounter = rCounter++;
        }
        else{
            rCounter = 0;
        }
    }
}
