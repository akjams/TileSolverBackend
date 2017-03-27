package com.kemper.TileSolver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class TileLamdaHandler implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String input, Context context) {
        context.getLogger().log("Input: " + input);
        if (input == null) {
        	input = "NONAME";
        }
        
        try {
        	TileGameState tgs = parseTGS(input);
        	TileBFS bfs = new TileBFS();
        	String output = bfs.solve(tgs).toString();
        	return output;
        } catch (IllegalArgumentException e) {
        	return "EXCEPTION PARSING INPUT: " + e.toString();
        }
    }
    
    // Expects a Game State of the form:
    //	1 2 3 4 5 6 7 8 0
    // and turns it into the board
    // 1, 2, 3
    // 4, 5, 6
    // 7, 8, 0
    private static TileGameState parseTGS(String input) {
    	Scanner in = new Scanner(input);
    	Queue<Integer> nums = new LinkedList<>();
    	while (in.hasNextInt()) {
    		nums.add(in.nextInt());
    	}
    	in.close();
    	if (!isPerfectSquare(nums.size())) {
    		throw new IllegalArgumentException("Number of params must be perfect square");
    	}
    	
    	int size = (int) Math.sqrt(nums.size());
    	int[][] board = new int[size][size];
    	for (int row = 0; row < size; row++) {
    		for (int col = 0; col < size; col++) {
    			board[row][col] = nums.poll();
    		}
    	}
    	return new TileGameState(board);
    }
    
    private static boolean isPerfectSquare(int x) {
    	int sqrt = (int) Math.sqrt(x);
    	return x == sqrt * sqrt;
    }

}
