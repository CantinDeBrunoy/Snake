package Models;

public class Bombe extends Case {

	protected Bombe(int coordHauteur, int coordLargeur) {
		super(2, "bombe", coordHauteur, coordLargeur);
	}

	@Override
	public void Collision(Serpent s) {
		Jeu.LogiqueJeu.partieEnCours = false;
		System.out.println("Collision avec une bombe");
	}


	@Override
	public int getValeur() {
		return this.valeur;
	}

	@Override
	protected int getCoordLargeur() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getCoordHauteur() {
		// TODO Auto-generated method stub
		return 0;
	}
}
