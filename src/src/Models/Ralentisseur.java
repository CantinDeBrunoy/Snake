package Models;
//déclaration d'une classe Ralentisseur qui extend la classe Case
//lors de la collision de la case avec la tête du serpent, sa vitesse de déplacement est diminuée
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
	//méthode appelée lors de la collision de la tête du serpent avec cette case
	@Override
	public void Collision(Serpent s) {
		//modification de la vitesse de déplacement du serpent : 
		//nouvelle_Vitesse = vitesse_actuelle*2 - 100
		s.setVitesse((s.getVitesse()*2)-100);
	}
}
