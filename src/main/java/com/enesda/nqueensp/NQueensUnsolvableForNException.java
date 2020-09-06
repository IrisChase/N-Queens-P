package com.enesda.nqueensp;

public class NQueensUnsolvableForNException extends Exception
{
    public final int n;

    NQueensUnsolvableForNException(int theN)
    {
        n = theN;
    }
}
