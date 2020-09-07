package com.enesda.nqueensp;

import java.lang.Math;
import java.math.BigInteger;

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

    public void add(Point p)
    {
        x += p.x;
        y += p.y;
    }

    public void invertVector()
    {
        x = -x;
        y = -y;
    }

    public int getFlatOffset(int n)
    {
        return y * n + x;
    }

    public double getVectorAngle()
    {
        return Math.atan(x/y);
    }

    public String toString()
    {
        return "x: " + x + ", y: " + y;
    }

    public boolean equals(Object other)
    {
        if(this == other) return true;
        if(!(other instanceof Point)) return false;

        Point otherP = (Point) other;
        return x == otherP.x && y == otherP.y;
    }

    public static Point getMinimumWholeVectorWithSameAngle(Point referenceVector)
    {
        BigInteger bigX = BigInteger.valueOf(Math.abs(referenceVector.x));
        BigInteger bigY = BigInteger.valueOf(Math.abs(referenceVector.y));

        BigInteger gcd = bigX.gcd(bigY);

        bigX = bigX.divide(gcd);
        bigY = bigY.divide(gcd);

        Point rslt = new Point(bigX.intValue(), bigY.intValue());

        if(referenceVector.x < 0)
            rslt.x = -rslt.x;

        if(referenceVector.y < 0)
            rslt.y = -rslt.y;

        assert(referenceVector.getVectorAngle() == rslt.getVectorAngle());

        return rslt;
    }

    public static Point getVectorBetweenPoints(Point a, Point b)
    {
        return new Point(b.x - a.x,b.y - a.y);
    }

}

