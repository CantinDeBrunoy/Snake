package Models;
//déclaration d'une classe abstraite Case
//cette classe étends les classes Accelerateur, Bombe, ElementSerpent, Fosse, Pomme, Ralentisseur, Serpent et Sol
public abstract class Case {
	//déclaration des variables:
	//variable de la hauteur de la carte
	//variable de la valeur de la case
	protected int valeur;
	//variable du nom de la case
	protected String nom;
	//variable de la coordonnée en y de la case
	protected int coordHauteur;
	//variable de la coordonnée en x de la case
	protected int coordLargeur;
	//construction de l'objet
	protected Case(int valeur,String nom,int coordHauteur,int coordLargeur) {
		//valeur de la case
		this.valeur = valeur;
		//nom de la case
		this.nom = nom;
		//coordonnée en x de la case
		this.coordHauteur = coordHauteur;
		//coordonnée en y de la case
		this.coordLargeur = coordLargeur;
	}
	//méthode qui permet l'affichage des caractéristiques de la case dans la console
	public String toString() {
		//ex: 2, Bombe, 12, 7
		return this.valeur + ", " + this.nom + ", " + this.coordLargeur + ", " + this.coordHauteur + " ";
	}
	//getter abstrait de l'entier qui défini la valeur de la case
	public abstract int getValeur();
	//getter abstrait de l'entier qui défini la coordonnée en x de la case
	protected abstract int getCoordLargeur();
	//getter abstrait de l'entier qui défini la coordonnée en y de la case
	protected abstract int getCoordHauteur();
	//méthode abstraite qui définie le comportement adopté en cas de collision avec la tête du serpent
	public abstract void Collision(Serpent s);
}
