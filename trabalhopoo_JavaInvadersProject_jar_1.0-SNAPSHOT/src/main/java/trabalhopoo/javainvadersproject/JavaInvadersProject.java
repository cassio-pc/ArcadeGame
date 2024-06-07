package trabalhopoo.javainvadersproject;

import javax.swing.JFrame;

public class JavaInvadersProject {

    public static void main(String[] args) {
        
        JFrame janela =new JFrame("Space Invaders");
        janela.setSize(600,600);
        janela.setLayout(null);
        janela.setLocationRelativeTo(null);
        
        SpaceInvaders invasaoAlienigena  = new SpaceInvaders();
        invasaoAlienigena.setBounds(0,0,1366,768);
        
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        janela.setVisible(true);
    }
}
