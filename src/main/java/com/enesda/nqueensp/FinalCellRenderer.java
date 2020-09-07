package com.enesda.nqueensp;

class FinalCellRenderer implements ChessBoardCellRenderer
{
    @Override
    public String mapToChar(PositionState state, boolean white)
    {
        if(state == PositionState.QUEEN)
        {
            if(white)
                return "♛";
            else
                return "♕";
        }
        else if(white)
            return "□";
        else
            return " ";
    }

    @Override
    public String cellSpacing()
    { return " "; }
}
