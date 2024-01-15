package boardgame;

public class Board { // Tabuleiro

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	// Posição da Linha e Coluna
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}

	// Retornando a peça pela Posição
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	// Atribuir a posicao a peça que veio como argumento
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		
		//Dizer que a peça não está na posição nula e informar que está na posição - 'posistion'
		piece.position = position; // O Acesso ao piece só é possivel porque está no mesmo pacote boardgame
	}

}
