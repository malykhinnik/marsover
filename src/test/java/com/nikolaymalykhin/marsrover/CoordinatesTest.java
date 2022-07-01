package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.model.Coordinates;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoordinatesTest {
    @Test
    void createCoordinates() {
        Coordinates coordinates = Coordinates.builder().x(0).y(0).build();
        Assertions.assertEquals(0, coordinates.getX());
        Assertions.assertEquals(0, coordinates.getY());
    }

    @Test
    void equalsCoordinate() {
        Coordinates coordinates1 = Coordinates.builder().x(0).y(0).build();
        Coordinates coordinates2 = Coordinates.builder().x(0).y(0).build();
        Assertions.assertEquals(coordinates1, coordinates2);
    }
}
