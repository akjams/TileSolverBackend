package com.kemper.TileSolver;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class LambdaHandlerTest {


	@Test
	public void testParse() {
		int[][] goalBoard = { 
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 0}
		};
		TileGameState goalState = new TileGameState(goalBoard);
		
		String goalString = "1 2 3 4 5 6 7 8 0";
		assertEquals(goalState, TileLamdaHandler.parseTGS(goalString));
	}
	
	@Test
	public void testPerfectSquare() {
		Set<Integer> perfectSquaresBelow50 = new HashSet<>();
		perfectSquaresBelow50.add(1);
		perfectSquaresBelow50.add(4);
		perfectSquaresBelow50.add(9);
		perfectSquaresBelow50.add(16);
		perfectSquaresBelow50.add(25);
		perfectSquaresBelow50.add(36);
		perfectSquaresBelow50.add(49);
		
		for (int i = 1; i < 50; i++) {
			if (perfectSquaresBelow50.contains(i)) {
				assertTrue(TileLamdaHandler.isPerfectSquare(i));
			} else {
				assertFalse(TileLamdaHandler.isPerfectSquare(i));
			}
				
		}
	}

}
