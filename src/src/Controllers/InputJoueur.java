package Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Models.Serpent;

public class InputJoueur implements KeyListener {

	Serpent serpent;
	
	public InputJoueur(Serpent serpent) {
		//on récupère l'objet Serpent
		this.serpent = serpent;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// inutile dans notre cas
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//recupère le code correspondant à la touche sur laquelle le joueur appuie
	    int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	    	//flèche directionnelle haut
	        case KeyEvent.VK_UP:
	        	//appelle de ma méthode pour changer la direction du serpent
	        	this.serpent.setSerpentDirection(0);
	            break;
	        //flèche directionnelle droite
	        case KeyEvent.VK_RIGHT :
	        	//appelle de ma méthode pour changer la direction du serpent
	        	this.serpent.setSerpentDirection(1);
	        	break;
	        //flèche directionnelle bas
	        case KeyEvent.VK_DOWN:
	        	//appelle de ma méthode pour changer la direction du serpent
	        	this.serpent.setSerpentDirection(2);
	            break;
	        //flèche directionnelle gauche
	        case KeyEvent.VK_LEFT:
	        	//appelle de ma méthode pour changer la direction du serpent
	        	this.serpent.setSerpentDirection(3);
	        	break;
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// inutile dans notre cas
	}
}