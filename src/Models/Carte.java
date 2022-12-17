package Models;

/**
  * Model d'une carte.
  * crée une matrice de Case Sol qui représente la carte de jeu
  * ajoute des cases Pomme et Bombe à des emplacements aléatoires dans la matrice à chaque niveau
  * ajoute éventuellement des bonus ou malus à des emplacements aléatoires dans la matrice à chaque niveau
  * @param hauteur,largeur les dimensions de la carte
  */

public class Carte {
	//déclaration de la matrice de Case
	public Case[][] matrice;
	//déclaration des variables:
	//variable de la hauteur de la carte
	private int hauteur;
	//variable de la largeur de la carte
	private int largeur;
	//variable du nombre de pommes sur la carte
	public int nombrePommes;
	//variable du nombre de bombes sur la carte
	public int nombreBombes;
	//constructeur de l'objet Carte avec les dimensions renseignées lors de l'appel
	public Carte(int hauteur, int largeur) {
		//hauteur de la carte
		this.hauteur = hauteur;
		//largeur de la carte
		this.largeur = largeur;
		//nombre de pommes sur la carte
		this.nombrePommes = 0;
		//nombre de bombes sur la carte
		this.nombreBombes = 0;
		//création de la matrice de Case de dimension hauteur x largeur
		this.matrice = new Case[this.hauteur][this.largeur];
		//remplissage de la matrice de Case avec des objets Sol
		//parcours de la matrice en y
		for(int i=0;i<this.hauteur;i++) {
			//parcours de la matrice en x
			for(int j=0;j<this.largeur;j++) {
				//création d'un objet Sol aux coordonnées (y,x)
				//à l'emplacement [y][x] de la matrice
				this.matrice[i][j] = new Sol(i,j);
			}
		}
	}
	//méthode d'affichage de la matrice remplie dans la console

	/**
	* Methode permettant d'afficher la matrice dans la console.
	*/

