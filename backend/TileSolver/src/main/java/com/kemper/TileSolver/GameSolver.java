package com.kemper.TileSolver;

import java.util.List;

public interface GameSolver {
	public Iterable<? extends GameState> solve(GameState gs);
}
