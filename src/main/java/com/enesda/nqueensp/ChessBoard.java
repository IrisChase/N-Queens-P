package com.enesda.nqueensp;

import java.util.Arrays;
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
        grid = Arrays.copyOf(copyFrom.grid, copyFrom.grid.length);
        placedQueens = new Vector<Point>(copyFrom.placedQueens);
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

    // It looks weird having one diagonal drawing function for each quadrant,
    // but it's easier to test that way. Initially I had trouble with lines
    // "wrapping around" and it was hard to tell what was going on in the higher level tests.
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
        Point jumpVector = Point.getMinimumWholeVectorWithSameAngle(
                Point.getVectorBetweenPoints(pos1, pos2));

        //Consider pos1 the origin
        for(Point jumpPos = new Point(pos1); checkPointInBounds(jumpPos); jumpPos.add(jumpVector))
            markIfOpen(jumpPos, markWith);

        //Invert, then go again
        jumpVector.invertVector();

        for(Point jumpPos = new Point(pos1); checkPointInBounds(jumpPos); jumpPos.add(jumpVector))
            markIfOpen(jumpPos, markWith);
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

    private static ChessBoard solveRecursively(ChessBoard cbIn, int row) throws NQueensUnsolvableForNException
    {
        if(row == cbIn.n_for_queens) return cbIn;

        for(Point pos = new Point(0, row); pos.x != cbIn.n_for_queens; ++pos.x)
        {
            ChessBoard attempt = new ChessBoard(cbIn);

            //Just a loop over a subrange so this doesn't make it n^n
            //Not just using an if/continue statement because I don't wanna reallocate
            // the attempt each iteration of the outer for loop.
            while(!attempt.placeQueen(pos))
            {
                ++pos.x;
                if(pos.x == attempt.n_for_queens) return null;
            }

            //Queen has to be placed by this point, now recurse
            attempt = solveRecursively(attempt, row + 1);

            if(attempt != null && attempt.checkSolved()) return attempt;
        }

        if(row == 0) throw new NQueensUnsolvableForNException(cbIn.n_for_queens);

        //Doesn't really matter what is returned, it just needs to check that
        // it isn't solved.
        return null;
    }

    public static ChessBoard getSolvedBoardForN(int n) throws NQueensUnsolvableForNException
    {
        ChessBoard cb = new ChessBoard(n);
        cb = ChessBoard.solveRecursively(cb, 0);

        assert(cb != null); //Should throw before it passes null up this far but...

        return cb;
    }

    public String renderToString(ChessBoardCellRenderer r)
    {
        String rslt = new String();

        boolean white = false;
        for(int row = 0; row != n_for_queens; ++row)
        {
            boolean startedOnWhite = white;
            for(int col = 0; col != n_for_queens; ++col)
            {
                int offset = new Point(col, row).getFlatOffset(n_for_queens);
                rslt += r.mapToChar(grid[offset], white);

                if(col + 1 != n_for_queens)
                    rslt += r.cellSpacing();

                //Alternate by column
                white = !white;
            }

            //Alternate by row
            white = !startedOnWhite;

            rslt += '\n';
        }

        return rslt;
    }
}

