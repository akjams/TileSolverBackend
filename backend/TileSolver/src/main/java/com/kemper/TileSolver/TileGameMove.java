package com.kemper.TileSolver;

/** Immutable implementation of GameMove for Tile Game
 * @author austinkemper
 *
 */
public class TileGameMove implements GameMove {
	private TileLocation start;
	private TileLocation end;
	
	public TileGameMove(TileLocation start, TileLocation end) {
		this.start = start;
		this.end = end;
	}

	public TileLocation getStart() {
		return start;
	}

	public TileLocation getEnd() {
		return end;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TileGameMove) {
			TileGameMove that = (TileGameMove) obj;
			return this.start.equals(that.start) && this.end.equals(that.end);
		}
		return false;
	}
}
