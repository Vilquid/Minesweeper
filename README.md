# Minesweeper

https://en.wikipedia.org/wiki/Minesweeper_(video_game)

## Détails du projet

Le projet est développé avec SpringBoot (SpringData, Thymeleaf) et Bootstrap. Le Javascript n'est pas utilisé. De plus, il tente de respecter le design pattern MVC.

## Détails des fonctionnalités

### Page d’accueil

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

Une fois la partie créée, le joueur est redirigé vers la page permettant de jouer au "Minesweeper".

### Déroulement de la partie

Initialement, la grille affichée est vide. Le joueur peut cliquer sur une case pour découvrir ce qu’il s’y trouve.

Il y a alors 3 cas (ici clic sur la case en haut à gauche) :
- Une mine était présente sur la case, la partie est terminée et le joueur à perdu. Le champ est alors affiché avec la position des mines présentes.
- Une mine ou plusieurs mines sont à proximité de cette case, le nombre est affiché.
- Il n’y a pas de mine à proximité, toutes les cases vides sont découvertes.

La partie est terminée quand le joueur à cliqué sur toute les cases ne contenant pas de mine.

## Utiliser le projet

Pour run le projet, il faut créer une base de données PostgreSQL qui doit s'appeler "minesweeper" avec un utilisateur s'appelant "minesweeper" et ayant pour mot de passe "minesweeper".

Une fois la base de données créée, il faut la lancer avec pgAdmin et attendre d'avoir le message suivant : "Base de données connectée". Il est possible d'utiliser le fichier dbexport.sql.

Après cela, il faut ouvrir un navigateur internet (ex : Google Chrome) et rechercher http://localhost:8080.