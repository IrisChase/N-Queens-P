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
