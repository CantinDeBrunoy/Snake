package Jeu;
public class LogiqueJeu {
	
	public static boolean partieEnCours = true;
	
	public static void main(String[] args) throws InterruptedException {

		LancerPartie LP = new LancerPartie();
		
		if(partieEnCours) {
			LP.nouvellePartie();
		}
		else {
			LP.finPartie();
		}
	}
	
	
}
