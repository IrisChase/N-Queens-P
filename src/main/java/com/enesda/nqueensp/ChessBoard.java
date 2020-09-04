package com.enesda.nqueensp;

import java.util.Arrays;

public class ChessBoard
{
    //Do not think of this as a class, but merely a composite of primitives
    private static class Pair
    {
        public int x;
        public int y;
    }

    private enum PositionState
    {
        OPEN,
        QUEEN,
        ATTACKABLE,
        LINE_OF_THREE,
    }

    private final PositionState grid[];

    private void addQueen()
    {
    }

    private String mapStateToSymbol(PositionState state)
    {
        switch(state)
        {
            case OPEN: return " ";
            case QUEEN: return "Q";
            case ATTACKABLE: return "X";
            case LINE_OF_THREE: return "T";
        }
        throw new RuntimeException("Inconceivable!");
    }

//Public interface
    public ChessBoard(int n)
    {
        grid = new PositionState[n*n];
        Arrays.fill(grid, PositionState.OPEN);
    }

    public String getPrettyPrintedString()
    {
        return "fuck";
    }
}

