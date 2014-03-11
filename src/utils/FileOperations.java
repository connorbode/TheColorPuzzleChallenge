package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

import search.*;

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
	
	/**
	 * Writes a line of text to a given file
	 * @param filePath the path to the file
	 * @param text the text to write to the file
	 * @throws IOException error on accessing the file
	 */
	public static void writeLineToFile(String filePath, String text) throws IOException {
		
		// Create the writer
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)));
		
		// Write a line to the file
		out.println(text);
		out.close();
	}

}
