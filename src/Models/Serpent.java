package Models;

import java.util.LinkedList;

public class Serpent extends Case{
	
	private ElementSerpent elementSerpent;
	
	private Carte carte;
	
	public int direction=0;
	
	private LinkedList<ElementSerpent> corpsSerpent = new LinkedList<ElementSerpent>();
	
	private Case arriereSerpent;
	
	public Serpent(int coordHauteur, int coordLargeur, Carte carte) {
		super(1, "Serpent", coordHauteur, coordLargeur);
		this.carte = carte;
		this.elementSerpent = new ElementSerpent(this.coordHauteur,this.coordLargeur);
		this.corpsSerpent.add(this.elementSerpent);
		this.corpsSerpent.add(new ElementSerpent(this.coordHauteur,this.coordLargeur-1));
		this.setArriereSerpent(this.getCorpsSerpent().getLast());
	}
	
	public void ajouterElementSerpent() {
		this.corpsSerpent.add(new ElementSerpent(this.arriereSerpent.coordHauteur,this.arriereSerpent.coordLargeur));
		this.carte.setNombrePommes(this.carte.getNombrePommes()-1);
	}
	
	public void printCorpsSerpent() {
		for(ElementSerpent s : this.corpsSerpent) {
			System.out.println(s);
		}
	}
	
	public void deplacementSerpent(int coordLargeur, int coordHauteur) {
		if(!horsCarte(coordHauteur,coordLargeur)) {
			entreEnCollision(coordHauteur,coordLargeur);
			for(int i=this.corpsSerpent.size();i>1;i--) {
				ElementSerpent arriereSerpent = this.corpsSerpent.get(i-2);
				this.corpsSerpent.set(i-1, arriereSerpent);
			}
			this.elementSerpent = new ElementSerpent(coordHauteur,coordLargeur);
			this.corpsSerpent.set(0, this.elementSerpent);			
		}
	}

	private void entreEnCollision(int hauteur,int largeur) {
		if(carte.matrice[hauteur][largeur].getValeur() != 0) {
			this.carte.matrice[hauteur][largeur].Collision(this);
		}
	}
	
	private boolean horsCarte(int hauteur,int largeur) {
		//System.out.println("coord serpent: " + hauteur + " " + largeur);
		if(hauteur<0 || largeur<0 || largeur>carte.getLargeur()-1 || hauteur>carte.getHauteur()-1) {
			Jeu.LogiqueJeu.partieEnCours = false;
			System.out.println("Game Over");
			return true;
		}
		return false;
	}

	@Override
	public int getValeur() {
		return this.valeur;
	}
	
	public int getCoordHauteur() {
		return this.elementSerpent.getCoordHauteur();
	}
	
	public int getCoordLargeur() {
		return this.elementSerpent.getCoordLargeur();
	}

	public void setCoordLargeur(int coordLargeur) {
		this.elementSerpent.setCoordLargeur(coordLargeur);
	}

	public void setCoordHauteur(int coordHauteur) {
		this.elementSerpent.setCoordHauteur(coordHauteur);
	}

	public LinkedList<ElementSerpent> getCorpsSerpent() {
		return this.corpsSerpent;
	}

	public void setSerpentDirection(int direction) {
		if(this.direction!=(direction+2)%4) {
			this.direction = direction;
		}
	}

	public int getSerpentDirection() {
		return this.direction;
	}

	@Override
	public void Collision(Serpent s) {
		
	}

	public Case getArriereSerpent() {
		return arriereSerpent;
	}

	public void setArriereSerpent(Case arriereSerpent) {
		this.arriereSerpent = arriereSerpent;
	}
}
