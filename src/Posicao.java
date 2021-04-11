
public class Posicao {

	public int id = 0;
	public boolean isRevealed = false;
	public boolean isBomb = false;

	public int row = -1;
	public int col = -1;
	public int bombCount = 0;

	public Posicao() {
	}

	public Posicao(int id, boolean isRevealed, boolean isBomb) {
		this.id = id;
		this.isRevealed = isRevealed;
		this.isBomb = isBomb;
	}

	public int getRow(int nCols) {
		int row = 0;

		row = (int) (this.id / nCols);

		if (this.id % nCols == 0)
			row--;

		this.row = row;

		return row;
	}

	public int getCol(int nCols) {
		int col = 0;

		int row = getRow(nCols);

		col = (nCols - ((nCols * ((row) + 1)) - this.id)) - 1;

		this.col = col;

		return col;
	}
}
