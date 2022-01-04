# Minesweeper

## Détail des fonctionnalités :

### Page d’accueil :

La page d’accueil affiche la liste des parties non terminées.
Pour chaque partie, il sera affiché :
- La taille de la grille
- Le nombre de mine présentes

De plus, les actions suivantes sont possibles :
- Continuer la partie
- Supprimer la partie
  
### Création d’une partie

La création d’une partie permet de choisir la taille de la grille, ainsi que le nombre de mines présentes dans le champ.

Lors de la création de la partie, un champ à la taille correspondante est créé, et les mines sont
aléatoirement réparties sur le champ.

Une fois la partie créée, le joueur est redirigé vers la page permettant de jouer au « Minesweeper ».

### Déroulement de la partie

Initialement, la grille affichée est vide. Le joueur peut cliquer sur une case pour découvrir ce qu’il s’y trouve.

Il y a alors 3 cas (ici clic sur la case en haut à gauche) :
- Une mine était présente sur la case, la partie est terminée et le joueur à perdu. Le champ est alors affiché avec la position des mines présentes.
- Une mine ou plusieurs mines sont à proximité de cette case, le nombre est affiché.
- Il n’y a pas de mine à proximité, toutes les cases vides sont découvertes.

La partie est terminée quand le joueur à cliqué sur toute les cases ne contenant pas de mine.