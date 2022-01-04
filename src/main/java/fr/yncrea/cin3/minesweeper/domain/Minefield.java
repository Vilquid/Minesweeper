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
public class Minefield
{
	@Id
	@GeneratedValue
	private UUID id;

	private long width;
	private long height;
	private long count;

	public Minefield() {}

	public Minefield(long width, long height)
	{
		this.width = width;
		this.height = height;
	}
}
