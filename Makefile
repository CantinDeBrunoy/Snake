JFLAGS = -d build -cp build -sourcepath src
JC = javac
JVM = java

.SUFFIXES: .java .class

.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	src/Jeu/LogiqueJeu.java \
	src/Jeu/LancerPartie.java \
	src/Controllers/InputJoueur.java \
	src/Models/Bombe.java \
	src/Models/Carte.java \
	src/Models/Case.java \
	src/Models/Accelerateur.java \
	src/Models/Ralentisseur.java \
	src/Models/Fosse.java \
	src/Models/ElementSerpent.java \
	src/Models/Pomme.java \
	src/Models/Serpent.java \
	src/Models/Sol.java \
	src/Views/Frame.java \
	src/Views/PanelCarte.java \
	src/Views/PanelScore.java 

MAIN = LogiqueJeu

default: classes

classes: $(CLASSES:.java=.class)

run : 
	$(JVM) -cp build Jeu/LogiqueJeu

clean:
	rm -r build