package com.kemper.TileSolver;

import java.util.List;
import java.util.LinkedList;

public class TileGameState extends AbstractGameState {
	
	private final int SIZE;
	private int[][] board;
	
	public TileGameState(int size, int[][] board) {
		validateBoard(size, board);
		this.SIZE = size;
		this.board = board;
	}
	
	//private clone method
	private TileGameState(TileGameState other) {
		this.SIZE = other.board.length;
		this.board = new int[SIZE][SIZE];
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = other.board[i][j];
			}
		}
	}
	
	private void validateBoard(int size, int[][] board) {
		if (! (board.length == size && board[0].length == size)) {
			throw new IllegalArgumentException("size must equal board length");
		}
		//TODO check board has #'s 0-size
	}
	
	private TileLocation findTile(int data) {
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if(board[row][col] == 0) {
					return new TileLocation(row, col);
				}
			}
		}
		throw new IllegalArgumentException("Board does not contain data: " + data);
	}
	
	private void swapIndices(int[][] ar, int r1, int c1, int r2, int c2) {
		int temp = ar[r1][c1];
		ar[r1][c1] = ar[r2][c2];
		ar[r2][c2] = temp;
	}

	public List<GameMove> getMoves() {
		TileLocation blank = findTile(0);
		List<GameMove> moves = new LinkedList<GameMove>();
		TileLocation start = new TileLocation(blank);
		
		//add left
		if (blank.getRow() != 0) {
			TileLocation end = new TileLocation(blank.getRow() - 1, blank.getCol());
			moves.add(new TileGameMove(start, end));
		}
		//add right
		if (blank.getRow() != SIZE - 1) {
			TileLocation end = new TileLocation(blank.getRow() + 1, blank.getCol());
			moves.add(new TileGameMove(start, end));
		}
		//add up
		if (blank.getRow() != 0) {
			TileLocation end = new TileLocation(blank.getRow(), blank.getCol() - 1);
			moves.add(new TileGameMove(start, end));
		}
		//add down
		if (blank.getRow() != SIZE - 1) {
			TileLocation end = new TileLocation(blank.getRow(), blank.getCol() + 1);
			moves.add(new TileGameMove(start, end));
		}
		return moves;
	}

	public GameState move(GameMove gm) {
		//cast, we must receive a TileGameMove
		TileGameMove move = (TileGameMove) gm;
		TileGameState newState = new TileGameState(this);
		swapIndices(newState.board, move.getStart().getRow(), move.getStart().getCol(), 
				move.getEnd().getRow(), move.getEnd().getCol());
		return newState;
	}
	
	//The tile goal state for a board of size 3 looks like this:
	// 1, 2, 3
	// 4, 5, 6
	// 7, 8, 0
	public boolean isGoal() {
		if (board[SIZE - 1][SIZE - 1] != 0) {
			return false;
		}
		for (int i = 1; i < SIZE * SIZE; i++) {
			int col = (i - 1) % SIZE;
			int row = (i - 1) / SIZE;
			if (board[row][col] != i) {
				return false;
			}
		}
		return true;
	}

	//TODO we could use a better hash function, especially for larger boards
	@Override
	public int hash() {
		int hash = 0;
		int shift = 32 / (SIZE * SIZE - 1);
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				hash <<= shift;
				hash += board[i][j];
			}
		}
		return hash;
	}

	@Override
	public boolean equals(GameState other) {
		TileGameState tgs = (TileGameState) other;
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (board[i][j] != tgs.board[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
