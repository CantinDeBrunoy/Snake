package Jeu;
//déclaration d'une classe LogiqueJeu
//détermine si la partie débute ou prend fin

/**
  * Logique du jeu.
  * permet de gerer l'état de la partie
  * @throws InterruptedException
  */

public class LogiqueJeu {
	//déclaration d'une variable booléenne pour déterminer si la partie est en cours ou non
	//initialisation à true, la partie est lancée
	public static boolean partieEnCours = true;
	//méthode qui vérifie si la partie débute ou prend fin
	public static void main(String[] args) throws InterruptedException {
		//création d'un nouvelle objet pour lancer le jeu
		LancerPartie LP = new LancerPartie();
		//si la variable est à true, la partie se lance
		if(partieEnCours) {
			//appel de la méthode  
			LP.nouvellePartie();
		}
		//si la variable est à false, la partie se termine
		else {
			//appel de la méthode
			LP.finPartie();
		}
	}
}