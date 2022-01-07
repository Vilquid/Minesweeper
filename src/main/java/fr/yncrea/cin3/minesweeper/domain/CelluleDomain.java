package fr.yncrea.cin3.minesweeper.domain;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CelluleDomain
{
	private boolean revelee;
	private int minesAutour;
	private boolean mine;
	private boolean flag;
}
