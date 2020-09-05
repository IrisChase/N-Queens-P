package com.enesda.nqueensp;

public class Main
{
    public static void main(String args[])
    {
        if(args.length > 1)
        {
            System.out.println("Warning: Ignoring additional arguments.");
        }

        int n = 0;

        try
        {
            n = Integer.parseInt(args[0]);
        }
        catch(ArrayIndexOutOfBoundsException x)
        {
            System.out.println("Usage: nqueensp N");
        }
        catch(NumberFormatException x)
        {
            System.out.println("Error: first argument is not a number.");
        }
        catch(Exception x)
        {
            System.out.println("An unknown exception occurred.");
        }

        try
        {
            ChessBoard myChessBoard = new ChessBoard(n);
            myChessBoard.addQueens();
            System.out.println(myChessBoard.getPrettyPrintedString());
        }
        catch(Exception x)
        {
            System.out.println("Internal logic error");
        }
    }
}
