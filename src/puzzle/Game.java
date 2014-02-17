package puzzle;
public class Game {
	
	/* ==================================================
	 * VARIABLES
	 * ================================================== */
	
	// the gameboard
	private Tokens[][] board = new Tokens[3][5];
	
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
		
		// remove whitespace from input
		input = input.replace(" ",  "");
		
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
	public void displayState() {
		
		// Notify that we are printing the game state
		System.out.println("CURRENT GAME STATE: ");
		System.out.println("--------------------");
		
		// Iterate columns
		for(int i = 0; i < board.length; i++) {
			
			// The line to print for the gameboard
			String line = "";
			
			// Iterate rows
			for(int j = 0; j < board[i].length; j++) {
				
				// Get the current token representation
				String token = board[i][j].toString().substring(0, 1);
				
				// Add the current representation to the line
				line += token + " ";
			}
			
			// Print the token
			System.out.println(line);
		}
		
		// Print a blank line
		System.out.println();
	}
	
	/**
	 * Retrieves the gameboard array
	 * @return the array of tokens
	 */
	public Tokens[][] getState() {
	
		return new Tokens[3][5];
	}
}
