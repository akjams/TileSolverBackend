package com.kemper.TileSolver;

import java.util.List;

public interface GameSolver {
	public List<? extends GameState> solve(GameState gs);
}
