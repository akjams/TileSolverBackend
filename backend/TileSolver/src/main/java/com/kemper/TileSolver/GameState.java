package com.kemper.TileSolver;

import java.util.List;

/** A Representation of a game at a particular state. 
 * @author austinkemper
 *
 */
public interface GameState {
	
	/** Get possible moves.
	 * @return a list of all Game Moves that can be made from this state
	 */
	public List<? extends GameMove> getMoves();
	
	/** Get the GameState after making move gm. Does not change the state of this GameState.
	 * @return the new GameState
	 */
	public GameState move(GameMove gm);
	
	/** Is this the goal state?
	 * @return true if this state is the goal state
	 */
	public boolean isGoal();
	
}
