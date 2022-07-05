package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.exceptions.PlateauSizeLimitException;
import com.nikolaymalykhin.marsrover.exceptions.PositionCreateException;
import com.nikolaymalykhin.marsrover.model.CardinalCompassPoint;
import com.nikolaymalykhin.marsrover.model.Coordinates;
import com.nikolaymalykhin.marsrover.model.Plateau;
import com.nikolaymalykhin.marsrover.model.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.nikolaymalykhin.marsrover.model.CardinalCompassPoint.E;
import static com.nikolaymalykhin.marsrover.model.CardinalCompassPoint.N;
import static com.nikolaymalykhin.marsrover.model.CardinalCompassPoint.S;
import static com.nikolaymalykhin.marsrover.model.CardinalCompassPoint.W;

class PositionTest {
    @Test
    void whenCreatePositionWithoutPlateauThrowException() {
        Assertions.assertThrows(PositionCreateException.class,
                () -> Position.builder().coordinates(Coordinates.builder().x(1).y(2).build()).orientation(N).build());
    }

    @Test
    void whenCreatePositionWithoutOrientationThrowException() {
        final Plateau plateau = createPlateau();
        Assertions.assertThrows(PositionCreateException.class,
                () -> Position.builder().coordinates(Coordinates.builder().x(1).y(2).build()).plateau(plateau).build());
    }

    @Test
    void whenCreatePositionWithoutCoordinatesThrowException() {
        final Plateau plateau = createPlateau();
        Assertions.assertThrows(PositionCreateException.class, () -> Position.builder().orientation(N).plateau(plateau).build());
    }

    @Test
    void whenNSpinLeftThenW() {
        Position position = createPosition(1, 2, N);
        position.spinLeft();
        Position newPosition = createPosition(1, 2, W);
        Assertions.assertEquals(newPosition, position);
    }

    @Test
    void whenNSpinRightThenE() {
        Position position = createPosition(1, 2, N);
        position.spinRight();
        Position newPosition = createPosition(1, 2, E);
        Assertions.assertEquals(newPosition, position);
    }

    @Test
    void whenMoveNThenIncreaseY() {
        Position position = createPosition(1, 2, N);
        position.move();
        Position newPosition = createPosition(1, 3, N);
        Assertions.assertEquals(newPosition, position);
    }

    @Test
    void whenMoveEThenIncreaseX() {
        Position position = createPosition(1, 2, E);
        position.move();
        Position newPosition = createPosition(2, 2, E);
        Assertions.assertEquals(newPosition, position);
    }

    @Test
    void whenMoveSThenDecreaseY() {
        Position position = createPosition(1, 2, S);
        position.move();
        Position newPosition = createPosition(1, 1, S);
        Assertions.assertEquals(newPosition, position);
    }

    @Test
    void whenMoveWThenDecreaseX() {
        Position position = createPosition(1, 2, W);
        position.move();
        Position newPosition = createPosition(0, 2, W);
        Assertions.assertEquals(newPosition, position);
    }

    @Test
    void whenMoveNOutPlateauThenThrow() {
        Position position = createPosition(4, 5, N);
        Assertions.assertThrows(PlateauSizeLimitException.class, position::move);
    }

    @Test
    void whenMoveEOutPlateauThenThrow() {
        Position position = createPosition(5, 4, E);
        Assertions.assertThrows(PlateauSizeLimitException.class, position::move);
    }

    @Test
    void whenMoveSOutPlateauThenThrow() {
        Position position = createPosition(5, 0, S);
        Assertions.assertThrows(PlateauSizeLimitException.class, position::move);
    }

    @Test
    void whenMoveWOutPlateauThenThrow() {
        Position position = createPosition(0, 5, W);
        Assertions.assertThrows(PlateauSizeLimitException.class, position::move);
    }

    private Position createPosition(final int x, final int y, final CardinalCompassPoint orientation) {
        final Coordinates roverPositionCoordinates = Coordinates.builder().x(x).y(y).build();
        final Plateau plateau = createPlateau();
        return Position.builder().coordinates(roverPositionCoordinates).orientation(orientation).plateau(plateau).build();
    }

    private Plateau createPlateau() {
        return Plateau.builder().upperRightCoordinates(Coordinates.builder().x(5).y(5).build()).build();
    }
}
