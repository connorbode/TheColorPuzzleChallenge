package search;

import puzzle.*;

import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

public class ASearch {
	
	// Initial size of priority queue
	private static final int PRIORITY_QUEUE_INIT_SIZE = 100;
	
	// The heuristic function to be used
	Heuristic heuristic;
	
	// The comparator for the nodes
	Comparator<Node> comparator = new NodeComparator();
	
	/**
	 * 
	 * @param initialConfig
	 */
	public ASearch(Heuristic h) {
		
		// Assign the heuristic
		this.heuristic = h;
	}
	
	public Game evaluate(String initialConfig) {

		// Root node
		Node root;
		
		// A search lists
		PriorityQueue<Node> open;
		ArrayList<String> closed = new ArrayList<String>();
		
		// assign root node
		root = new Node();
		root.game = new Game(initialConfig);
		
		// initialize open & closed lists
		open = new PriorityQueue<Node>(PRIORITY_QUEUE_INIT_SIZE, comparator);
		
		// add the root to the queue
		open.add(root);
		
		// empty the open queue
		while( ! open.isEmpty()) {
		
			// get the game from the open queue
			Game game = open.remove().game;
			
			// iterate over moves
			for(Direction dir : Direction.values()) {
				
				try {
					// make the new game and make the move
					Game newGame = game.clone();
					newGame.move(dir);
					String gameState = newGame.getState();
					
					// see if game is in a final state
					if(newGame.goalStateReached()) {
						
						return newGame;
					}
					
					// see if we've reached this node before
					if( ! closed.contains(newGame.getState())) {
					
						// retrieve the heuristic value & add it to the priority queue
						int gValue = costToNode(newGame.getHistory());
						int hValue = heuristic.evaluate(gameState);
						int fValue = hValue + gValue;
						Node newNode = new Node();
						newNode.game = newGame;
						newNode.fValue = fValue;
						open.add(newNode);
					}
					
				} catch(InvalidMoveException e) {
					
					// Do nothing
				}
			}
			
			// add the game to the closed list
			closed.add(game.getState());
		}
		
		return null;
	}

	public static class Node {
		private Game game;
		private int fValue;
	}
	
	public class NodeComparator implements Comparator {
		@Override
		public int compare(Object o1, Object o2) {
			Node n1 = (Node) o1;
			Node n2 = (Node) o2;	
			if(n1.fValue > n2.fValue)
				return -1;
			if(n1.fValue < n2.fValue)
				return 1;
			return 0;
		}
	}
	
	/**
	 * Evaluates the cost to get to the current node
	 * @param history the game history for the game state at this node
	 * @return the cost to get to that state
	 */
	private int costToNode(String history) {
		return 1;
	}
}
