package Models;
//déclaration d'une classe ElementSerpent qui extend la classe Case

/**
  * Model d'un ElemementSerpent.
  * Ce model constitue un element du serpent
  * @param coordHauteur,coordLargeur les coordonnées d'un accelerateur
  */

public class ElementSerpent extends Case{
	//construction de l'objet aux coordonnées en argument
	public ElementSerpent(int coordHauteur, int coordLargeur) {
		//valeur de la case, nom de l'objet, coordonnée en y, coordonnée en x
		super(1, "teteSerpent", coordHauteur, coordLargeur);
	}
	//implémentation des méthodes abstraites de la classe Case :
	//getter de la valeur de la case
	@Override
	public int getValeur() {
		//retourne l'entier qui défini la valeur
		return this.valeur;
	}
	//getter de la coordonnées en y de la case
	public int getCoordHauteur() {
		//retourne l'entier qui défini la coordonnée en y
		return this.coordHauteur;
	}
	//getter de la coordonnées en x de la case
	public int getCoordLargeur() {
		//retourne l'entier qui défini la coordonnée en x
		return this.coordLargeur;
	}
	//setter de la coordonées en x de la case
	public void setCoordLargeur(int coordLargeur) {
		//attribution à la case de la valeur en argument de la méthode
		this.coordLargeur = coordLargeur;
	}
	//setter de la coordonées en y de la case
	public void setCoordHauteur(int coordHauteur) {
		//attribution à la case de la valeur en argument de la méthode
		this.coordHauteur = coordHauteur;
	}
	/**
	* Collision est appele lorsque le serpent rentre en collision avec lui meme.
	* dans ce cas alors la partie est terminée.
	* @param s sepent
	*/
	@Override
	public void Collision(Serpent s) {
		//modification de la variable pour mettre fin à la partie
		Jeu.LogiqueJeu.partieEnCours = false;
		//System.out.println("Collision avec la queue du serpent");
	}

}
