package search;

public class EmptySpaceHeuristic extends Heuristic {

  public int evaluate(String input) {
    
    int value = 0;
    
    input = input.replaceAll(" ", "");
    
    for(int i = 0; i < 5; i++) {

      char topChar = input.charAt(i);
      char bottomChar = input.charAt(i+10);

      if(topChar == bottomChar)
        value += 2;

      if(topChar == 'e' || bottomChar == 'e')
    	  value += 1;
    }
    
    return value;
  }
}
