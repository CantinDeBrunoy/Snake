package Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Models.Serpent;

public class InputJoueur implements KeyListener {

	Serpent serpent;
	
	public InputJoueur(Serpent serpent) {
		this.serpent = serpent;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// inutile dans notre cas
	}

	@Override
	public void keyPressed(KeyEvent e) {
	    int keyCode = e.getKeyCode();
	    switch( keyCode ) { 
	        case KeyEvent.VK_UP:
	        	this.serpent.setSerpentDirection(0);
	            break;
	        case KeyEvent.VK_RIGHT :
	        	this.serpent.setSerpentDirection(1);
	        	break;
	        case KeyEvent.VK_DOWN:
	        	this.serpent.setSerpentDirection(2);
	            break;
	        case KeyEvent.VK_LEFT:
	        	this.serpent.setSerpentDirection(3);
	        	break;
	    }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// inutile dans notre cas
	}
}