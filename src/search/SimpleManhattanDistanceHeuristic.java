package search;

public class SimpleManhattanDistanceHeuristic extends Heuristic {

	public int evaluate(String input) {
		
		input = input.replaceAll(" ", "");
		int value = 0;
		
		// iterate rows
		for (int i = 0; i < 5; i++) {
			
			boolean countUp = (i == 0 ? true : false);
			
			char top = input.charAt(i);
			
			int manHatVal = i + 2;
			int bestVal = 10;
			
			for (int j = 0; j < 14; j++) {
				
				char curr = input.charAt(j);
				
				if (j != i && curr == top) {
					bestVal = (manHatVal < bestVal ? manHatVal : bestVal);
				}
				
				if (j == i || j-5 == i || j-10 == i) {
					countUp = true;
				}
				
				// if we're going to the next row
				if ((j+1) % 5 == 0) {
					manHatVal -= (5-(2*i));
					countUp = false;
				} else {
					if (countUp)
						manHatVal += 1;
					else
						manHatVal -= 1;
				}
			}
			
			value += bestVal;
		}
		
		return -value;
	}
}
