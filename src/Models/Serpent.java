package Models;
//import de la bibliothèque pour gérer les listes chainées
import java.util.LinkedList;
//déclaration d'une classe Serpent qui extend la classe Case

/**
  * Model d'un serpent.
  * contient toutes les méthodes relatives au comportement du serpent
  * @param coordHauteur,coordLargeur,carte les coordonnées de la tete du serpent, la carte
  */

public class Serpent extends Case{
	//objet contenant les informations de la carte
	private Carte carte;
	//objet représentant un seul maillon du serpent
	private ElementSerpent elementSerpent;
	//liste chainée d'objets ElementSerpent représentant le serpent
	private LinkedList<ElementSerpent> corpsSerpent = new LinkedList<ElementSerpent>();
	//objet contenant le dernier élément de la liste chainée corpsSerpent
	private Case arriereSerpent;
	//déclaration des variables:
	//variable de la vitesse de déplacement du serpent
	private int vitesse = 125;
	//variable de la direction dans laquelle le serpent avance
	public int direction = 0;
	//construction de l'objet aux coordonnées en argument
	public Serpent(int coordHauteur, int coordLargeur, Carte carte) {
		//valeur de la case, nom de l'objet, coordonnée en y, coordonnée en x
		super(1, "Serpent", coordHauteur, coordLargeur);
		//carte dans laquelle le serpent se déplace
		this.carte = carte;
		//création d'un nouvel objet elementSerpent aux coordonnées en argument
		this.elementSerpent = new ElementSerpent(this.coordHauteur,this.coordLargeur);
		//ajout de l'objet précédemment créé dans la liste chainée corpsSerpent
		this.corpsSerpent.add(this.elementSerpent);
		//ajout d'un nouvel objet elementSerpent à la fin de la liste chainée corpsSerpent
		//ses coordonnées sont celles passées en arguments avec -1 en x
		this.corpsSerpent.add(new ElementSerpent(this.coordHauteur,this.coordLargeur-1));
		//attribution du dernier élément de la liste chainée
		this.setArriereSerpent(this.getCorpsSerpent().getLast());
	}

	/**
	* méthode qui permet au serpent de grandir d'un élémentSerpent.
	*/

	public void ajouterElementSerpent() {
		//ajout d'un nouvel objet elementSerpent à la fin de la liste chainée corpsSerpent
		//ses coordonnées sont celles de la dernière case de la liste chainée corpsSerpent
		this.corpsSerpent.add(new ElementSerpent(this.arriereSerpent.coordHauteur,this.arriereSerpent.coordLargeur));
		//décrémentation du nombre de pommes présentes dans la matrice
		this.carte.setNombrePommes(this.carte.getNombrePommes()-1);
	}
	
	/**
	* méthode qui permet d'afficher le serpent dans la console
	*/

	public void printCorpsSerpent() {
		//pour tout les éléments de la liste chainées corpsSerpent
		for(ElementSerpent s : this.corpsSerpent) {
			//affichage des élements de l'objet serpent dans la console
			System.out.println(s);
		}
	}

	/**
	* méthode qui permet le déplacement du serpent dans la matrice.
	* @param coordLargeur,coordHauteur la valeur de la nouvelle case de la tete
	*/

	//
	public void deplacementSerpent(int coordLargeur, int coordHauteur) {
		//si le serpent n'est pas en dehors de la matrice
		if(!horsCarte(coordHauteur,coordLargeur)) {
			//appel de la méthode qui gère les collisions avec les différentes cases
			entreEnCollision(coordHauteur,coordLargeur);
			//pour tout les éléments sauf le premier de la liste chainée corpsSerpent 
			for(int i=this.corpsSerpent.size();i>1;i--) {
				//création d'un objet arriereSerpent de type ElementSerpent
				//attribution de l'objet positionné à la position i-2
				ElementSerpent arriereSerpent = this.corpsSerpent.get(i-2);
				//attribution à l'index i-1 de la liste chainée le nouvel objet arriereSerpent 
				this.corpsSerpent.set(i-1, arriereSerpent);
			}
			//création d'un nouvel objet ElementSerpent aux coordonnées en arguments
			this.elementSerpent = new ElementSerpent(coordHauteur,coordLargeur);
			//attribution à l'index 0 de la liste chainée le nouvel objet Elementserpent
			this.corpsSerpent.set(0, this.elementSerpent);			
		}
	}

