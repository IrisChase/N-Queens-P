package com.enesda.nqueensp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.text.Position;

public class ChessBoardTest
{
    /*
    String iiii = "\n" +
                          ". . . . . . . .\n" +
                          ". . . . . . . .\n" +
                          ". . . . . . . .\n" +
                          ". . . . . . . .\n" +
                          ". . . . . . . .\n" +
                          ". . . . . . . .\n" +
                          ". . . . . . . .\n" +
                          ". . . . . . . .\n";
     */

    @Test
    void testHorizontals8x8at0x0()
    {
        ChessBoard b = new ChessBoard(8);

        b.markHorizontals(new Point(0, 0), PositionState.QUEEN);

        String q0x0 = "\n" +
                              "Q Q Q Q Q Q Q Q\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n";


        assertEquals(q0x0, "\n" + b.getASCIIgrid());
    }

    @Test
    void testHorizontals8x8at3x6()
    {
        ChessBoard b = new ChessBoard(8);

        b.markHorizontals(new Point(3, 6), PositionState.QUEEN);

        String q3x6 = "\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              "Q Q Q Q Q Q Q Q\n" +
                              ". . . . . . . .\n";


        assertEquals(q3x6, "\n" + b.getASCIIgrid());
    }

    @Test
    void testVerticals8x8at0x0()
    {
        ChessBoard b = new ChessBoard(8);

        b.markVerticals(new Point(0, 0), PositionState.QUEEN);

        String q0x0 = "\n" +
                              "Q . . . . . . .\n" +
                              "Q . . . . . . .\n" +
                              "Q . . . . . . .\n" +
                              "Q . . . . . . .\n" +
                              "Q . . . . . . .\n" +
                              "Q . . . . . . .\n" +
                              "Q . . . . . . .\n" +
                              "Q . . . . . . .\n";


        assertEquals(q0x0, "\n" + b.getASCIIgrid());
    }

    @Test
    void testVerticals8x8at3x6()
    {
        ChessBoard b = new ChessBoard(8);

        b.markVerticals(new Point(3, 6), PositionState.QUEEN);

        String q3x6 = "\n" +
                              ". . . Q . . . .\n" +
                              ". . . Q . . . .\n" +
                              ". . . Q . . . .\n" +
                              ". . . Q . . . .\n" +
                              ". . . Q . . . .\n" +
                              ". . . Q . . . .\n" +
                              ". . . Q . . . .\n" +
                              ". . . Q . . . .\n";


        assertEquals(q3x6, "\n" + b.getASCIIgrid());
    }

    @Test
    void testDiagonal1stQuadrant8x8at0x0()
    {
        ChessBoard b = new ChessBoard(8);

        b.markDiagonal1stQuadrant(new Point(0, 0), PositionState.QUEEN);

        String q0x0 = "\n" +
                              "Q . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n";


        assertEquals(q0x0, "\n" + b.getASCIIgrid());
    }

    @Test
    void testDiagonal1stQuadrant8x8at3x6()
    {
        ChessBoard b = new ChessBoard(8);

        b.markDiagonal1stQuadrant(new Point(3, 6), PositionState.QUEEN);

        String q3x6 = "\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . Q\n" +
                              ". . . . . . Q .\n" +
                              ". . . . . Q . .\n" +
                              ". . . . Q . . .\n" +
                              ". . . Q . . . .\n" +
                              ". . . . . . . .\n";


        assertEquals(q3x6, "\n" + b.getASCIIgrid());
    }

    @Test
    void testDiagonal2ndQuadrant8x8at0x0()
    {
        ChessBoard b = new ChessBoard(8);

        b.markDiagonal2ndQuadrant(new Point(0, 0), PositionState.QUEEN);

        String q0x0 = "\n" +
                              "Q . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n";


        assertEquals(q0x0, "\n" + b.getASCIIgrid());
    }

    @Test
    void testDiagonal2ndQuadrant8x8at3x6()
    {
        ChessBoard b = new ChessBoard(8);

        b.markDiagonal2ndQuadrant(new Point(3, 6), PositionState.QUEEN);

        String q3x6 = "\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              "Q . . . . . . .\n" +
                              ". Q . . . . . .\n" +
                              ". . Q . . . . .\n" +
                              ". . . Q . . . .\n" +
                              ". . . . . . . .\n";


        assertEquals(q3x6, "\n" + b.getASCIIgrid());
    }

    @Test
    void testDiagonal3rdQuadrant8x8at0x0()
    {
        ChessBoard b = new ChessBoard(8);

        b.markDiagonal3rdQuadrant(new Point(0, 0), PositionState.QUEEN);

        String q0x0 = "\n" +
                              "Q . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n";


        assertEquals(q0x0, "\n" + b.getASCIIgrid());
    }

