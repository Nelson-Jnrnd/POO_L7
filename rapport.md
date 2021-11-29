# Rapport labo 7 - Tours de Hanoï
## Alen BIJELIC - Nelson JEANRENAUD

# Introduction
L'objectif de ce laboratoire est de mettre en place le jeu des tours de Hanoï en mode graphique à l'aide des classes fournies et en mode console.

Ainsi, en spécifiant un paramètres numérique lors de l'exécution du programme, celui-ci va afficher la solution des tours de Hanoï en mode console. Si aucun paramètre n'est passé, c'est le mode graphique qui sera lancé.

# Choix d'implémentation
## Structure de donnée

### Stack
L'implémentation d'une Stack était requise par la donnée du laboratoire. Et pour la mètre en place,
nous avons décidé d'utiliser une structure du type liste simplement chainée.

### Element
Étant donnée l'implémentation de la liste simplement chainée. Les éléments pointent sur un autre élément qui est l'élément suivant dans la liste.

### Examinator

## Hanoi
La classe Hanoi, ...

### Algorithme
Pour résoudre le jeu des tours de Hanoi, une solution récursive a été mise en place comme vu dans le cours ASD.

Le cas trivial consiste à n'avoir aucun disque à transférer.
Le cas général consiste à déplacer n disques de l'épingle A (from) à l'épingle C (to) en passant par l'épingle intérmédiaire B (via).
L'algorithme complet se décompose en trois étape:
1. Déplacer n-1 disques de l'épingle A à l'épingle B
2. Déplacer le nième disque sur l'épingle C
3. Déplacer les n-1 disques de l'épingle B à l'épingle C.

Les deux règles des Tours de Hanoi consiste à ne transférer qu'un disque à la fois et on ne peut pas poser un disque sur un disque plus petit que lui.
Pour cela, l'étape 1 se décompose en 3 étapes permettant de déplacer n-1 disques de gauche au milieu :
1. Déplacer n-2 disques de gauche à droite 
2. Déplacer le (n-1)ième disque de gauche au milieu
3. Déplacer n-2 disques de droite au milieu

L'étape 2 de l'algorithme consiste simplement à déplacer le dernier disque sur l'épingle intermédiaire.
L'étape 3 est une étape récursive et ressemble à l'étape 1, mis à part qu'on déplace les disques de l'aiguille C à la B

## HanoiDisplayer

## TestHanoi

# Question
En supposant des moines surentraînés capables de déplacer un disque à la seconde, combien de temps
reste-t-il avant que l’univers disparaisse (celui-ci a actuellement 13.8 milliards d’années) ?

>L'algorithme récursive des Tours de Hanoï a une complexité de O(2^n), plus précisément 2^n-1 déplacement de disques avec n = le nombre de disques.
On peut donc facilement calculer le nombre de déplacemenet total : 2^64-1 = 18'446'744'073'709'551'615 de secondes pour terminer les Tours de Hanoï à 64 disques. Cela donne 584'942'417'355,1 d'années ou 584,9 milliards d'année. On est à plus de 42 fois le temps restant avant que l'univers disparaisse.

# Diagramme UML