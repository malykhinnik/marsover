package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.model.CardinalCompassPoint;
import com.nikolaymalykhin.marsrover.model.Coordinates;
import com.nikolaymalykhin.marsrover.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    void createPosition() {
        Position position = createPosition(1, 2, CardinalCompassPoint.N);
        Assertions.assertEquals(1, position.getX());
        Assertions.assertEquals(2, position.getY());
        Assertions.assertEquals(CardinalCompassPoint.N, position.getOrientation());
    }

    @Test
    void spinLeft() {
        Position position = createPosition(1, 2, CardinalCompassPoint.N);
        position.spinLeft();
        Assertions.assertEquals(1, position.getX());
        Assertions.assertEquals(2, position.getY());
        Assertions.assertEquals(CardinalCompassPoint.W, position.getOrientation());
    }

    @Test
    void spinRight() {
        Position position = createPosition(1, 2, CardinalCompassPoint.N);
        position.spinRight();
        Assertions.assertEquals(1, position.getX());
        Assertions.assertEquals(2, position.getY());
        Assertions.assertEquals(CardinalCompassPoint.E, position.getOrientation());
    }

    @Test
    void moveN() {
        Position position = createPosition(1, 2, CardinalCompassPoint.N);
        position.move();
        Assertions.assertEquals(1, position.getX());
        Assertions.assertEquals(3, position.getY());
        Assertions.assertEquals(CardinalCompassPoint.N, position.getOrientation());
    }

    @Test
    void moveE() {
        Position position = createPosition(1, 2, CardinalCompassPoint.E);
        position.move();
        Assertions.assertEquals(2, position.getX());
        Assertions.assertEquals(2, position.getY());
        Assertions.assertEquals(CardinalCompassPoint.E, position.getOrientation());
    }

    @Test
    void moveS() {
        Position position = createPosition(1, 2, CardinalCompassPoint.S);
        position.move();
        Assertions.assertEquals(1, position.getX());
        Assertions.assertEquals(1, position.getY());
        Assertions.assertEquals(CardinalCompassPoint.S, position.getOrientation());
    }

    @Test
    void moveW() {
        Position position = createPosition(1, 2, CardinalCompassPoint.W);
        position.move();
        Assertions.assertEquals(0, position.getX());
        Assertions.assertEquals(2, position.getY());
        Assertions.assertEquals(CardinalCompassPoint.W, position.getOrientation());
    }

    private Position createPosition(final Integer x, final Integer y, final CardinalCompassPoint orientation) {
        Coordinates roverPositionCoordinates = Coordinates.builder().x(x).y(y).build();
        return Position.builder().coordinates(roverPositionCoordinates).orientation(orientation).build();
    }
}
