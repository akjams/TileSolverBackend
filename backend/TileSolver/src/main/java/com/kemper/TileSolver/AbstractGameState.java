package com.kemper.TileSolver;

public abstract class AbstractGameState implements GameState {

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
