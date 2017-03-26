package com.kemper.TileSolver;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TileGameStateTest {
	
	private TileGameState goal;
	private TileGameState game1;
	
	//States reachable from 1
	private TileGameState game1_1;
	private TileGameState game1_2;
	private TileGameState game1_3;
	private TileGameState game1_4;
	
	private TileGameState[] games = {goal, game1_1, game1_2, game1_3, game1_4};
	
	private TileGameMove move1_1;
	private TileGameMove move1_2;
	private TileGameMove move1_3;
	private TileGameMove move1_4;
	
	

	@Before
	public void setup() {
		int[][] goalBoard = { 
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 0}
		};
		goal = new TileGameState(goalBoard);
		
		int[][] board1 = { 
				{1, 2, 3},
				{4, 0, 6},
				{7, 8, 9}
		};
		game1 = new TileGameState(board1);
		
		int[][] board1_1 = { 
				{1, 0, 3},
				{4, 2, 6},
				{7, 8, 9}
		};
		game1_1 = new TileGameState(board1_1);
		
		int[][] board1_2 = { 
				{1, 2, 3},
				{0, 4, 6},
				{7, 8, 9}
		};
		game1_2 = new TileGameState(board1_2);

		int[][] board1_3 = { 
				{1, 2, 3},
				{4, 6, 0},
				{7, 8, 9}
		};
		game1_3 = new TileGameState(board1_3);
		
		int[][] board1_4 = { 
				{1, 2, 3},
				{4, 8, 6},
				{7, 0, 9}
		};
		game1_4 = new TileGameState(board1_4);
		
		move1_1 = new TileGameMove(new TileLocation(1, 1), new TileLocation(0, 1));
		move1_2 = new TileGameMove(new TileLocation(1, 1), new TileLocation(1, 0));
		move1_3 = new TileGameMove(new TileLocation(1, 1), new TileLocation(1, 2));
		move1_4 = new TileGameMove(new TileLocation(1, 1), new TileLocation(2, 1));
		
	}
	
	
	@Test
	public void testGetMovesGoal() {		
		TileGameMove goalMove1 = new TileGameMove(new TileLocation(2, 2), new TileLocation(2, 1));
		TileGameMove goalMove2 = new TileGameMove(new TileLocation(2, 2), new TileLocation(1, 2));
		List<GameMove> moves = goal.getMoves();
		assertTrue(moves.contains(goalMove1));
		assertTrue(moves.contains(goalMove2));
		assertTrue(moves.size() == 2);
	}
	
	@Test
	public void testGetMovesCenter() {
		List<GameMove> moves = game1.getMoves();
		assertTrue(moves.contains(move1_1));
		assertTrue(moves.contains(move1_2));
		assertTrue(moves.contains(move1_3));
		assertTrue(moves.contains(move1_4));
		assertTrue(moves.size() == 4);
	}

	@Test
	public void testMoveCenter() {
		assertTrue(game1.move(move1_1).equals(game1_1));
		assertTrue(game1.move(move1_2).equals(game1_2));
		assertTrue(game1.move(move1_3).equals(game1_3));
		assertTrue(game1.move(move1_4).equals(game1_4));
	}

	@Test
	public void testIsGoal() {
		
		assertTrue(goal.isGoal());
		
		assertFalse(game1.isGoal());
		assertFalse(game1_1.isGoal());
		assertFalse(game1_2.isGoal());
		assertFalse(game1_3.isGoal());
		assertFalse(game1_4.isGoal());
	}

	@Test
	public void testHash() {
		Set<GameState> set = new HashSet<GameState>();
		for (TileGameState tgs : games) {
			set.add(tgs);
			assertTrue(set.contains(tgs));
		}
		for (TileGameState tgs : games) {
			set.add(tgs);
			assertTrue(set.contains(tgs));
		}
		for (TileGameState tgs : games) {
			set.remove(tgs);
			assertFalse(set.contains(tgs));
		}
	}

	
}
