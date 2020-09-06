package com.enesda.nqueensp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class ChessBoard
{
    private final int n_for_queens;
    private Vector<Point> placedQueens;
    private final PositionState grid[];

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~public interface:

    public ChessBoard(int n)
    {
        n_for_queens = n;
        grid = new PositionState[n*n];
        placedQueens = new Vector<Point>();
        Arrays.fill(grid, PositionState.OPEN);
    }

    public ChessBoard(ChessBoard copyFrom)
    {
        n_for_queens = copyFrom.n_for_queens;
        grid = copyFrom.getCopyOfGrid();
        placedQueens = new Vector<Point>(copyFrom.placedQueens);
    }

    public PositionState[] getCopyOfGrid()
    {
        PositionState[] rslt = new PositionState[grid.length];
        rslt = Arrays.copyOf(grid, grid.length);
        return rslt;
    }

    public boolean checkSolved()
    {
        return placedQueens.size() == n_for_queens;
    }

    public boolean checkPointInBounds(Point p)
    {
        if(p.x >= n_for_queens || p.y >= n_for_queens) return false;
        if(p.x < 0 || p.y < 0) return false;

        int offset = p.getFlatOffset(n_for_queens);
        return offset >= 0 && offset < grid.length;
    }

    public void markIfOpen(Point p, PositionState markWith)
    {
        if(grid[p.getFlatOffset(n_for_queens)] != PositionState.OPEN) return;
        grid[p.getFlatOffset(n_for_queens)] = markWith;
    }

    public void markHorizontals(Point pos, PositionState markWith)
    {
        Point p = new Point(pos);

        //Horizontals are along the y, so zero out x
        for(p.x = 0; p.x != n_for_queens; ++p.x)
            markIfOpen(p, markWith);
    }

    public void markVerticals(Point pos, PositionState markWith)
    {
        Point p = new Point(pos);

        //Verticals are along the x, so zero out y
        for(p.y = 0; p.y != n_for_queens; ++p.y)
            markIfOpen(p, markWith);
    }

    public void markDiagonal1stQuadrant(Point pos, PositionState markWith)
    {
        Point p = new Point(pos);
        while(checkPointInBounds(p))
        {
            markIfOpen(p, markWith);
            ++p.x;
            --p.y;
        }
    }

    public void markDiagonal2ndQuadrant(Point pos, PositionState markWith)
    {
        Point p = new Point(pos);
        while(checkPointInBounds(p))
        {
            markIfOpen(p, markWith);
            --p.x;
            --p.y;
        }
    }

    public void markDiagonal3rdQuadrant(Point pos, PositionState markWith)
    {
        Point p = new Point(pos);
        while(checkPointInBounds(p))
        {
            markIfOpen(p, markWith);
            --p.x;
            ++p.y;
        }
    }

    public void markDiagonal4thQuadrant(Point pos, PositionState markWith)
    {
        Point p = new Point(pos);
        while(checkPointInBounds(p))
        {
            markIfOpen(p, markWith);
            ++p.x;
            ++p.y;
        }
    }

    public void markLineOfThreeCompleting(Point pos1,
                                          Point pos2,
                                          PositionState markWith)
    {

    }

    public boolean placeQueen(Point p)
    {
        int flatOffset = p.getFlatOffset(n_for_queens);

        if(grid[flatOffset] != PositionState.OPEN) return false;

        grid[flatOffset] = PositionState.QUEEN;

        for(Point otherP : placedQueens)
        {
            markLineOfThreeCompleting(
                    p,
                    otherP,
                    PositionState.LINE_OF_THREE);
        }

        markHorizontals(p, PositionState.ATTACKABLE);
        markVerticals(p, PositionState.ATTACKABLE);

        markDiagonal1stQuadrant(p, PositionState.ATTACKABLE);
        markDiagonal2ndQuadrant(p, PositionState.ATTACKABLE);
        markDiagonal3rdQuadrant(p, PositionState.ATTACKABLE);
        markDiagonal4thQuadrant(p, PositionState.ATTACKABLE);

        placedQueens.add(p);

        return true;
    }

    public void addQueens()
    {
        for(int y = 0; y != n_for_queens; ++y)
            for(int x = 0; x != n_for_queens; ++x)
                placeQueen(new Point(x, y));
    }

    public static ChessBoard compute(ChessBoard cb, int x, int y, int depth)
    {
        while(true)
        {
            ChessBoard b = new ChessBoard(cb);
            b.placeQueen(new Point(x, y));
            //compute
            //if complete, return, if at end, return...


            ++x; ++y;

            break;
        }

        int nextDepth = depth + 1;
        if(nextDepth != cb.n_for_queens)
        {
            //recurse
        }
        return cb;
    }

    public static ChessBoard solve(ChessBoard passed, int row) throws NQueensUnsolvableForNException
    {
        if(row == passed.n_for_queens) return passed;

        Point pos = new Point(0, row);

        for(; pos.x != passed.n_for_queens; ++pos.x)
        {
            ChessBoard attempt = new ChessBoard(passed);

            while(!attempt.placeQueen(pos))
            {
                ++pos.x;

                //Could not even this row, need one on each row
                if(pos.x == attempt.n_for_queens) return passed;
            }

            //Queen was placed, now recurse
            attempt = solve(attempt, row + 1);

            if(attempt.checkSolved()) return attempt;
        }

        if(row == 0)
            throw new NQueensUnsolvableForNException(passed.n_for_queens);

        return passed;
    }

    public String mapStateToSymbol(PositionState state)
    {
        switch(state)
        {
            case OPEN: return ".";
            case QUEEN: return "Q";
            case ATTACKABLE: return "A";
            case LINE_OF_THREE: return "T";
        }
        throw new RuntimeException("Inconceivable!");
    }

    public String getASCIIgrid()
    {
        String rslt = new String();

        //Draw numbers under the chessboard
        int numberOnSide = n_for_queens;

        for(int y = 0; y != n_for_queens; ++y)
        {
            //rslt += numberOnSide;
            //System.out.print(numberOnSide);
            --numberOnSide;

            for(int x = 0; x != n_for_queens; ++x)
            {
                Point p = new Point(x, y);
                rslt += (mapStateToSymbol(grid[p.getFlatOffset(n_for_queens)]));
                
                if(x + 1 != n_for_queens)
                    rslt += " ";
            }

            rslt += '\n';
        }

        return rslt;
    }

    public String getPrettyPrintedString()
    {
        return getASCIIgrid();
    }
}

