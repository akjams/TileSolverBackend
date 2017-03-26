package com.kemper.TileSolver;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TileGameStateTest {
	
	private TileGameState goal;

	@Before
	public void setup() {
		int[][] goalBoard = { 
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 0}
		};
		goal = new TileGameState(3, goalBoard);
	}
	
	
	@Test
	public void testGetMoves() {
		
		TileGameState game1 = goal;
		TileGameMove move1_1 = new TileGameMove(new TileLocation(2, 2), new TileLocation(2, 1));
		TileGameMove move1_2 = new TileGameMove(new TileLocation(2, 2), new TileLocation(1, 2));
		List<GameMove> moves = goal.getMoves();
		assertTrue(moves.contains(move1_1));
		assertTrue(moves.contains(move1_2));
		assertTrue(moves.size() == 2);
	}

	@Test
	public void testMove() {
		
	}

	@Test
	public void testIsGoal() {
		
	}

	@Test
	public void testHash() {
		
	}

	
}
