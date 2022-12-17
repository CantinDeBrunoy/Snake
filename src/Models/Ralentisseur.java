package Models;

/**
  * Model d'un Ralentisseur.
  * Ce model est bonus
  * lorsque le joueur entre en colision avec un ralentisseur alors le serpent est ralenti
  * @param coordHauteur,coordLargeur les coordonnées du ralentisseur
  */

public class Ralentisseur extends Case {
	//construction de l'objet aux coordonnées en argument
	protected Ralentisseur(int coordHauteur, int coordLargeur) {
		//valeur de la case, nom de l'objet, coordonnée en y, coordonnée en x
		super(4, "Ralentisseur", coordHauteur, coordLargeur);
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
	* Collision est appele lorsque le serpent rentre en collision avec le ralentisseur.
	* dans ce cas alors sa vitesse est diminuée
	* @param s sepent
	*/

	@Override
	public void Collision(Serpent s) {
		//modification de la vitesse de déplacement du serpent : 
		//nouvelle_Vitesse = vitesse_actuelle*2 - 100
		s.setVitesse((s.getVitesse()*2)-100);
	}
}
