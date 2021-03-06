package runners;

import java.io.IOException;
import java.util.ArrayList;

import puzzle.*;
import search.*;
import utils.FileOperations;

/**
 * Loads input from a text file & processes using the puzzle runner
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		try {
			ArrayList gameConfigs = FileOperations.load("files/sample-puzzles/level2/problem.txt");
			
			ASearch search = new ASearch(new EmptySpaceCornerHeuristic());
			String ans = null;
			long totalTime = 0;
			String filePath = "level2.txt";
			int totalMoves = 0;
			for(int i = 0; i < gameConfigs.size(); i++)
			{
				System.out.println("PUZZLE " + (i+1));
				System.out.println();
				Game puzzle = new Game((String)gameConfigs.get(i));
				System.out.println("INITIAL STATE: ");
				puzzle.displayState();
				long startTime = System.currentTimeMillis();
				Game solution = search.evaluate(puzzle.getState());
				System.out.println("FINAL STATE: ");
				solution.displayState();
				long endTime = System.currentTimeMillis();
				long timeElapsed =  (endTime - startTime);
				totalTime += timeElapsed;
				ans = solution.getHistory();
				System.out.println("SOLUTION HISTORY: " + ans);
				System.out.println("SOLUTION MOVE HISTORY: " + solution.getMoveHistory());
				System.out.println("SOLUTION TIME: " + timeElapsed + "ms");
				System.out.println("TOTAL TIME SO FAR: " + totalTime + "ms");
				System.out.println();
				
				FileOperations.writeLineToFile(filePath, solution.getHistory());
				FileOperations.writeLineToFile(filePath, timeElapsed + "ms");
				totalMoves += solution.getHistory().length();
			}
			FileOperations.writeLineToFile(filePath,  totalMoves + "");
			FileOperations.writeLineToFile(filePath, totalTime + "ms");
			System.out.println("TOTAL TIME: " + totalTime + "ms");
			
		} catch (IndexOutOfBoundsException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
