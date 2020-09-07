package com.enesda.nqueensp;

public class TestCellRenderer implements ChessBoardCellRenderer
{
    @Override
    public String mapToChar(PositionState state, boolean white)
    {
        switch(state)
        {
            case OPEN: return ".";
            case QUEEN: return "Q";
            case ATTACKABLE: return "A";
            case LINE_OF_THREE: return "T";
        }

        throw new RuntimeException();
    }

    @Override
    public String cellSpacing()
    {
        return " ";
    }
}
