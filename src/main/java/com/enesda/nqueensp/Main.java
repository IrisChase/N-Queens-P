//Copyright 2020 Iris Chase
//
//      Licensed under the Apache License, Version 2.0 (the "License");
//      you may not use this file except in compliance with the License.
//      You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
//      Unless required by applicable law or agreed to in writing, software
//      distributed under the License is distributed on an "AS IS" BASIS,
//      WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//      See the License for the specific language governing permissions and
//      limitations under the License.
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
            ChessBoard myChessBoard = ChessBoard.getSolvedBoardForN(n) ;
            System.out.print(myChessBoard.renderToString(new FinalCellRenderer()));
        }
        catch(NQueensUnsolvableForNException x)
        {
            System.out.println("Problem unsolvable for N of " + x.n + ".");
        }
        catch(Exception x)
        {
            System.out.println("Internal logic error");
        }
    }
}
