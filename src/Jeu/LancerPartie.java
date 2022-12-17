package Jeu;

import java.awt.BorderLayout;

import Controllers.InputJoueur;
import Models.Carte;
import Models.Case;
import Models.Serpent;
import Views.Frame;
import Views.PanelCarte;
import Views.PanelScore;

/**
  * LancerPartie permet de soit lancer une partie soit afficher le gameOver.
  * dans LancerPartie on va instancier la fenetre ainsi que les differents panels.
  * on va également instancer certaines variable static comme le socre ansi que l'index du niveau
  */

public class LancerPartie {
	//objet 
	private Carte carte;
	//objet 
	private Serpent serpent;
	//objet contenant la fenêtre où s'affiche le jeu
	private Frame fenetre;
	//objet pour l'affichage de la carte du jeu et ses éléments
	private PanelCarte panelJeu;
	//objet pour l'affichage du score du jeu
	private PanelScore panelScore;
	//variable static qui contient le niveau auquel le joueur joue
	public static int indexNiveau;
	//variable static qui contient le score actuel du joueur durant sa partie
	public static int scoreJoueur;
	
	public LancerPartie() {
		//création d'une nouvelle carte de dimension 25 cases par 25 cases
		this.carte = new Carte(25,25);
		//création d'un nouveau serpent à la position x:13 y:13
		this.serpent = new Serpent(carte.getHauteur()/2,carte.getLargeur()/2,carte);
		//création d'une nouvelle fenêtre pour l'affichage de l'interface graphique
		this.fenetre = new Frame();
		this.fenetre.addKeyListener(new InputJoueur(serpent));
		
		//création d'un nouvel élément panel affichant le score à la fenêtre
		this.panelScore = new PanelScore(carte, 500, 200);
		//dimension du panel de 500 par 200 à l'emplacement x:0 y:0 
		this.panelScore.setBounds(0,0,500,200);
		this.panelScore.setLayout(new BorderLayout());
		//ajout du panel à la fenêtre 
		this.fenetre.add(panelScore);
		
		//création d'un nouvel élément panel affichant la carte et ses éléments à la fenêtre
		this.panelJeu = new PanelCarte(carte, 500, 500);
		//dimension 500 par 500 à l'emplacement x:0 y:200
		this.panelJeu.setBounds(0,200,500,500);
		this.panelJeu.setLayout(new BorderLayout());
		//ajout du panel à la fenêtre 
		this.fenetre.add(panelJeu);
		
		//initialisation des variables static
		indexNiveau = 1;
		scoreJoueur = 0;
	}

	/**
		* Methode qui permet de lancer une partie.
		* Une boucle de jeu est crée afin de gerer les different évènements du niveau ( comme la direction du serpent ou l'actualisation de la matrice de jeu)
		* @throws InterruptedExceptio
		*/

	public void nouvellePartie() throws InterruptedException {
		//boucle de jeu
		while(true) {
			//assignation du dernier élément de la liste chainée pour pouvoir faire grandir le serpent
			Case arriereSerpent = this.serpent.getCorpsSerpent().getLast();
			this.serpent.setArriereSerpent(arriereSerpent);
			//assignation des coordonnées de la tête du serpent
			int coordHauteur = this.serpent.getCoordHauteur();
			int coordLargeur = this.serpent.getCoordLargeur();
			
			switch(this.serpent.getSerpentDirection()) {
				case 0:
					//actualisation de la position du serpent en décrémentant y de 1 (pour aller vers le haut)
					this.serpent.deplacementSerpent(coordLargeur,coordHauteur-1);
					break;
				case 1:
					//actualisation de la position du serpent en incrémentant x de 1 (pour aller vers la droite)
					this.serpent.deplacementSerpent(coordLargeur+1,coordHauteur);
					break;
				case 2:
					//actualisation de la position du serpent en incrémentant y de 1 (pour aller vers le bas)
					this.serpent.deplacementSerpent(coordLargeur,coordHauteur+1);
					break;
				case 3:
					//actualisation de la position du serpent en décrémentant x de 1 (pour aller vers la gauche)
					this.serpent.deplacementSerpent(coordLargeur-1,coordHauteur);
					break;
			}
			//appel de la méthode pour actualiser la matrice
			carte.actualiserMatrice(indexNiveau, this.serpent);
			//appel de la méthode pour remplacer la case à l'arrière du serpent
			carte.setCase(arriereSerpent);
			//carte.afficherMatrice();
			//affichage et actualisation de l'interface graphique à chaque itération de la boucle de jeu
			panelJeu.repaint();
			panelScore.repaint();
			//si la variable static qui définie la fin de partie passe à vrai
			if(Jeu.LogiqueJeu.partieEnCours == false) {
				//appel de la méthode qui met fin à la partie
				finPartie();
				return;
			}
			//temps de pause pour la répétition de la boucle de jeu qui correspond indirectement à la vitesse de déplacement du serpent
			Thread.sleep(serpent.getVitesse()-indexNiveau*6);
		}
	}

	/**
	* Méthode de fin de partie
	* Commentaires détaillés sur le role de la methode
	*/
	public void finPartie() {
		System.out.println("Game Over");
		System.exit(-1);
	}
}
