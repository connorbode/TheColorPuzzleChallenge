package search;

public class EmptySpaceCornerHeuristic extends Heuristic {

  public int evaluate(String input) {
    
    int value = 0;
    
    input = input.replaceAll(" ", "");
    
    for(int i = 0; i < 5; i++) {

      char topChar = input.charAt(i);
      char bottomChar = input.charAt(i+10);
      char midChar = input.charAt(i+5);

      // column symmetry?
      if(topChar == bottomChar)
        value += 2;

      // 1 move down = column symmetry ?
      if(topChar == 'e' && midChar == bottomChar) {
    	  value += 1;
      }
      
      // 1 move up = column symmetry?
      if(bottomChar == 'e' && midChar == topChar) {
    	  value += 1;
      }
      
      // 1 move left + 1 move up / down = 2 more columns symmetry?
      int twoMovesForTwoColsPoints = 3;
      if(i != 0) {
		  char midLeftChar = input.charAt(i+4);
		  char topLeftChar = input.charAt(i-1);
		  char bottomLeftChar = input.charAt(i+9);
    	  if(topChar == 'e' && bottomLeftChar == midLeftChar && topLeftChar == bottomChar) {
    		  value += twoMovesForTwoColsPoints;
    	  } else if (bottomChar == 'e' && topLeftChar == midLeftChar && bottomLeftChar == topChar) {
    		  value += twoMovesForTwoColsPoints;
    	  }
      }
      if(i != 4) {
    	  char topRightChar = input.charAt(i+1);
    	  char midRightChar = input.charAt(i+6);
    	  char bottomRightChar = input.charAt(i+11);
    	  if(topChar == 'e' && bottomRightChar == midRightChar && topRightChar == bottomChar) {
    		  value += twoMovesForTwoColsPoints;
    	  } else if (bottomChar == 'e' && topRightChar == midRightChar && bottomRightChar == topChar) {
    		  value += twoMovesForTwoColsPoints;
    	  }
      }
    }
    
    return value;
  }
}
