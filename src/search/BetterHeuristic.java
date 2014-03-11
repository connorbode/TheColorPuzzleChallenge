package search;

public class BetterHeuristic extends Heuristic {

	public int evaluate(String input) {
		
		int value = 0;
		
		input = input.replaceAll(" ", "");
		
		for(int i = 0; i < 5; i++) {
			if(input.charAt(i) == input.charAt(i+10))
				value++;
		}
		
		return value;
	}
}
