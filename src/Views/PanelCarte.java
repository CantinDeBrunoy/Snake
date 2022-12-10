package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Models.Carte;

public class PanelCarte extends JPanel{
	
	private Carte carte;
	
	public PanelCarte(Carte carte,int hauteur,int largeur) {
		super();
		this.carte = carte;
		this.setPreferredSize(new Dimension(hauteur,largeur));
		this.setMinimumSize(new Dimension(hauteur,largeur));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g.create();
		for(int i=0;i<this.carte.getHauteur();i++) {
			for(int j=0;j<this.carte.getLargeur();j++) {
				if(this.carte.matrice[i][j].getValeur()==0) {
					if(i%2==0 && j%2==0 || i%2==1 && j%2==1) {
						g2.setColor(new Color(118, 201, 143));						
					}
					else {
						g2.setColor(new Color(170, 226, 187));						
					}
				}
				else if(this.carte.matrice[i][j].getValeur()==1) {
					g2.setColor(new Color(255, 174, 38));
				}
				else if(this.carte.matrice[i][j].getValeur()==2) {
					g2.setColor(new Color(23, 86, 104));
				}
				else {
					g2.setColor(new Color(236, 23, 43));
				}
				g2.fillRect(j*20, i*20, j*20+20, i*20+20);
			}
			
		}
	}
	
}
