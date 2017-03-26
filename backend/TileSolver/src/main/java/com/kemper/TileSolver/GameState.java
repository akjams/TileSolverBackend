package com.kemper.TileSolver;

import java.util.List;

/** A Representation of a game at a particular state. 
 * @author austinkemper
 *
 */
public interface GameState {
	
	/** Ths will be used by bfs, as opposed to the below two methods.
	 * It is perhaps simpler to expose just this part of the API
	 * @return
	 */
	public List<? extends GameState> getNeighborStates();
	
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

	/** Get parent method for BFS/DFS
	 * @return the parent of the node
	 */
	public GameState getParent();
	
	/** Set parent method for BFS/DFS
	 * @param parent the parent node
	 */
	public void setParent(GameState parent);
	
}
