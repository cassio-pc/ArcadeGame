package trabalhopoo.javainvadersproject;

import javax.swing.JPanel;
public class SpaceInvaders extends JPanel implements Runnable {
    
    //Metodo construtor para quando chamarmos new SpaceInvaders
    public SpaceInvaders(){
        
        Thread lacoDoJogo = new Thread(this);
        
    }
    
    @Override
    public void run(){
        
        while(true){            
            update();
            repaint();
            dorme();            
        }
             
    }
    
}
