package Views;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JFrame;
//déclaration d'une classe Frame qui extends JFrame
//affiche une fenêtre sur l'écran du joueur
public class Frame extends JFrame{
    //création d'une méthode
    public Frame() {
        //construction
    	super();
        //permet à la fermeture de la fenêtre de mettre fin au programme
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //suppresion du layout par défaut
        this.setLayout(null);
        //rend visible la fenêtre
        this.setVisible(true);
        //affiche un titre dans la barre de l'application
        this.setTitle("Snake | Cantin ROQUIER - François MUTTI");
        //défini les bordures de la fenêtre 
        Insets inset = this.getInsets();
        //défini la dimension par défaut de la fenêtre
        setPreferredSize(new Dimension(500+inset.left+inset.right,700+inset.top+inset.bottom));
        pack();
    }
}
