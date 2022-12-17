package Models;

/**
  * Model d'un sol.
  * @param coordHauteur,coordLargeur les coordonnées du sol
  */


public class Sol extends Case  {
	//construction de l'objet aux coordonnées en argument
	protected Sol(int coordHauteur, int coordLargeur) {
		//valeur de la case, nom de l'objet, coordonnée en y, coordonnée en x
		super(0, "Sol", coordHauteur, coordLargeur);
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
	* Collision est appele lorsque le serpent rentre en collision avec le sol.
	* dans ce cas alors rien ne se passe.
	* @param s sepent
	*/

	@Override
	public void Collision(Serpent s) {
		//aucun comportement spécifique
	}
}
