package Models;

public class ElementSerpent extends Case{

	public ElementSerpent(int coordHauteur, int coordLargeur) {
		super(1, "teteSerpent", coordHauteur, coordLargeur);
	}

	@Override
	public int getValeur() {
		return this.valeur;
	}

	public int getCoordHauteur() {
		return this.coordHauteur;
	}

	public int getCoordLargeur() {
		return this.coordLargeur;
	}

	public void setCoordLargeur(int coordLargeur) {
		this.coordLargeur = coordLargeur;
	}

	public void setCoordHauteur(int coordHauteur) {
		this.coordHauteur = coordHauteur;
	}

	@Override
	public void Collision(Serpent s) {
		Jeu.LogiqueJeu.partieEnCours = false;
		System.out.println("Aie");
	}

}
