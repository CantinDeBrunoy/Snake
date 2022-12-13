package Models;

public class Carte {
	
	public Case[][] matrice;
	private int hauteur;
	private int largeur;
	public int nombrePommes;
	public int nombreBombes;
	
	public Carte(int hauteur, int largeur) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.nombrePommes = 0;
		this.nombreBombes = 0;
		this.matrice = new Case[this.hauteur][this.largeur];
		
		for(int i=0;i<this.hauteur;i++) {
			for(int j=0;j<this.largeur;j++) {
				this.matrice[i][j] = new Sol(i,j);
			}
		}
	}
	
	public void afficherMatrice() {
		for(int i=0;i<this.hauteur;i++) {
			for(int j=0;j<this.largeur;j++) {
				System.out.print(this.matrice[i][j].valeur + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public Case[][] actualiserMatrice(int indexNiveau, Serpent serpent) {
		actualiserSerpent(serpent);
		if(this.nombrePommes==0) {
			Jeu.LancerPartie.indexNiveau+=1;
			//System.out.println("Ajout pommes");
			selectionBonus();
			ajoutPommes(indexNiveau);
			ajoutBombes(indexNiveau);			
		}
		return this.matrice;
	}

	private void selectionBonus() {
		int alea = (int)(Math.random() * 100);
		if(alea <= 100 && alea > 90) {
			ajoutBonus(4);
		}
		else if(alea <= 90 && alea >= 75) {
			ajoutBonus(5);
		}
		else if(alea < 5) {
			ajoutBonus(6);
		}
	}

	private void ajoutBonus(int typeBonus) {
		boolean estAjoute = false;
		while(!estAjoute) {
			int randomHauteur = (int)(Math.random() * this.hauteur);
			int randomLargeur = (int)(Math.random() * this.largeur);
			if(typeBonus == 6) {
				randomHauteur = (int)(Math.random() *(this.hauteur-1 - 1))+1;
				randomLargeur = (int)(Math.random() *(this.largeur-1 - 1))+1;
			}
			//System.out.println(randomHauteur);
			//System.out.println(randomLargeur);
			
			if(this.matrice[randomHauteur][randomLargeur].getValeur() == 0) {
				if(typeBonus == 4) {
					this.matrice[randomHauteur][randomLargeur] = new Ralentisseur(randomHauteur,randomLargeur);
				}
				else if(typeBonus == 5) {
					this.matrice[randomHauteur][randomLargeur] = new Accelerateur(randomHauteur,randomLargeur);
				}
				else if(typeBonus == 6) {
					boolean fosseTrouve = false;
					while(!fosseTrouve) {
						if(this.matrice[randomHauteur+1][randomLargeur].getValeur()==0 && 
								this.matrice[randomHauteur][randomLargeur+1].getValeur()==0 &&
								this.matrice[randomHauteur-1][randomLargeur].getValeur()==0 &&
								this.matrice[randomHauteur][randomLargeur-1].getValeur()==0)
						this.matrice[randomHauteur][randomLargeur] = new Fosse(randomHauteur,randomLargeur);
						this.matrice[randomHauteur+1][randomLargeur] = new Fosse(randomHauteur+1,randomLargeur); 
						this.matrice[randomHauteur][randomLargeur+1] = new Fosse(randomHauteur,randomLargeur+1);
						this.matrice[randomHauteur-1][randomLargeur] = new Fosse(randomHauteur-1,randomLargeur);
						this.matrice[randomHauteur][randomLargeur-1] = new Fosse(randomHauteur,randomLargeur-1);
						fosseTrouve = true;
					}
				}
				estAjoute = true;
			} else {
				//System.out.println("Case " + randomHauteur + ":" + randomLargeur + " deja occupee");
			}
		}		
	}

	public void ajoutPommes(int indexNiveau) {
		while(indexNiveau!=this.nombrePommes) {
			int randomHauteur = (int)(Math.random() * this.hauteur);
			int randomLargeur = (int)(Math.random() * this.largeur);
			//System.out.println(randomHauteur);
			//System.out.println(randomLargeur);
			
			if(this.matrice[randomHauteur][randomLargeur].getValeur() == 0) {
				this.matrice[randomHauteur][randomLargeur] = new Pomme(randomHauteur,randomLargeur);
				this.nombrePommes++;
			} else {
				//System.out.println("Case " + randomHauteur + ":" + randomLargeur + " deja occupee");
			}
		}
		
	}
	
	public void ajoutBombes(int indexNiveau) {
		
		if(indexNiveau-1>0) {
			while(indexNiveau-1!=this.nombreBombes) {
				int randomHauteur = (int)(Math.random() * this.hauteur);
				int randomLargeur = (int)(Math.random() * this.largeur);
				
				if(this.matrice[randomHauteur][randomLargeur].getValeur() == 0) {
					this.matrice[randomHauteur][randomLargeur] = new Bombe(randomHauteur,randomLargeur);
					this.nombreBombes++;
				} else {
					//System.out.println("Case " + randomHauteur + ":" + randomLargeur + " deja occupee");
				}
			}
		} else {
			//System.out.println("Il n'y a pas de bombes a ce niveau");
		}
	}
	
	public void actualiserSerpent(Serpent serpent) {
		for(ElementSerpent s : serpent.getCorpsSerpent()) {
			this.matrice[s.getCoordHauteur()][s.getCoordLargeur()] = s;
		}
	}

	public int getHauteur() {
		return this.hauteur;
	}

	public int getLargeur() {
		return this.largeur;
	}

	public void setCase(Case nouvelleCase) {
		this.matrice[nouvelleCase.getCoordHauteur()][nouvelleCase.getCoordLargeur()] = new Sol(nouvelleCase.getCoordHauteur(),nouvelleCase.getCoordLargeur());
		
	}

	public int getNombrePommes() {
		return this.nombrePommes;
	}

	public void setNombrePommes(int nombrePomme) {
		this.nombrePommes = nombrePomme;
	}
}
