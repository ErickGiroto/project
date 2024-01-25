package chess.pieces; // Peças do Xadrez

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece { // Class REI

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R"; // Letra que ira aparecer na tabela R que significa REI
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		return mat;
	}

}
