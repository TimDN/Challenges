
public class Board {
	private int width;
	private int height;
	private Square[][] board;
	
	public Board(int width,int height,Colour defaultColour){
		this.width = width;
		this.height = height;
		
		board = new Square[this.width][this.height];
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height;j++){
				board[i][j] = new Square(defaultColour);
			}
		}
	}
	public Square getSquare(int posX,int posY){
		Square square = board[posX][posY];
		return square;
	}
}
