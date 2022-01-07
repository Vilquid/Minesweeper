package fr.yncrea.cin3.minesweeper.service;

import fr.yncrea.cin3.minesweeper.exception.MinesweeperException;
import lombok.Getter;
import lombok.Setter;


import fr.yncrea.cin3.minesweeper.domain.GameStatus;
import fr.yncrea.cin3.minesweeper.domain.*;
import org.springframework.stereotype.Service;
import java.lang.Math;

import javax.validation.constraints.Min;
@Getter
@Setter
@Service
public class MinesweeperEngineService
{
	/**
	 * Create a new minefield
	 *
	 * @param width
	 * @param height hauteur
	 * @param count
	 * @return
	 */
	/*public Minefield create(long width, long height, long count)
	{
		return new Minefield(width, height);
	}

	/**
	 * Fonction utile à la fonction floofill()
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
	static void floodFillUtil(int minefield[][], int x, int y, int nb_colonne, int nb_ligne, int prevC, int newC)
	{
		if (minefield[x][y] == 2 || minefield[x][y] == 2)
		{
//			fin de partie
		}

		for (int i = -1; i < 2; i++)
		{
			for (int j = -1; j < 2; j++)
			{
				if (minefield[x][y] == 0)
				{
//					Découvrir la cellule

					x = i;
					y = j;

					floodFillUtil(minefield, x, y, nb_colonne, nb_ligne, prevC, newC);

					for (int k = -1; k < 2; k++)
					{
						for (int l = -1; l < 2; l++)
						{
							if (minefield[k][l] != 0 && minefield[k][l] != 9)
							{
			//					Découvrir la cellule
//								afficher son numéro (cb de mines à côté d'elle)
							}
						}
					}
				}
			}
		}
	}

	static void floodFill(int minefield[][], int x, int y, int nb_colonne, int nb_ligne, int newC)
	{
		int prevC = minefield[x][y];

		if(prevC==newC) return;

		floodFillUtil(minefield, x, y, nb_colonne, nb_ligne, prevC, newC);
	}

	/**
	 * Add a mine on the field
	 *
	 * @param minefield
	 * @param x - colonne
	 * @param y - ligne
	 * 9 = il y a une bombe
	 */
	public void addMine(Minefield minefield, long x, long y) {
		if (x < 0 || x > minefield.getWidth() - 1 || y < 0 || y > minefield.getHeight() - 1) {
			throw new MinesweeperException("Ajout d'une mine hors champ");
		}
		minefield.getMinefield()[(int) x][(int) y] = 2;
	}

	/**
	 * Returns the mine count near a cell
	 *
	 * @param minefield
	 * @param x colonne
	 * @param y ligne
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

	public boolean hasMine(int minefield, int colonne, int ligne)
	{
		if (minefield[colonne][ligne] == 3)
		{
			return true;
		}

		else
			return false;
	}

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
		Minefield m = new Minefield(width, height,count);

		for (int k = 0; k < count; k++){
			int width_tp = (int) (Math.random() * width);
			int height_tp = (int) (Math.random() * height);

			if(hasMine(m, width_tp, height_tp)){
				k--;
			}
			else{
				addMine(m,width_tp,height_tp);
			}

		}

		return m;
	}

	/**
	 * Discover a new cell, and update the game (win/loss detection, ...)
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 */
	public void play(Minefield minefield, int colonne, int ligne int x, int y)
	{
		if (minefield[x][y] == 1)
		{
			throw new MinesweeperException("Case déjà découverte");
		}

		else
		{
			if (hasMine(minefield, x, y))
			{
				minefield[x][y] = 2;
				// partie perdue
			}

			else
			{
				floodFill(minefield, x, y, nb_colonne, nb_ligne, newC);
			}
		}
	}

	private boolean hasMine(Minefield minefield, int x, int y)
	{
		if (minefield.getMinefield()[(int) x][(int) y] == 2 || minefield.getMinefield()[(int) x][(int) y] == 3)
		{
			return true;
		}

		else
		{
			return false;
		}
	}

	/**
	 * Returns the mine count near a cell
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 * @return 0
	 */
	public long getMineCountNear(Minefield minefield, long x, long y)
	{
		return 0;
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
//		if (minefield.getMinefield()[(int) x][(int) y] == 1 || minefield.getMinefield()[(int) x][(int) y] == 3)
//		{
//			return true;
//		}
//
//		else
//		{
//			return false;
//		}
	}
}
