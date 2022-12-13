package Models;

public class Sol extends Case  {
	
	public Sol(int coordHauteur,int coordLargeur) {
		super(0, "Sol",coordHauteur,coordLargeur);
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
		// TODO Auto-generated method stub
		
	}
}
