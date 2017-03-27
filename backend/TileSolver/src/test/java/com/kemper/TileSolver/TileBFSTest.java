package com.kemper.TileSolver;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TileBFSTest {
	
	static int[][] goalBoard = { 
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 0}
	};
	
	
	private GameState game0;
	private List<GameState> solutionList0;
	
	private GameState game1;
	private List<GameState> solutionList1;
	
//	@Before
//	public void setupSolu0() {
//		int[][] board1 = { 
//				{1, 2, 3},
//				{4, 5, 0},
//				{7, 8, 6}
//		};
//	}

	@Before
	public void setupSolu1() {
		int[][] board1 = { 
				{1, 2, 0},
				{4, 5, 3},
				{7, 8, 6}
		};
		int[][] board2 = { 
				{1, 2, 3},
				{4, 5, 0},
				{7, 8, 6}
		};
		
		game1 = new TileGameState(board1);
		TileGameState tgs2 = new TileGameState(board2);
		TileGameState tgs3 = new TileGameState(goalBoard);
		
		solutionList1 = new LinkedList<>();
		solutionList1.add(game1);
		solutionList1.add(tgs2);
		solutionList1.add(tgs3);
	}
	
	@Test
	public void testSolu1() {
		TileBFS bfs = new TileBFS();
		List<? extends GameState> bfsSolu = bfs.solve(game1);
		assertEquals(solutionList1, bfsSolu);
	}

}
