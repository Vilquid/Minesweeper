package fr.yncrea.cin3.minesweeper.service;

import fr.yncrea.cin3.minesweeper.exception.MinesweeperException;
import lombok.Getter;
import lombok.Setter;


import fr.yncrea.cin3.minesweeper.domain.GameStatus;
import fr.yncrea.cin3.minesweeper.domain.*;
import org.springframework.stereotype.Service;
import java.lang.Math;


@Getter
@Setter
@Service
public class MinesweeperEngineService
{

	public void addMine(Minefield minefield, long x, long y) {
		if (x < 0 || x > minefield.getWidth() - 1 || y < 0 || y > minefield.getHeight() - 1) {
			throw new MinesweeperException("Ajout d'une mine hors champ");
		}
		minefield.getMinefield()[(int) x][(int) y] = 2;
	}



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
	 * @param row
	 * @param col
	 */
	// Discover a new cell, and update the game (win/loss detection, ...)
	public void play(Minefield minefield, long row, long col) {

			if (isDiscovered(minefield, row, col)) {
				throw new MinesweeperException("Case deja découverte !");
			}
			else {
				if (hasMine(minefield, row, col)) {
					minefield.setStatus(GameStatus.LOST);
					showMinefield(minefield);
				} else {
					//if (getMineCountNear(minefield, row, col) == 0)
						//discoverNearCell(minefield, row, col); //fonction a faire

					//else
						//minefield.setCases(minefield.getCases() + 1);

					minefield.getMinefield()[(int) row][(int) col] = 1;
				}
			}
			//isWin(minefield);

	}

	// Révèle tout le champ de mines
	public void showMinefield(Minefield minefield) {
		for (int i = 0; i < minefield.getWidth(); i++) {
			for (int j = 0; j < minefield.getHeight(); j++) {
				if (minefield.getMinefield()[i][j] == 2) {
					minefield.getMinefield()[i][j] = 3;
				}
			}
		}
	}




	public boolean hasMine(Minefield minefield, long x, long y)
	{
		if (minefield.getMinefield()[(int) x][(int) y] == 2 || minefield.getMinefield()[(int) x][(int) y] == 3)
			return true;
		else
			return false;
	}

	/**
	 * Returns the mine count near a cell
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 * @return
	 */
	public long getMineCountNear(Minefield minefield, long x, long y) {

		int nbCount = 0;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (x+i >= 0 && x+i < minefield.getWidth() && y+j >= 0 && y+j < minefield.getHeight()) {
					if (minefield.hasMine((int) (x + i), (int) (y + j))) {
						nbCount++;
					}
				}
			}
		}

		return nbCount;
	}



	/**
	 * Returns true is the cell is already discovered
	 *
	 * @param minefield
	 * @param x
	 * @param y
	 * @return bool
	 */
	public boolean isDiscovered(Minefield minefield, long x, long y) {
		if (minefield.getMinefield()[(int) x][(int) y] == 1 || minefield.getMinefield()[(int) x][(int) y] == 3)
			return true;
		else
			return false;
	}
}
