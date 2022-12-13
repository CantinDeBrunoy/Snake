package Models;

public class Accelerateur extends Case{

	protected Accelerateur(int coordHauteur, int coordLargeur) {
		super(5, "Accelerateur", coordHauteur, coordLargeur);
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
		s.setVitesse((s.getVitesse()/2)+(s.getVitesse()/3));
	}

}
