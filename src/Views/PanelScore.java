package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.Carte;

public class PanelScore extends JPanel {
	
	private JLabel labelScore;
	
	private JLabel labelBombe;
	
	private JLabel labelPomme;
	
	private JLabel labelNiveau;
	
	private Carte carte;
	
	public PanelScore(Carte carte, int hauteur, int largeur) {
		super();
		this.setPreferredSize(new Dimension(hauteur,largeur));
		this.setMinimumSize(new Dimension(hauteur,largeur));
		this.carte = carte;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g.create();
		
		g2.setColor(Color.darkGray);
		g2.fillRect(0, 0, 500, 200);
		if(this.labelScore != null) {
			this.remove(this.labelScore);
			this.remove(this.labelBombe);
			this.remove(this.labelPomme);
			this.remove(this.labelNiveau);
		}
		
		this.labelScore = new JLabel("Votre score : " + Jeu.LancerPartie.scoreJoueur);
		this.labelScore.setForeground(Color.white);
		this.labelScore.setBounds(40,10,400,50);
		this.add(labelScore);
		
		this.labelPomme = new JLabel("Nombre de pommes : " + this.carte.nombrePommes);
		this.labelPomme.setForeground(Color.white);
		this.labelPomme.setBounds(40,70,400,50);
		this.add(labelPomme);
		
		this.labelBombe = new JLabel("Nombre de bombes : " + this.carte.nombreBombes);
		this.labelBombe.setForeground(Color.white);
		this.labelBombe.setBounds(40,140,400,50);
		this.add(labelBombe);
		
		this.labelNiveau = new JLabel("Niveau : " + (Jeu.LancerPartie.indexNiveau - 1));
		this.labelNiveau.setForeground(Color.white);
		this.labelNiveau.setBounds(400,140,400,50);
		this.add(labelNiveau);
		
	}
}
