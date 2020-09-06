package com.enesda.nqueensp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest
{
    @Test
    void testGetVectorBetween0x0and3x3()
    {
        Point v1 = new Point(0,0);
        Point v2 = new Point(3,3);

        Point rslt = Point.getVectorBetweenPoints(v1, v2);

        assertEquals(new Point(3,3), rslt);
    }

    @Test
    void testGetVectorBetween3x3and0x0()
    {
        Point v1 = new Point(3,3);
        Point v2 = new Point(0,0);

        Point rslt = Point.getVectorBetweenPoints(v1, v2);

        assertEquals(new Point(-3,-3), rslt);
    }

    @Test
    void testGetVectorBetween1x2and3x3()
    {
        Point v1 = new Point(1,2);
        Point v2 = new Point(3,3);

        Point rslt = Point.getVectorBetweenPoints(v1, v2);

        assertEquals(new Point(2,1), rslt);
    }

    @Test
    void testGetMinimumVectorOfAngle2x7()
    {
        Point v = new Point(2,7);

        Point minV = Point.getMinimumWholeVectorWithSameAngle(v);

        assertEquals(v, minV);
    }

    @Test
    void testGetMinimumVectorOfAngleNeg2x7()
    {
        Point v = new Point(-2,7);

        Point minV = Point.getMinimumWholeVectorWithSameAngle(v);

        assertEquals(v, minV);
    }

    @Test
    void testGetMinimumVectorOfAngleNeg2xNeg7()
    {
        Point v = new Point(-2,-7);

        Point minV = Point.getMinimumWholeVectorWithSameAngle(v);

        assertEquals(v, minV);
    }

    @Test
    void testGetMinimumVectorOfAngle2xNeg7()
    {
        Point v = new Point(2,-7);

        Point minV = Point.getMinimumWholeVectorWithSameAngle(v);

        assertEquals(v, minV);
    }

    @Test
    void testGetMinimumVectorOfAngle4x14()
    {
        Point v = new Point(4,14);

        Point minV = Point.getMinimumWholeVectorWithSameAngle(v);

        assertEquals(new Point(2,7), minV);
    }

    @Test
    void testGetMinimumVectorOfAngle9x3()
    {
        Point v = new Point(9,3);

        Point minV = Point.getMinimumWholeVectorWithSameAngle(v);

        assertEquals(new Point(3,1), minV);
    }
}
