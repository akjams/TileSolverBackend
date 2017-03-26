package com.kemper.TileSolver;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGameState implements GameState {
	
	
	private GameState parent;
	
	public List<? extends GameState> getNeighborStates() {
		List<GameState> neighborStates = new LinkedList<>();
		List<? extends GameMove> moves = getMoves();
		for (GameMove move : moves) {
			neighborStates.add(this.move(move));
		}
		return neighborStates;
	}


	public GameState getParent() {
		return parent;
	}


	public void setParent(GameState parent) {
		this.parent = parent;
	}

	public abstract int hash();
	
	public abstract boolean equals(GameState other);
	
	@Override
	public int hashCode() {
		return this.hash();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof GameState) {
			return this.equals((GameState) obj);
		}
		return false;
	}

}
