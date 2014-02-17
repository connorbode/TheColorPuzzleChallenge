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
	public Tokens[][] getBoard() {
	
		return new Tokens[3][5];
	}
}
