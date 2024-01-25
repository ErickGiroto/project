package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
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

	// Definindo a jogada de inicio e de fim
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturedPiece = makeMove(source, target); // Responsavel por mover a peça
		return (ChessPiece) capturedPiece;
	}

	private Piece makeMove(Position source, Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.piece(target);
		board.placePiece(p, target);
		return capturedPiece;
	}

	private void validateSourcePosition(Position position) {
		if (!board.thereIsAPice(position)) {
			throw new ChessException("Não existe peça na posicao de origem");
		}

		if (!board.piece(position).IsThereAnyPossibleMove()) {
			throw new ChessException("Não existe movimento para a peça escolhida");

		}
	}

	// Passando as coordenada no tabuleiro do xadrez
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}

	// Responsável por inicial o jogo de xadrez e colocar as peças no tabuleiro

	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
		placeNewPiece('c', 2, new Rook(board, Color.WHITE));
		placeNewPiece('d', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 2, new Rook(board, Color.WHITE));
		placeNewPiece('e', 1, new Rook(board, Color.WHITE));
		placeNewPiece('d', 1, new King(board, Color.WHITE));

		placeNewPiece('c', 7, new Rook(board, Color.BLACK));
		placeNewPiece('c', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 7, new Rook(board, Color.BLACK));
		placeNewPiece('e', 8, new Rook(board, Color.BLACK));
		placeNewPiece('d', 8, new King(board, Color.BLACK));

	}

}
