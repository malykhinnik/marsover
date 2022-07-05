package com.nikolaymalykhin.marsrover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.nikolaymalykhin.marsrover.model.CardinalCompassPoint.E;
import static com.nikolaymalykhin.marsrover.model.CardinalCompassPoint.N;
import static com.nikolaymalykhin.marsrover.model.CardinalCompassPoint.S;
import static com.nikolaymalykhin.marsrover.model.CardinalCompassPoint.W;

class CardinalCompassPointTest {
    @Test
    void whenNTurnLeftThenW() {
        Assertions.assertEquals(W, N.turnLeft());
    }

    @Test
    void whenWTurnLeftThenS() {
        Assertions.assertEquals(S, W.turnLeft());
    }

    @Test
    void whenSTurnLeftThenE() {
        Assertions.assertEquals(E, S.turnLeft());
    }

    @Test
    void whenETurnLeftThenN() {
        Assertions.assertEquals(E, S.turnLeft());
    }

    @Test
    void whenNTurnRightThenE() {
        Assertions.assertEquals(E, N.turnRight());
    }

    @Test
    void whenETurnRightThenS() {
        Assertions.assertEquals(S, E.turnRight());
    }

    @Test
    void whenSTurnRightThenW() {
        Assertions.assertEquals(W, S.turnRight());
    }

    @Test
    void whenWTurnRightThenN() {
        Assertions.assertEquals(N, W.turnRight());
    }
}
