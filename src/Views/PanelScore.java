package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.Carte;
//déclaration d'une classe PanelCarte qui extends JPanel
//affiche graphiquement le tableau de score de la partie
public class PanelScore extends JPanel {
	//déclaration d'un objet carte
	private Carte carte;
	//déclaration des objets JLabel qui contiennent du texte :
	private JLabel labelScore;
	private JLabel labelBombe;
	private JLabel labelPomme;
	private JLabel labelNiveau;
	//construction de l'objet avec les dimensions en arguments
	public PanelScore(Carte carte, int hauteur, int largeur) {
		super();
		//attribution de l'objet carte en argument à la carte de la classe
		this.carte = carte;
		//défini les dimensions recommandées pour l'affichage
		this.setPreferredSize(new Dimension(hauteur,largeur));
		this.setMinimumSize(new Dimension(hauteur,largeur));
	}
	//implémentation de la méthodes abstraites de la classe JPanel :
	//permet l'affichage graphique de l'interface du jeu
	@Override
	public void paintComponent(Graphics g) {
		//déclaration d'un objet graphique
		Graphics2D g2 = (Graphics2D)g.create();
		//attribuer une couleur à l'élément dessiné
		g2.setColor(Color.darkGray);
		//remplir avec un rectangle de taille 500px par 200px
		g2.fillRect(0, 0, 500, 200);
		//retirer les précédents label pour permettre l'actualisation des différents scores
		if(this.labelScore != null) {
			this.remove(this.labelScore);
			this.remove(this.labelBombe);
			this.remove(this.labelPomme);
			this.remove(this.labelNiveau);
		}
		//afficher le score du joueur
		this.labelScore = new JLabel("Votre score : " + Jeu.LancerPartie.scoreJoueur);
		this.labelScore.setForeground(Color.white);
		this.labelScore.setBounds(40,10,400,50);
		this.add(labelScore);
		//afficher le nombre pommes en jeu
		this.labelPomme = new JLabel("Nombre de pommes : " + this.carte.nombrePommes);
		this.labelPomme.setForeground(Color.white);
		this.labelPomme.setBounds(40,70,400,50);
		this.add(labelPomme);
		//afficher le nombre de bombes en jeu
		this.labelBombe = new JLabel("Nombre de bombes : " + this.carte.nombreBombes);
		this.labelBombe.setForeground(Color.white);
		this.labelBombe.setBounds(40,140,400,50);
		this.add(labelBombe);
		//afficher le niveau actuel de la partie
		this.labelNiveau = new JLabel("Niveau : " + (Jeu.LancerPartie.indexNiveau - 1));
		this.labelNiveau.setForeground(Color.white);
		this.labelNiveau.setBounds(400,140,400,50);
		this.add(labelNiveau);
		
	}
}
