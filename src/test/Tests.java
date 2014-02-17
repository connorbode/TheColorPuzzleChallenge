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

}