    @Test
    void testDiagonal3rdQuadrant8x8at3x6()
    {
        ChessBoard b = new ChessBoard(8);

        b.markDiagonal3rdQuadrant(new Point(3, 6), PositionState.QUEEN);

        String q3x6 = "\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . Q . . . .\n" +
                              ". . Q . . . . .\n";


        assertEquals(q3x6, "\n" + b.getASCIIgrid());
    }

    @Test
    void testDiagonal3rdQuadrant8x8at2x4()
    {
        ChessBoard b = new ChessBoard(8);

        b.markDiagonal3rdQuadrant(new Point(2, 4), PositionState.QUEEN);

        String q2x4 = "\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . Q . . . . .\n" +
                              ". Q . . . . . .\n" +
                              "Q . . . . . . .\n" +
                              ". . . . . . . .\n";


        assertEquals(q2x4, "\n" + b.getASCIIgrid());
    }


    @Test
    void testDiagonal4thQuadrant8x8at0x0()
    {
        ChessBoard b = new ChessBoard(8);

        b.markDiagonal4thQuadrant(new Point(0, 0), PositionState.QUEEN);

        String q0x0 = "\n" +
                              "Q . . . . . . .\n" +
                              ". Q . . . . . .\n" +
                              ". . Q . . . . .\n" +
                              ". . . Q . . . .\n" +
                              ". . . . Q . . .\n" +
                              ". . . . . Q . .\n" +
                              ". . . . . . Q .\n" +
                              ". . . . . . . Q\n";


        assertEquals(q0x0, "\n" + b.getASCIIgrid());
    }

    @Test
    void testDiagonal4thQuadrant8x8at3x6()
    {
        ChessBoard b = new ChessBoard(8);

        b.markDiagonal4thQuadrant(new Point(3, 6), PositionState.QUEEN);

        String q3x6 = "\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . Q . . . .\n" +
                              ". . . . Q . . .\n";


        assertEquals(q3x6, "\n" + b.getASCIIgrid());
    }

    @Test
    void testDiagonal4thQuadrant8x8at6x4()
    {
        ChessBoard b = new ChessBoard(8);

        b.markDiagonal4thQuadrant(new Point(6, 4), PositionState.QUEEN);

        String q6x4 = "\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . Q .\n" +
                              ". . . . . . . Q\n" +
                              ". . . . . . . .\n" +
                              ". . . . . . . .\n";


        assertEquals(q6x4, "\n" + b.getASCIIgrid());
    }


    @Test
    void testSingleQueenPlacement8x8at0x0()
    {
        ChessBoard b = new ChessBoard(8);
        b.placeQueen(new Point(0, 0));

        //Add a newline here and in the assert so that it prints cleanly
        // in the test report. Hacky, I know...
        String q0x0 = "\n" +
                              "Q A A A A A A A\n" +
                              "A A . . . . . .\n" +
                              "A . A . . . . .\n" +
                              "A . . A . . . .\n" +
                              "A . . . A . . .\n" +
                              "A . . . . A . .\n" +
                              "A . . . . . A .\n" +
                              "A . . . . . . A\n";

        assertEquals(q0x0, "\n" + b.getASCIIgrid());
    }

    @Test
    void testSingleQueenPlacement8x8at7x7()
    {
        ChessBoard b = new ChessBoard(8);
        b.placeQueen(new Point(7, 7));

        String q7x7 = "\n" +
                              "A . . . . . . A\n" +
                              ". A . . . . . A\n" +
                              ". . A . . . . A\n" +
                              ". . . A . . . A\n" +
                              ". . . . A . . A\n" +
                              ". . . . . A . A\n" +
                              ". . . . . . A A\n" +
                              "A A A A A A A Q\n";

        assertEquals(q7x7, "\n" + b.getASCIIgrid());
    }

    @Test
    void testSingleQueenPlacement8x8at3x2()
    {
        ChessBoard b = new ChessBoard(8);
        b.placeQueen(new Point(3, 2));

        String q3x2 = "\n" +
                              ". A . A . A . .\n" +
                              ". . A A A . . .\n" +
                              "A A A Q A A A A\n" +
                              ". . A A A . . .\n" +
                              ". A . A . A . .\n" +
                              "A . . A . . A .\n" +
                              ". . . A . . . A\n" +
                              ". . . A . . . .\n";

        assertEquals(q3x2, "\n" + b.getASCIIgrid());
    }
}
