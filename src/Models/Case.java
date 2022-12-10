package Models;

public abstract class Case {

	protected int valeur;
	protected String nom;
	protected int coordHauteur;
	protected int coordLargeur;

	protected Case(int valeur,String nom,int coordHauteur,int coordLargeur) {
		this.valeur = valeur;
		this.nom = nom;
		this.coordHauteur = coordHauteur;
		this.coordLargeur = coordLargeur;
	}
	
	public String toString() {
		return this.valeur + ", " + this.nom + ", " + this.coordLargeur + ", " + this.coordHauteur + " ";
	}

	public abstract int getValeur();

	protected abstract int getCoordLargeur();

	protected abstract int getCoordHauteur();
	
	public abstract void Collision(Serpent s);
}
