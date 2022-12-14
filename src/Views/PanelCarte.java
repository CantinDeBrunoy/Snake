package Views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import Models.Carte;
//déclaration d'une classe PanelCarte qui extends JPanel
//affiche graphiquement la carte ainsi que tout les éléments qui sont dans la matrice
public class PanelCarte extends JPanel{
	//déclaration d'un objet carte
	private Carte carte;
	//construction de l'objet avec les dimensions en arguments
	public PanelCarte(Carte carte,int hauteur,int largeur) {
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
		//parcours en hauteur de la carte
		for(int i=0;i<this.carte.getHauteur();i++) {
			//parcours en largeur de la carte
			for(int j=0;j<this.carte.getLargeur();j++) {
				//déclaration de deux tableaux de coordonées pour dessiner des triangles :
				//coordonnées des points en x
				int[]coordTriX={j*20,j*20+10,j*20+20};
				//coordonnées des points en y
				int[]coordTriY={i*20+20,i*20,i*20+20};
				//remplissage de la carte :
				//condition représentant une case sur deux de la matrice
				if(i%2==0 && j%2==0 || i%2==1 && j%2==1) {
					//attribuer une couleur à l'élément dessiné
					g2.setColor(new Color(118, 201, 143));						
				}
				else {
					//attribuer une couleur à l'élément dessiné
					g2.setColor(new Color(170, 226, 187));						
				}
				//remplir avec des carrés de taille 20px par 20px
				g2.fillRect(j*20, i*20, j*20+20, i*20+20);
				//si la case de la matrice est un serpent
				if(this.carte.matrice[i][j].getValeur()==1) {
					//attribuer une couleur à l'élément dessiné
					g2.setColor(new Color(255, 174, 38));
					//remplir avec des carrés de taille 20px par 20px
					g2.fillRect(j*20, i*20, j*20+20, i*20+20);
				}
				//sinon si la case de la matrice est une bombe
				else if(this.carte.matrice[i][j].getValeur()==2) {
					//attribuer une couleur à l'élément dessiné
					g2.setColor(new Color(23, 86, 104));
					//remplir avec des ronds de diamètre 20px
					g2.fillOval(j*20, i*20, 20, 20);
				}
				//sinon si la case de la matrice est une pomme
				else if(this.carte.matrice[i][j].getValeur()==3) {
					//attribuer une couleur à l'élément dessiné
					g2.setColor(new Color(236, 23, 43));
					//remplir avec des ronds de diamètre 20px
					g2.fillOval(j*20, i*20, 20, 20);
				}
				//sinon si la case de la matrice est un ralentisseur
				else if(this.carte.matrice[i][j].getValeur()==4){
					//attribuer une couleur à l'élément dessiné
					g2.setColor(new Color(181, 21, 121));
					//remplir avec des triangles
					g2.fillPolygon(coordTriX, coordTriY, 3);
				}
				//sinon si la case de la matrice est un accélérateur
				else if(this.carte.matrice[i][j].getValeur()==5){
					//attribuer une couleur à l'élément dessiné
					g2.setColor(new Color(255, 238, 69));
					//remplir avec des triangles
					g2.fillPolygon(coordTriX, coordTriY, 3);
				}
				//sinon si la case de la matrice est un fossé
				else if(this.carte.matrice[i][j].getValeur()==6) {
					//attribuer une couleur à l'élément dessiné
					g2.setColor(new Color(55, 24, 8));
					//remplir avec des carrés de taille 20px par 20px
					g2.fillRect(j*20, i*20, j*20+20, i*20+20);
				}
			}
		}
	}	
}
