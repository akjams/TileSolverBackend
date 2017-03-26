package com.kemper.TileSolver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TileBFS implements GameSolver {
	
	private Set<GameState> visited;
	
	public TileBFS() {
		visited = new HashSet<GameState>();
	}

	@Override
	public Iterable<? extends GameState> solve(GameState gs) {
		
		//BFS on gs and set all of the parents correctly
		GameState solutionState = bfs(gs);
		
		//Stack up the path back to the original node
		Stack<GameState> solution = new Stack<GameState>();
		GameState current = solutionState;
		while (current != gs) {
			solution.push(current);
			current = current.getParent();
		}
		return solution;
	}
	
	private GameState bfs(GameState gs) {
		Queue<GameState> bfsQ = new LinkedList<>();
		bfsQ.add(gs);
		markVisited(gs);
		
		while (!bfsQ.isEmpty()) {
			GameState current = bfsQ.poll();
			if (current.isGoal()) {
				return current;
			}
			for (GameMove gameMove : current.getMoves()) {
				TileGameMove move = (TileGameMove) gameMove;
				TileGameState newState = (TileGameState) current.move(move);
				if (!(haveVisited(newState))) {
					markVisited(newState);
					newState.setParent(current);
					bfsQ.add(newState);
				}
			}
			
		}
		throw new AssertionError("BFS did not find goal state");
	}
	
	private void markVisited(GameState s) {
		visited.add(s);
	}
	
	private boolean haveVisited(GameState s) {
		return visited.contains(s);
	}

}
