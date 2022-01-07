package fr.yncrea.cin3.minesweeper.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "\"game\"")
public class Minefield
{
	@Id
	@GeneratedValue
	private UUID id;

	private long width;
	private long height;
	private long count; // nb de mines
	private int caseDecouvertes;

	@Enumerated(EnumType.STRING)
	private GameStatus status;

	//0 -> non decouverte; 1 -> decouverte; 2 -> Bombe non decouverte; 3 -> bombe decouverte
	@Lob
	private int[][] minefield;

	public Minefield() {}

	public Minefield(long width, long height)
		{
			this.width = width;
			this.height = height;
			this.count = 0;
		}
	public Minefield(long width, long height, long count)
	{
		this.width = width;
		this.height = height;
		this.status = GameStatus.STARTED;
		this.count = count;
		this.minefield = new int[(int) width][(int) height];
		buildMinefield();

	}

	private void buildMinefield()
	{
		for (int i = 0; i < width; i++)
		{
			for (int j = 0; j < height; j++)
			{
				minefield[i][j] = 0;
			}
		}

	}

	private boolean hasMine(int x, int y)
	{
		if (this.getMinefield()[(int) x][(int) y] == 2 || this.getMinefield()[(int) x][(int) y] == 3)
			return true;
		else
			return false;
	}
}
