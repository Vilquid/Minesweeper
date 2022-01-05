package fr.yncrea.cin3.minesweeper.service;

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
	public Minefield create(long width, long height, long count)
	{
		return new Minefield(width, height);
	}

	/**
	 * Create a new minefield
	 *
	 * @param minefield
	 * @param
	 * @param width
	 * @param heightcount
	 * @param
	 * @param
	 * @return Que dalle !
	 */
//	static void floodFillUtil(Minefield minefield, int x, int y, int colonne, int ligne, int prevC, int newC)
//	{
//		if (x < 0 || x >= colonne || y < 0 || y >= ligne)
//			return;
//		if (minefield[x][y] != prevC)
//			return;
//
//		// Replace the color at (x, y)
//		minefield[x][y] = newC;
//
//		// Recur for north, east, south and west
//		floodFillUtil(screen, x+1, y, prevC, newC);
//		floodFillUtil(screen, x-1, y, prevC, newC);
//		floodFillUtil(screen, x, y+1, prevC, newC);
//		floodFillUtil(screen, x, y-1, prevC, newC);
//	}
//
//	static void floodFill(int screen[][], int x, int y, int newC)
//	{
//		int prevC = screen[x][y];
//		if(prevC==newC) return;
//		floodFillUtil(screen, x, y, prevC, newC);
//	}
	/**
	 * Discover a new cell, and update the game (win/loss detection, ...)
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 */
	public void play(Minefield minefield, long x, long y)
	{

	}

	/**
	 * Add a mine on the field
	 *
	 * @param minefield
	 * @param x - colonne
	 * @param y - ligne
	 * 10 = il y a une bombe
	 */
	public void addMine(Minefield minefield, long x, long y)
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
	public long getMineCountNear(Minefield minefield, long x, long y)
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
	public boolean hasMine(Minefield minefield, long colonne, long ligne)
	{
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
