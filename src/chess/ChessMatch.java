package chess;

import boardgame.Board;

public class ChessMatch { // Nessa Class é o Coração do programa, ou seja, as regras!!!

	private Board board;

	public ChessMatch() { // É nessa Class que tem que informar qual é a dimensão do tabuleiro
		board = new Board(8, 8);
	}

	// ChessPiece a camada de xadrez onde o usuario vai poder ver
	public ChessPiece[][] getPieces() { // Retornar a matriz de peças do xadrez correspondente á partida atual
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()]; // Qtd de linha e coluna vai ser do tabuleiro
																				
		for (int i = 0; i < board.getRows(); i++) { // Percorrendo as Linhas do Tabuleiro
			for (int j = 0; j < board.getColumns(); j++) { // Percorrendo as Colunas do Tabuleiro
				mat[i][j] = (ChessPiece) board.piece(i, j); // DownCast pra ChessPiece, para interpletar uma peça de Xadrez
			}
		}
		return mat;
	}

}
