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
		// TODO Auto-generated method stub
		
	}
}
