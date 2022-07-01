package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.model.CardinalCompassPoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardinalCompassPointTest {
    @Test
    void add90Degrees() {
        Assertions.assertEquals(CardinalCompassPoint.E, CardinalCompassPoint.N.addDegrees(90));
        Assertions.assertEquals(CardinalCompassPoint.S, CardinalCompassPoint.E.addDegrees(90));
        Assertions.assertEquals(CardinalCompassPoint.W, CardinalCompassPoint.S.addDegrees(90));
        Assertions.assertEquals(CardinalCompassPoint.N, CardinalCompassPoint.W.addDegrees(90));
    }

    @Test
    void addMinus90Degrees() {
        Assertions.assertEquals(CardinalCompassPoint.W, CardinalCompassPoint.N.addDegrees(-90));
        Assertions.assertEquals(CardinalCompassPoint.S, CardinalCompassPoint.W.addDegrees(-90));
        Assertions.assertEquals(CardinalCompassPoint.E, CardinalCompassPoint.S.addDegrees(-90));
        Assertions.assertEquals(CardinalCompassPoint.N, CardinalCompassPoint.E.addDegrees(-90));
    }
}
