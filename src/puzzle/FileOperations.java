package puzzle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class FileOperations {

	//Opens the specified file from filePath, read each line and store them in an ArrayList
	public static ArrayList load(String filePath) throws IOException
	{
		String line;
		ArrayList gameConfigs = new ArrayList();
		BufferedReader textReader = new BufferedReader(new FileReader(filePath));
		
		while((line = textReader.readLine()) != null)
		{
			gameConfigs.add(line);
		}
		
		textReader.close();
		return gameConfigs;
	}
	
	public static void runner(String filePath) throws IndexOutOfBoundsException, IOException
	{
		ArrayList gameConfigs = load(filePath);
		
		for(int i = 0; i < gameConfigs.size()-1; i++)
		{
			Game puzzle = new Game((String)gameConfigs.get(i));
			puzzle.displayState();
		}
	}

}
