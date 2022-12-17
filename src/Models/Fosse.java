package Models;

/**
  * Model d'une Fosse.
  * Ce model est bonus
  * lorsque le joueur entre en colision avec la fosse alors la partie se termine
  * @param coordHauteur,coordLargeur les coordonnées d'une fosse
  */

public class Fosse extends Case{
	//construction de l'objet aux coordonnées en argument
	protected Fosse(int coordHauteur, int coordLargeur) {
		//valeur de la case, nom de l'objet, coordonnée en y, coordonnée en x
		super(6, "Fosse", coordHauteur, coordLargeur);
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
	
	/**
	* Collision est appele lorsque le serpent rentre en collision avec la fosse.
	* dans ce cas alors la partie est terminée.
	* @param s sepent
	*/

	@Override
	public void Collision(Serpent s) {
		//modification de la variable pour mettre fin à la partie
		Jeu.LogiqueJeu.partieEnCours = false;
		//System.out.println("Collision avec une case fosse");
	}

}
