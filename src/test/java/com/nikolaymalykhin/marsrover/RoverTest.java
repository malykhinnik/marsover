package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.exceptions.RoverCreateException;
import com.nikolaymalykhin.marsrover.model.CardinalCompassPoint;
import com.nikolaymalykhin.marsrover.model.Coordinates;
import com.nikolaymalykhin.marsrover.model.Instructions;
import com.nikolaymalykhin.marsrover.model.Plateau;
import com.nikolaymalykhin.marsrover.model.Position;
import com.nikolaymalykhin.marsrover.model.Rover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RoverTest {
    @Test
    void whenCreateRoverWithoutPositionThenThrow() {
        Assertions.assertThrows(RoverCreateException.class, () -> Rover.builder().build());
    }

    @Test
    void whenSeriesLMLMLMLMMFor12NThen13N() {
        Rover rover = createRover(1, 2, CardinalCompassPoint.N);
        Instructions instructions = Instructions.builder().series("LMLMLMLMM").build();
        rover.move(instructions);
        Assertions.assertEquals("1 3 N", rover.getPosition());
    }

    @Test
    void whenSeriesMMRMMRMRRMFor33EThen51E() {
        Rover rover = createRover(3, 3, CardinalCompassPoint.E);
        Instructions instructions = Instructions.builder().series("MMRMMRMRRM").build();
        rover.move(instructions);
        Assertions.assertEquals("5 1 E", rover.getPosition());
    }

    private Rover createRover(final Integer x, final Integer y, final CardinalCompassPoint orientation) {
        Coordinates roverPositionCoordinates = Coordinates.builder().x(x).y(y).build();
        final Plateau plateau = Plateau.builder().upperRightCoordinates(Coordinates.builder().x(5).y(5).build()).build();
        Position roverPosition = Position.builder().coordinates(roverPositionCoordinates).orientation(orientation).plateau(plateau).build();
        return Rover.builder().position(roverPosition).build();
    }
}
