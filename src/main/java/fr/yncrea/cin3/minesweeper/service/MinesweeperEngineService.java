package fr.yncrea.cin3.minesweeper.service;

import fr.yncrea.cin3.minesweeper.domain.GameStatus;
import fr.yncrea.cin3.minesweeper.domain.Minefield;
import org.springframework.stereotype.Service;

@Service
public class MinesweeperEngineService
{
	/**
	 * Create a new minefield
	 *
	 * @param width
	 * @param height
	 * @param count
	 * @return
	 */
	/*public Minefield create(long width, long height, long count)
	{
		return new Minefield(width, height);
	}

	/**
	 * Create a new minefield
	 *
	 * @param minefield
	 * @param x Colonne actuellle
	 * @param y Ligne actuelle
	 * @param nb_colonne Nombre de colonnes au total
	 * @param nb_ligne Nombre de lignes au total
	 * @param prevC
	 * @param newC
	 * @return Que dalle !
	 */
	/*static void floodFillUtil(Minefield minefield, int x, int y, int nb_colonne, int nb_ligne, int prevC, int newC)
	{
		/**
		 * 							Algo à ma façon :
		 * Récupérer les coordonnées x et y de la case sur laquelle on clique
		 * si c'est une bombe :
		 * 		la partie est terminée
		 *
		 * 	for(i=-1; i<2; i++)
		 * 	{
		 * 		for(j=-1; j<2; j++)
		 * 		{
		 * 			si minefield[x][y] == 0 :
		 * 		  		Découvrir la cellule
		 * 		  		x=i
		 * 		  		y=j
		 * 		  		(récursivité) lancer une nouvelle fois la fonction avec les nouveaux x et y
		 *
		 * 		  		for(k=-1; k<2; k++)
		 * 		 		{
		 * 		  			for(l=-1; l<2; l++)
		 * 		  			{
		 * 		  				si minefield[k][l] != 0 && minefield[k][l] n'est pas une bombe :
		 * 		  		  			Découvrir la cellule
		 * 		  		 			afficher le numéro de bombe qu'elle a à coté d'elle
		 * 		  			}
		 * 		  		}
		 * 		 }
		 * 	}
		 */
		/**if (x < 0 || x >= nb_colonne || y < 0 || y >= nb_ligne)
			return;
		if (minefield[x][y] != prevC)
			return;

		// Replace the color at (x, y)
		minefield[x][y] = newC;

		// Recur for north, east, south and west
		floodFillUtil(minefield, x+1, y, nb_colonne, nb_ligne, prevC, newC);
		floodFillUtil(minefield, x-1, y, nb_colonne, nb_ligne, prevC, newC);
		floodFillUtil(minefield, x, y+1, nb_colonne, nb_ligne, prevC, newC);
		floodFillUtil(minefield, x, y-1, nb_colonne, nb_ligne, prevC, newC);*/
	/*}

	/*static void floodFill(Minefield minefield, int x, int y, int nb_colonne, int nb_ligne, int newC)
	{
		int prevC = minefield[x][y];
		if(prevC==newC) return;
		floodFillUtil(minefield, x, y, nb_colonne, nb_ligne, prevC, newC);
	}
	/**
	 * Discover a new cell, and update the game (win/loss detection, ...)
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 */
	/*public void play(Minefield minefield, long x, long y)
	{

	}

	/**
	 * Add a mine on the field
	 *
	 * @param minefield
	 * @param x - colonne
	 * @param y - ligne
	 * 9 = il y a une bombe
	 */
	/*public void addMine(Minefield minefield, long x, long y)
	{
//		Mise en commentaire de la ligne suivante car le type de minefield n'est pas encore déterminé
//		minefield[x][y] = 9;
	}

	/**
	 * Returns the mine count near a cell
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 * @return
	 */
	/*public long getMineCountNear(Minefield minefield, long x, long y)
	{
		return 0;
	}

	/**
	 * Returns true is the cell contains a mine
	 *
	 * @param minefield
	 * @param colonne
	 * @param ligne
	 * @return bool
	 */
	/*public boolean hasMine(Minefield minefield, long colonne, long ligne)
	{/**
		if (minefield == null)
		{
			return false;
		}

//		Mise en commentaire du if car le type de minefield n'est pas encore déterminé
//		if (minefield[colonne][ligne] == "9")
//		{
//			return true;
//		}

		else
			return false;
	}*/

	/**
	 * Returns true is the cell is already discovered
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 * @return bool
	 */
	/*public boolean isDiscovered(Minefield minefield, long x, long y)
	{
		/**if (minefield != null)
		{
			if (minefield[x][y].estRevelee == true)
			{
				return true;
			}

			else
			{
				return false;
			}
		}

		return false;
	}*/
	/**
	 * Create a new minefield
	 *
	 * @param width
	 * @param height
	 * @param count
	 * @return
	 */
	public Minefield create(long width, long height, long count, GameStatus status)
	{
		return new Minefield(width, height, status,count);
	}

	/**
	 * Discover a new cell, and update the game (win/loss detection, ...)
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 */
	public void play(Minefield minefield, long x, long y)
	{}

	/**
	 * Add a mine on the field
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 */
	public void addMine(Minefield minefield, long x, long y)
	{}

	/**
	 * Returns the mine count near a cell
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 * @return
	 */
	public long getMineCountNear(Minefield minefield, long x, long y)
	{
		return 0;
	}

	/**
	 * Returns true is the cell contains a mine
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean hasMine(Minefield minefield, long x, long y) {
		return false;
	}

	/**
	 * Returns true is the cell is already discovered
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isDiscovered(Minefield minefield, long x, long y)
	{
		return false;
	}
}
