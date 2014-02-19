package test;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzle.*;

public class Tests {

	@Test
	public void getStateTest() {
	
		String initialState = "e r r r r r b w b b w y b r y";
		Game game = new Game(initialState);
		assertEquals("get state works", game.getState(), initialState);
	}
	
	@Test(expected=InvalidMoveException.class)
	public void invalidMoveUpTest() throws InvalidMoveException {

		String initialState = "e r r r r r b w b b w y b r y";
		Game game = new Game(initialState);
		game.move(Direction.UP);
	}
	
	@Test(expected=InvalidMoveException.class)
	public void invalidMoveLeftTest() throws InvalidMoveException {

		String initialState = "e r r r r r b w b b w y b r y";
		Game game = new Game(initialState);
		game.move(Direction.LEFT);
	}
	
	@Test(expected=InvalidMoveException.class)
	public void invalidMoveRightTest() throws InvalidMoveException {

		String initialState = "r r r r r r b w b b w y b r e";
		Game game = new Game(initialState);
		game.move(Direction.RIGHT);
	}
	
	@Test(expected=InvalidMoveException.class)
	public void invalidMoveDownTest() throws InvalidMoveException {

		String initialState = "r r r r r r b w b b w y b r e";
		Game game = new Game(initialState);
		game.move(Direction.DOWN);
	}
	
	@Test
	public void successfulMoveUpTest() throws InvalidMoveException {

		String initialState = "r r r r r r e w b b w y b r y";
		String expectedState = "r e r r r r r w b b w y b r y";
		Game game = new Game(initialState);
		game.move(Direction.UP);
		assertEquals(game.getState(), expectedState);
	}
	
	@Test
	public void successfulMoveDownTest() throws InvalidMoveException {

		String initialState = "r r r r r r e w b b w y b r y";
		String expectedState = "r r r r r r y w b b w e b r y";
		Game game = new Game(initialState);
		game.move(Direction.DOWN);
		assertEquals(expectedState, game.getState());
	}
	
	@Test
	public void successfulMoveLeftTest() throws InvalidMoveException {

		String initialState = "r e b b b r b b b b r b b b b";
		String expectedState = "e r b b b r b b b b r b b b b";
		Game game = new Game(initialState);
		game.move(Direction.LEFT);
		assertEquals(expectedState, game.getState());
	}
	
	@Test
	public void successfulMoveRightTest() throws InvalidMoveException {

		String initialState = "r e b b b r b b b b r b b b b";
		String expectedState = "r b e b b r b b b b r b b b b";
		Game game = new Game(initialState);
		game.move(Direction.RIGHT);
		assertEquals(expectedState, game.getState());
	}
	
	@Test
	public void equalsTest() {

		String initialState = "r e b b b r b b b b r b b b b";
		Game game = new Game(initialState);
		Game game2 = game.clone();
		
		assertTrue(game.equals(game2));
	}
	
	@Test
	public void cloneTest() {
		
		String initialState = "r e b b b r b b b b r b b b b";
		Game game = new Game(initialState);
		Game game2 = game.clone();
		assertTrue(game.equals(game2));
	}
	
	@Test
	public void getPositionTest() {
		String initialState = "r e b b b r b b b b r b b b b";
		Game game = new Game(initialState);
		assertEquals("B", game.getPosition());
		
		initialState = "e b b b b r b b b b r b b b b";
		game = new Game(initialState);
		assertEquals("A", game.getPosition());
		
		initialState = "r r b b b r b b b b r b b b e";
		game = new Game(initialState);
		assertEquals("O", game.getPosition());
	}
	
	@Test
	public void goalStateTest() {
		String initialState = "r w y r b r b r b e r w y r b";
		Game game = new Game(initialState);
		assertTrue(game.goalStateReached());
	}	
	
	@Test
	public void nonGoalStateTest() {
		String initialState = "r r b b b r b b b b r b b b e";
		Game game = new Game(initialState);
		assertFalse(game.goalStateReached());
	}


}
