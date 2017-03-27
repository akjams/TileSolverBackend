package com.kemper.TileSolver;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class TileLamdaHandler implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String input, Context context) {
        context.getLogger().log("Input: " + input);
        if (input == null) {
        	input = "NONAME";
        }
        String output = "Hi from Tile Handler: " + input;
        return output;
    }

}
