package com.kemper.TileSolver;

public interface GameSolver {
	public Iterable<GameMove> solve(GameState gs);
}
