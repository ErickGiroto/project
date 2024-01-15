package boardgame;

public class Board { // Tabuleiro

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1) {
			throw new BoardException("Erro ao criar o quadro: Tem de haver pelo menos 1 linha e 1 coluna");
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	
	// Posição da Linha e Coluna
	public Piece piece(int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Posição que não está no quadro");			
		}
		return pieces[row][column];
	}

	
	// Retornando a peça pela Posição
	public Piece piece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição que não está no quadro");			
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	
	// Atribuir a posicao a peça que veio como argumento
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPice(position)) {
			throw new BoardException("Já existe uma peça na posição " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		
		//Dizer que a peça não está na posição nula e informar que está na posição - 'posistion'
		piece.position = position; // O Acesso ao piece só é possivel porque está no mesmo pacote boardgame
	}
	
	
	// Criando as defensivas do Game
	public boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPice(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Posição que não está no quadro");			
		}
		return piece(position) != null;
	}
	
	
	
	
	

}
