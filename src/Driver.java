import java.io.IOException;

import puzzle.*;

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
