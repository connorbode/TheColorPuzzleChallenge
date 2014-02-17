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

}
