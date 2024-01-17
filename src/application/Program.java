package application;

import java.util.Scanner;

import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();

		while (true) {// Repetindo
			UI.printBoard(chessMatch.getPieces()); // Metodo vai receber a matriz de peças da partida
			
			
			System.out.println();
			System.out.println("Origem:  "); // Peça de origem
			ChessPosition source = UI.readChessPosition(sc);
			
			
			System.out.println();
			System.out.println("Destino: "); // Peça com destino
			ChessPosition target = UI.readChessPosition(sc);
			
			ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			

		}

	}

}
