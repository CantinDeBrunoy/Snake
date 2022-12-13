package Models;

public class Fosse extends Case{

	protected Fosse(int coordHauteur, int coordLargeur) {
		super(6, "Fosse", coordHauteur, coordLargeur);
	}

	@Override
	public int getValeur() {
		return this.valeur;
	}

	@Override
	protected int getCoordLargeur() {
		return this.coordLargeur;
	}

	@Override
	protected int getCoordHauteur() {
		return this.coordHauteur;
	}

	@Override
	public void Collision(Serpent s) {
		Jeu.LogiqueJeu.partieEnCours = false;
	}

}
