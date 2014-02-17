public class Game {
	
	/* ==================================================
	 * VARIABLES
	 * ================================================== */
	
	// the gameboard
	private Tokens[][] board;
	
	// the coordinates of the empty token
	private int emptyRow;
	private int emptyCol;
	
	
	/* ==================================================
	 * METHODS
	 * ================================================== */

	/**
	 * Create a new game given the string of input.  
	 * Sets emptyRow & emptyCol when finds 'e'
	 * @param input 
	 */
	public Game(String input) {
		
		char[] char_array = input.toCharArray();
		for(int i = 0; i < char_array.length; i++)
		{
			int row = i/5;
			int col = i%5;
			
			Tokens token = null;
			switch (char_array[i])
			{
			case 'e':
				token = Tokens.EMPTY;
				emptyRow = row;
				emptyCol = col;
				break;
				
			case 'r':
				token = Tokens.RED;
				break;
				
			case 'b':
				token = Tokens.BLUE;
				break;
				
			case 'w':
				token = Tokens.WHITE;
				break;
				
			case 'y':
				token = Tokens.YELLOW;
				break;
				
			case 'g':
				token = Tokens.GREEN;
				break;
				
			case 'p':
				token = Tokens.PINK;
				break;
			}
			
			board[row][col] = token;
		}
	}
	
	/**
	 * Moves the empty token in the direction specified
	 * @param direction the direction to move the token
	 * @return true if the token was successfully moved
	 */
	public boolean move(Direction direction) {
		
		return true;
	}

	/**
	 * Displays the gameboard in the console
	 */
	public void displayBoard() {
		
		
	}
	
	/**
	 * Retrieves the gameboard array
	 * @return the array of tokens
	 */
	public Tokens[][] getBoard() {
	
		return new Tokens[3][5];
	}
}
