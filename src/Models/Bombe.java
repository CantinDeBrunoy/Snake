package Models;

public class Bombe extends Case {

	protected Bombe(int coordHauteur, int coordLargeur) {
		super(2, "bombe", coordHauteur, coordLargeur);
	}

	@Override
	public void Collision(Serpent s) {
		Jeu.LogiqueJeu.partieEnCours = false;
		//System.out.println("Collision avec une bombe");
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
}
