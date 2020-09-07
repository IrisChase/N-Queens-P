package com.enesda.nqueensp;

public interface ChessBoardCellRenderer
{
    public String mapToChar(PositionState state, boolean white);
    public String cellSpacing();
}
