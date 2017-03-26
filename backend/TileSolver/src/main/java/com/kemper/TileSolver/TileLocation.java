package com.kemper.TileSolver;

/** Immutable representation of a tile for Tile Game
 * @author austinkemper
 *
 */
public class TileLocation {
	private final int row;
	private final int col;
	
	public TileLocation(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public TileLocation(TileLocation orig) {
		this.row = orig.row;
		this.col = orig.col;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof TileLocation) {
			TileLocation that = (TileLocation) obj;
			return this.row == that.row && this.col == that.col;
		}
		return false;
	}
}
