package chess.pieces; // Peças do Xadrez

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece { // Class TORRE

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "T"; // Letra que ira aparecer na tabela T que significa TORRE
	}

}
