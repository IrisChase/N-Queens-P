package com.enesda.nqueensp;

//Think of this as less of a class and more of a composite
// data type with a couple helpers
public class Point
{
    public int x;
    public int y;

    Point(int theX, int theY)
    {
        x = theX;
        y = theY;
    }

    Point(Point p)
    {
        x = p.x;
        y = p.y;
    }

    public int getFlatOffset(int n)
    {
        return y * n + x;
    }
}

