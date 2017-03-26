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
	public List<? extends GameState> solve(GameState gs) {
		
		//BFS on gs and set all of the parents correctly
		GameState solutionState = bfs(gs);
		
		//Stack up the path back to the original node
		Stack<GameState> solution = new Stack<GameState>();
		GameState current = solutionState;
		solution.push(current);
		while (current != gs) {
			current = current.getParent();
			solution.push(current);
		}
		
		//put stack into LINKED LIST
		List<GameState> solutionList = new LinkedList<>();
		while (! solution.empty()) {
			solutionList.add(solution.pop());
		}
		return solutionList;
	}
	
	private GameState bfs(GameState gs) {
		Queue<GameState> bfsQ = new LinkedList<>();
		bfsQ.add(gs);
		markVisited(gs);
		
		while (!bfsQ.isEmpty()) {
			GameState current = bfsQ.poll();
			System.out.println(current.prettyString());
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
