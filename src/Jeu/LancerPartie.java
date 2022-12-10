package Jeu;

import java.awt.BorderLayout;

import Controllers.InputJoueur;
import Models.Carte;
import Models.Case;
import Models.Serpent;
import Views.Frame;
import Views.PanelCarte;
import Views.PanelScore;

public class LancerPartie {
	
	private Carte carte;
	
	private Serpent serpent;
	
	private Frame fenetre;
	
	private PanelCarte panelJeu;
	
	private PanelScore panelScore;
	
	public static int indexNiveau;
	
	public static int scoreJoueur;
	
	public LancerPartie() {
		this.carte = new Carte(25,25);
		this.serpent = new Serpent(carte.getHauteur()/2,carte.getLargeur()/2,carte);
		this.fenetre = new Frame();
		this.fenetre.addKeyListener(new InputJoueur(serpent));
		
		this.panelScore = new PanelScore(scoreJoueur, carte, 500, 200);
		this.panelScore.setBounds(0,0,500,200);
		this.panelScore.setLayout(new BorderLayout());
		this.fenetre.add(panelScore);
		
		this.panelJeu = new PanelCarte(carte, 500, 500);
		this.panelJeu.setBounds(0,200,500,500);
		this.panelJeu.setLayout(new BorderLayout());
		this.fenetre.add(panelJeu);
		
		this.indexNiveau = 1;
		this.scoreJoueur = 0;
	}

	public void nouvellePartie() throws InterruptedException {
		//boucle de jeu
		while(true) {
			Case arriereSerpent = this.serpent.getCorpsSerpent().getLast();
			this.serpent.setArriereSerpent(arriereSerpent);
			
			int coordHauteur = this.serpent.getCoordHauteur();
			int coordLargeur = this.serpent.getCoordLargeur();
			
			switch(this.serpent.getSerpentDirection()) {
				case 0:
					this.serpent.deplacementSerpent(coordLargeur,coordHauteur-1);
					break;
				case 1:
					this.serpent.deplacementSerpent(coordLargeur+1,coordHauteur);
					break;
				case 2:
					this.serpent.deplacementSerpent(coordLargeur,coordHauteur+1);
					break;
				case 3:
					this.serpent.deplacementSerpent(coordLargeur-1,coordHauteur);
					break;
			}
			carte.actualiserMatrice(indexNiveau, this.serpent);
			carte.setCase(arriereSerpent);
			carte.afficherMatrice();
			panelJeu.repaint();
			panelScore.repaint();
			
			if(Jeu.LogiqueJeu.partieEnCours == false) {
				finPartie();
				return;
			}
			Thread.sleep(125-this.indexNiveau*6);
		}
	}

	public void finPartie() {
		System.out.println("Game Over");
		System.exit(-1);
	}
}