	/**
	* méthode qui permet d'appeler les méthodes collision des cases avec lesquels le serpent rentre en collision.
	* @param hauteur,largeur les coordonnées de la case avec laquelle le serpent vient de rentrer en collision
	*/

	private void entreEnCollision(int hauteur,int largeur) {
		//si la case aux coordonnées en arguments est différente d'une case Sol
		if(carte.matrice[hauteur][largeur].getValeur() != 0) {
			//appelle la méthode collision de l'objet avec lequel le serpent entre en collision
			this.carte.matrice[hauteur][largeur].Collision(this);
		}
	}
	/**
	* méthode qui permet de savoir si le serpent est sortie de la carte.
	* @param hauteur,largeur les coordonnées de la tete du serpent
	* @return un boolean selon si le serpent est sortie de la zone de jeu ou non
	*/

	private boolean horsCarte(int hauteur,int largeur) {
		//si l'une des coordonnées en arguments est plus petite que 0 ou plus grande que la taille de la carte - 1
		if(hauteur<0 || largeur<0 || largeur>carte.getLargeur()-1 || hauteur>carte.getHauteur()-1) {
			//modification de la variable pour mettre fin à la partie
			Jeu.LogiqueJeu.partieEnCours = false;
			//retourne vrai pour mettre fin au déplacement du serpent dans la méthode associée
			return true;
		}
		//retourne faux dans les autres cas pour poursuivre le déplacement du serpent
		return false;
	}
	//getter de la coordonnée en y des éléments du serpent
	public int getCoordHauteur() {
		//retourne l'entier qui défini la coordonnée en y
		return this.elementSerpent.getCoordHauteur();
	}
	//getter de la coordonnée en x des éléments du serpent
	public int getCoordLargeur() {
		//retourne l'entier qui défini la coordonnée en x
		return this.elementSerpent.getCoordLargeur();
	}
	//setter de la coordonnée en x des éléments du serpent
	public void setCoordLargeur(int coordLargeur) {
		//attribution de la nouvelle coordonée en x
		this.elementSerpent.setCoordLargeur(coordLargeur);
	}
	//setter de la coordonnée en y des éléments du serpent
	public void setCoordHauteur(int coordHauteur) {
		//attribution de la nouvelle coordonée en x 
		this.elementSerpent.setCoordHauteur(coordHauteur);
	}
	//getter de la liste chainée d'objets elementSerpent
	public LinkedList<ElementSerpent> getCorpsSerpent() {
		//retourne la liste chainée d'objets elementSerpent
		return this.corpsSerpent;
	}
	//setter de la direction dans laquelle le serpent avance
	public void setSerpentDirection(int direction) {
		//si la direction choisie par le joueur n'est pas celle opposée à la direction actuelle
		if(this.direction!=(direction+2)%4) {
			//attribution de la nouvelle direction en argument de la méthode
			this.direction = direction;
		}
	}
	//getter de la direction dans laquelle le serpent avance
	public int getSerpentDirection() {
		//retourne l'entier qui défini la direction
		return this.direction;
	}
	//getter de la case à l'arrière du serpent
	public Case getArriereSerpent() {
		//retourne l'objet case se trouvant à l'arrière du serpent
		return arriereSerpent;
	}
	//setter de la case à l'arrière du serpent
	public void setArriereSerpent(Case arriereSerpent) {
		//attribue l'objet case en argument à l'arrière du serpent
		this.arriereSerpent = arriereSerpent;
	}
	//getter de la vitesse de déplacement du serpent
	public int getVitesse() {
		//retourne l'entier qui défini la vitesse de déplacement du serpent
		return vitesse;
	}
	//setter de la vitesse de déplacement du serpent
	public void setVitesse(int vitesse) {
		//défini la vitesse de déplacement du serpent avec l'entier en argument
		this.vitesse = vitesse;
	}
	//implémentation des méthodes abstraites de la classe Case :
	//getter de la valeur de la case
	@Override
	public int getValeur() {
		//retourne l'entier qui défini la valeur
		return this.valeur;
	}
	//méthode appelée lors de la collision de la tête du serpent avec cette case
	@Override
	public void Collision(Serpent s) {
		//aucun comportement spécifique
	}
}
