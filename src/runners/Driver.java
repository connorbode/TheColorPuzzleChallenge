package runners;

import java.io.IOException;

import puzzle.*;

/**
 * Loads input from a text file & processes using the puzzle runner
 *
 */
public class Driver {

	public static void main(String[] args) {
		
		try {
			FileOperations.runner("files/sample-input1.txt");
		} catch (IndexOutOfBoundsException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
