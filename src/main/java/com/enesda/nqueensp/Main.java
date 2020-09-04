package com.enesda.nqueensp;

public class Main
{
    public static void main(String args[])
    {
        System.out.println("Hello... Darkness my old friend.");
        ChessBoard myChessBoard = new ChessBoard(8);
        System.out.println(myChessBoard.getPrettyPrintedString());
    }
}
