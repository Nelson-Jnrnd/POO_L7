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
TODO: décrire l'algorithme utilisé

## HanoiDisplayer

## TestHanoi

# Question
En supposant des moines surentraînés capables de déplacer un disque à la seconde, combien de temps
reste-t-il avant que l’univers disparaisse (celui-ci a actuellement 13.8 milliards d’années) ?

>L'algorithme récursive des Tours de Hanoï a une complexité de O(2^n), plus précisément 2^(n-1) déplacement de disques avec n = le nombre de disques.
On peut donc facilement calculer le nombre de déplacemenet total : 2^(64-1) = 2^63 = 9'223'372'036'854'775'808 de secondes pour terminer les Tours de Hanoï à 64 disques. Cela donne 292'471'208'677,54 d'années ou 292,5 milliards d'année. On est à plus de 21 fois le temps restant avant que l'univers disparaisse.

# Diagramme UML