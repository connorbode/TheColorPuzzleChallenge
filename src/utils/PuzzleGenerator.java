package utils;

import java.io.IOException;

public class PuzzleGenerator {

	public static void main(String[] args) {
		
		String filePath = "files/level3.txt";
		String characters = "rrrrbbbbwwyygge";
		int num = 30;
		
		try {
			for(int i = 0; i < num; i++) {
				FileOperations.writeLineToFile(filePath, generate(characters));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static String generate(String input) {
		
		String output = "";
		
		while( ! input.equals("")) {
			
			int index = (int) Math.floor(Math.random() * input.length());
			output += input.substring(index, index+1);
			input = input.substring(0, index) + input.substring(index+1);
		}
		
		return output.replace("", " ").trim();
	}
}
