package Models;
//déclaration d'une classe Pomme qui extend la classe Case
//lors de la collision de la case avec la tête du serpent celui-ci s'allonge d'une case
public class Pomme extends Case {
	//construction de l'objet aux coordonnées en argument
	protected Pomme(int coordHauteur, int coordLargeur) {
		//valeur de la case, nom de l'objet, coordonnée en y, coordonnée en x
		super(3, "Pomme", coordHauteur, coordLargeur);
	}
	//implémentation des méthodes abstraites de la classe Case :
	//getter de la valeur de la case
	@Override
	public int getValeur() {
		//retourne l'entier qui défini la valeur
		return this.valeur;
	}
	//getter de la coordonnées en x de la case
	@Override
	protected int getCoordLargeur() {
		//retourne l'entier qui défini la coordonnée en x
		return this.coordLargeur;
	}
	//getter de la coordonnées en y de la case
	@Override
	protected int getCoordHauteur() {
		//retourne l'entier qui défini la coordonnée en y
		return this.coordHauteur;
	}
	//méthode appelée lors de la collision de la tête du serpent avec cette case
	@Override
	public void Collision(Serpent s) {
		//appel de la méthode pour faire grandir le serpent
		s.ajouterElementSerpent();
		//incrémentation du score en fonction du niveau de la partie et de la vitesse du serpent
		Jeu.LancerPartie.scoreJoueur+=5*Jeu.LancerPartie.indexNiveau*(s.getVitesse()/24);
		//System.out.println("Croc");
	}


}
