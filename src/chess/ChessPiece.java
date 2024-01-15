package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece { // SubClasse da - Class Piece

	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board); // O Color passa a chamada para o board da - Class Piece
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

}
