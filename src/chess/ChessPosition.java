package chess;

import boardgame.Position;

//Especificando as posição A1, B3
public class ChessPosition {
	private char column;
	private int row;

	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1 || row > 8) {
			throw new ChessException("Erro, somente é valido posições entre A1 á H8");
		}

		this.column = column;
		this.row = row;

	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	// Especificando as linhas e colunas no máximo
	protected Position toPosition() {
		return new Position(8 - row, column - 'a');
	}

	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
	}

	// "" macete para fazer o compilador conseguir ler as Strings
	@Override
	public String toString() {
		return "" + column + row;
	}

}
