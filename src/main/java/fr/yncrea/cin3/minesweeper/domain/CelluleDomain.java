package fr.yncrea.cin3.minesweeper.domain;

public class CelluleDomain
{
	private boolean revelee;
	private int minesAutour;

	public boolean estRevelee() {
		return revelee;
	}

	public void setRevele(boolean revelee) {
		this.revelee = revelee;
	}

	public int getMinesAutour() {
		return minesAutour;
	}

	public void setMinesAutour(int minesAutour) {
		this.minesAutour = minesAutour;
	}

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean mine) {
		this.mine = mine;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	private boolean mine;
	private boolean flag;

	public boolean Cellule(boolean mine)
	{
		return this.mine = mine;
	}
}
