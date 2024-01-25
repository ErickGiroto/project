package boardgame;

public abstract class Piece { // Peça do tabuleiro interna
	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}
	
	
	// Torre possiveis movimentações
	public abstract boolean[][] possibleMoves();
	
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()]; // Gancho com a subclasse
	}
	
	public boolean IsThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for (int i=0; i<mat.length; i++) {
			for(int j=0; j<mat.length; i++) {
				if(mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}
