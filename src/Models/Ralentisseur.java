package Models;

public class Ralentisseur extends Case {

	protected Ralentisseur(int coordHauteur, int coordLargeur) {
		super(4, "Ralentisseur", coordHauteur, coordLargeur);
	}

	@Override
	public int getValeur() {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public void Collision(Serpent s) {
		s.setVitesse(s.getVitesse()*50);
	}

}