	public void afficherMatrice() {
		//parcours de la matrice en y
		for(int i=0;i<this.hauteur;i++) {
			//parcours de la matrice en x
			for(int j=0;j<this.largeur;j++) {
				//affichage de la valeur de la Case[i][j] dans la console
				System.out.print(this.matrice[i][j].valeur + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	/**
	* Méthode d'actualisation de la matrice.
	* Elle actualise le serpent
	* Elle actualise des cases si necessaires ( nouveau niveau ) en fonction du niveau
	* @param indexNiveau,serpent l'index du niveau et le serpent
	* @return la matrice

	*/

	public Case[][] actualiserMatrice(int indexNiveau, Serpent serpent) {
		//appel de la méthode pour déplacer le serpent
		actualiserSerpent(serpent);
		//si le nombre de pomme dans la matrice est de zéro
		if(this.nombrePommes==0) {
			//le jeu passe au niveau supérieur
			Jeu.LancerPartie.indexNiveau+=1;
			//appel de la méthode pour tirer aléatoirement un bonus
			selectionBonus();
			//appel de la méthode pour ajouter des pommes à la matrice en fonction du niveau
			ajoutPommes(indexNiveau);
			//appel de la méthode pour ajouter des bombes à la matrice en fonction du niveau
			ajoutBombes(indexNiveau);			
		}
		//retourne la matrice avec les nouvelles cases
		return this.matrice;
	}
	//méthode qui choisie aléatoirement quel bonus sera ajouté à la matrice

	/**
	* Methode qui permet de generer aléatoirement des bonus.
	*/

	private void selectionBonus() {
		//déclaration d'une variable qu'on initialise au tirage aléatoire d'un nombre entier entre 0 et 100
		int alea = (int)(Math.random() * 100);
		//Si la variable est un nombre entre 100 et 90 non inclu
		if(alea <= 100 && alea > 90) {
			//appel de la méthode pour ajouter un bonus à la matrice
			//l'argument 4 désigne le ralentisseur
			ajoutBonus(4);
		}
		//Si la variable est un nombre entre 90 et 75
		else if(alea <= 90 && alea >= 75) {
			//appel de la méthode pour ajouter un bonus à la matrice
			//l'argument 5 désigne l'accélérateur
			ajoutBonus(5);
		}
		//Si la variable est un nombre entre 5 et 0
		else if(alea <= 5) {
			//appel de la méthode pour ajouter un bonus à la matrice
			//l'argument 6 désigne le fossé
			ajoutBonus(6);
		}
		//Si la variable est un nombre entre 75 et 5 non inclus
		else {
			//Aucun bonus n'est ajouté
		}
	}
	//méthode pour ajouter un bonus à la matrice

	/**
	* Methode qui permet d'ajouter aléatoirement des bonus.
	* @param typeBonus le type de bonus qui doit etre generé
	*/

	private void ajoutBonus(int typeBonus) {
		//déclaration d'une variable qui détermine si le bonus est ajouté à la matrice
		//initialisation de la variable à faux
		boolean estAjoute = false;
		//tant que la variable est à faux
		while(!estAjoute) {
			//déclaration d'une variable pour les coordonnées en hauteur d'une position aléatoire dans la matrice
			//on l'initialise au tirage aléatoire d'un nombre entier entre 0 et la hauteur de la carte
			int randomHauteur = (int)(Math.random() * this.hauteur);
			//déclaration d'une variable pour les coordonnées en largeur d'une position aléatoire dans la matrice
			//on l'initialise au tirage aléatoire d'un nombre entier entre 0 et la largeur de la carte
			int randomLargeur = (int)(Math.random() * this.largeur);
			//si le bonus à ajouter est un fossé
			//modification des variables randomHauteur et randomLargeur de façon à ce que le fossé le puisse pas être créé hors de la carte
			if(typeBonus == 6) {
				//tirage aléatoire d'un nombre entre 1 et la hauteur de la carte - 1
				randomHauteur = (int)(Math.random() *(this.hauteur-1 - 1))+1;
				//tirage aléatoire d'un nombre entre 1 et la largeur de la carte - 1
				randomLargeur = (int)(Math.random() *(this.largeur-1 - 1))+1;
			}
			//System.out.println(randomHauteur);
			//System.out.println(randomLargeur);
			//si l'emplacement aux coordonnées aléatoires dans la matrice est occupé par un Sol
			if(this.matrice[randomHauteur][randomLargeur].getValeur() == 0) {
				//si le bonus tiré aléatoirement est un ralentisseur
				if(typeBonus == 4) {
					//ajout d'un nouvel objet ralentisseur dans la matrice à l'emplacement tiré aléatoirement 
					this.matrice[randomHauteur][randomLargeur] = new Ralentisseur(randomHauteur,randomLargeur);
				}
				//si le bonus tiré aléatoirement est un accélérateur
				else if(typeBonus == 5) {
					//ajout d'un nouvel objet accélérateur dans la matrice à l'emplacement tiré aléatoirement 
					this.matrice[randomHauteur][randomLargeur] = new Accelerateur(randomHauteur,randomLargeur);
				}
				//si le bonus tiré aléatoirement est un fossé
				else if(typeBonus == 6) {
					//déclaration d'une variable qui détermine si un emplacement suffisant pour le fossé est trouvé
					//initialisation de la variable à faux
					boolean fosseTrouve = false;
					//tant que l'emplacement pour le fossé n'est pas trouvé
					while(!fosseTrouve) {
						//si les emplacements autour de la case centrale du fossé dans la matrice sont occupés par des objets Sol
						if(this.matrice[randomHauteur+1][randomLargeur].getValeur()==0 && 
								this.matrice[randomHauteur][randomLargeur+1].getValeur()==0 &&
								this.matrice[randomHauteur-1][randomLargeur].getValeur()==0 &&
								this.matrice[randomHauteur][randomLargeur-1].getValeur()==0)
						//ajout d'un nouvel objet fosse dans la matrice à l'emplacement tiré aléatoirement
						this.matrice[randomHauteur][randomLargeur] = new Fosse(randomHauteur,randomLargeur);
						//ajout d'un nouvel objet fosse dans la matrice sur les cases adjacentes à l'emplacement tiré aléatoirement
						this.matrice[randomHauteur+1][randomLargeur] = new Fosse(randomHauteur+1,randomLargeur); 
						this.matrice[randomHauteur][randomLargeur+1] = new Fosse(randomHauteur,randomLargeur+1);
						this.matrice[randomHauteur-1][randomLargeur] = new Fosse(randomHauteur-1,randomLargeur);
						this.matrice[randomHauteur][randomLargeur-1] = new Fosse(randomHauteur,randomLargeur-1);
						//modification de la variable car l'emplacement pour le fossé est trouvé
						fosseTrouve = true;
					}
				}
				//modification de la variable car l'emplacement pour le bonus est trouvé
				estAjoute = true;
			} else {
				//Aucun emplacement trouvé pour le bonus
				//System.out.println("Case " + randomHauteur + ":" + randomLargeur + " deja occupee");
			}
		}		
	}
	
	/**
	* Methode qui permet d'ajouter des pommes selon l'index du niveau.
	* @param indexNiveau l'index du niveau
	*/

	public void ajoutPommes(int indexNiveau) {
		//tant que le niveau de la partie est différent du nombre de pommes
		while(indexNiveau!=this.nombrePommes) {
			//déclaration d'une variable pour les coordonnées en hauteur d'une position aléatoire dans la matrice
			//on l'initialise au tirage aléatoire d'un nombre entier entre 0 et la hauteur de la carte
			int randomHauteur = (int)(Math.random() * this.hauteur);
			//déclaration d'une variable pour les coordonnées en largeur d'une position aléatoire dans la matrice
			//on l'initialise au tirage aléatoire d'un nombre entier entre 0 et la largeur de la carte
			int randomLargeur = (int)(Math.random() * this.largeur);
			//si l'emplacement aux coordonnées aléatoires dans la matrice est occupé par un Sol
			if(this.matrice[randomHauteur][randomLargeur].getValeur() == 0) {
				//ajout d'un nouvel objet pomme dans la matrice à l'emplacement tiré aléatoirement
				this.matrice[randomHauteur][randomLargeur] = new Pomme(randomHauteur,randomLargeur);
				//incrémentation du nombre de pommes dans la matrice
				this.nombrePommes++;
			} else {
				//Aucun emplacement trouvé pour la pomme
				//System.out.println("Case " + randomHauteur + ":" + randomLargeur + " deja occupee");
			}
		}
		
	}
	
	/**
	* Methode qui permet d'ajouter des bombes selon l'index du niveau.
	* @param indexNiveau l'index du niveau
	*/

	public void ajoutBombes(int indexNiveau) {
		//si le niveau de la partie - 1 est supérieur à 0
		if(indexNiveau-1>0) {
			//tant que le niveau de la partie - 1 est différent du nombre de pommes
			while(indexNiveau-1!=this.nombreBombes) {
				//déclaration d'une variable pour les coordonnées en hauteur d'une position aléatoire dans la matrice
				//on l'initialise au tirage aléatoire d'un nombre entier entre 0 et la hauteur de la carte
				int randomHauteur = (int)(Math.random() * this.hauteur);
				//déclaration d'une variable pour les coordonnées en largeur d'une position aléatoire dans la matrice
				//on l'initialise au tirage aléatoire d'un nombre entier entre 0 et la largeur de la carte
				int randomLargeur = (int)(Math.random() * this.largeur);
				//si l'emplacement aux coordonnées aléatoires dans la matrice est occupé par un Sol
				if(this.matrice[randomHauteur][randomLargeur].getValeur() == 0) {
					//ajout d'un nouvel objet bombe dans la matrice à l'emplacement tiré aléatoirement
					this.matrice[randomHauteur][randomLargeur] = new Bombe(randomHauteur,randomLargeur);
					//incrémentation du nombre de bombes dans la matrice
					this.nombreBombes++;
				} else {
					//Aucun emplacement trouvé pour la bombe
					//System.out.println("Case " + randomHauteur + ":" + randomLargeur + " deja occupee");
				}
			}
		} else {
			//aucune bombe ne doit être placée
			//System.out.println("Il n'y a pas de bombes a ce niveau");
		}
	}
	
	/**
	* Methode qui permet d'actualiser le serpent
	* @param serpent serpent
	*/

	public void actualiserSerpent(Serpent serpent) {
		//pour tout les objets ElementSerpent de la liste chainée corpsSerpent de l'objet Serpent
		for(ElementSerpent s : serpent.getCorpsSerpent()) {
			//positionne l'objet ElementSerpent dans la matrice aux coordonnées retournées par les getters de l'objet Serpent
			this.matrice[s.getCoordHauteur()][s.getCoordLargeur()] = s;
		}
	}
	//getter de la hauteur de la carte
	public int getHauteur() {
		//retourne l'entier qui défini la hauteur de la carte
		return this.hauteur;
	}
	//getter de la largeur de la carte
	public int getLargeur() {
		//retourne l'entier qui défini la largeur de la carte
		return this.largeur;
	}
	//setter d'un nouvel objet case aux cases précédemment occupées par le serpent ou des pommes, des bombes ou des bonus
	public void setCase(Case nouvelleCase) {
		//création d'un objet Sol dans la matrice aux coordonnées retournée par la méthode nouvelleCase 
		this.matrice[nouvelleCase.getCoordHauteur()][nouvelleCase.getCoordLargeur()] = new Sol(nouvelleCase.getCoordHauteur(),nouvelleCase.getCoordLargeur());
	}
	//getter du nombre de pommes dans la matrice
	public int getNombrePommes() {
		//retourne l'entier qui défini le nombre de pommes dans la matrice
		return this.nombrePommes;
	}
	//setter du nombre de pommes restant dans la matrice
	public void setNombrePommes(int nombrePomme) {
		//définie le nombre de pommes dans la matrice par rapport à l'entier passer en argument de la méthode
		this.nombrePommes = nombrePomme;
	}
}
