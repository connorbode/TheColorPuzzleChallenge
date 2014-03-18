package runners;

import puzzle.*;
import java.util.Scanner;

public class Terminal {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type gameboard config:");
		String input = keyboard.nextLine();
		
		Game game = new Game(input);
		
		System.out.println("Game initialized");
		System.out.println();
		System.out.println("Use the following keys to move the EMPTY token:");
		System.out.println("- 'w' for UP");
		System.out.println("- 'a' for LEFT");
		System.out.println("- 's' for DOWN");
		System.out.println("- 'd' for RIGHT");
		System.out.println();
		System.out.println("Type 'q' to quit");
		System.out.println();
		
		// Loop infinitely
		while(true) {
			
			// Print gameboard
			game.displayState();
			
			System.out.println(game.getHistory());
			System.out.println(game.getMoveHistory());
			
			// Get input
			input = keyboard.nextLine();
			
			System.out.println();
			
			try {
				// Process input
				switch(input) {
				
				case "w":
					game.move(Direction.UP);
					break;
				case "a":
					game.move(Direction.LEFT);
					break;
				case "s":
					game.move(Direction.DOWN);
					break;
				case "d":
					game.move(Direction.RIGHT);
					break;
				case "q":
					System.exit(0);
					break;
				default:
					System.out.println("Input not understood.");
				}
			}
			
			// Catch invalid input
			catch(InvalidMoveException e) {
				System.out.println("Invalid move! " + e);
			}
			
			// Print a blank line
			System.out.println();
		}
	}
}
