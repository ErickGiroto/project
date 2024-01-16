package chess;

import boardgame.Board;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch { // Nessa Class é o Coração do programa, ou seja, as regras!!!

	private Board board;

	public ChessMatch() { // É nessa Class que tem que informar qual é a dimensão do tabuleiro
		board = new Board(8, 8);
		initialSetup();
	}

	// ChessPiece a camada de xadrez onde o usuario vai poder ver
	public ChessPiece[][] getPieces() { // Retornar a matriz de peças do xadrez correspondente á partida atual
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; // Qtd de linha e coluna vai ser do
																					// tabuleiro

		for (int i = 0; i < board.getRows(); i++) { // Percorrendo as Linhas do Tabuleiro
			for (int j = 0; j < board.getColumns(); j++) { // Percorrendo as Colunas do Tabuleiro
				mat[i][j] = (ChessPiece) board.piece(i, j); // DownCast pra ChessPiece, para interpletar uma peça de
															// Xadrez
			}
		}
		return mat;
	}

	// Passando as coordenada no tabuleiro do xadrez
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	// Responsável por inicial o jogo de xadrez e colocar as peças no tabuleiro

	private void initialSetup() {
		placeNewPiece('b', 6, new Rook(board, Color.WHITE));
		placeNewPiece('e', 8, new King(board, Color.BLACK));
		placeNewPiece('e', 1, new King(board, Color.WHITE));

	}

}
