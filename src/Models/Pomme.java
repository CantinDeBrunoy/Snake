package Models;

public class Pomme extends Case {

	protected Pomme(int coordHauteur, int coordLargeur) {
		super(3, "Pomme", coordHauteur, coordLargeur);
	}

	@Override
	public void Collision(Serpent s) {
		s.ajouterElementSerpent();
		Jeu.LancerPartie.scoreJoueur+=10*Jeu.LancerPartie.indexNiveau;
		//System.out.println("Croc");
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
