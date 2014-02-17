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
		
		
	}
	
	/**
	 * Retrieves the gameboard array
	 * @return the array of tokens
	 */
	public Tokens[][] getBoard() {
	
		return new Tokens[3][5];
	}
}
