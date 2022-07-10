package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.exceptions.PlateauCreateException;
import com.nikolaymalykhin.marsrover.exceptions.PlateauSizeLimitException;
import com.nikolaymalykhin.marsrover.model.Coordinates;
import com.nikolaymalykhin.marsrover.model.Plateau;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlateauTest {
    @Test
    void whenCreatePlateauWithoutUpperRightCoordinatesThenThrow() {
        Assertions.assertThrows(PlateauCreateException.class, () -> Plateau.builder().build());
    }

    @Test
    void whenCheckIncreaseYOverUpperRightCoordinateYThenThrow() {
        Coordinates coordinates = Coordinates.builder().x(0).y(6).build();
        Plateau plateau = createPlateau55();
        Assertions.assertThrows(PlateauSizeLimitException.class, () -> plateau.inSize(coordinates));
    }

    @Test
    void whenCheckIncreaseXOverUpperRightCoordinateXThenThrow() {
        Coordinates coordinates = Coordinates.builder().x(6).y(0).build();
        Plateau plateau = createPlateau55();
        Assertions.assertThrows(PlateauSizeLimitException.class, () -> plateau.inSize(coordinates));
    }

    @Test
    void whenCheckDecreaseYUnderLowerLeftCoordinateYThenThrow() {
        Coordinates coordinates = Coordinates.builder().x(0).y(-1).build();
        Plateau plateau = createPlateau55();
        Assertions.assertThrows(PlateauSizeLimitException.class, () -> plateau.inSize(coordinates));
    }

    @Test
    void whenCheckDecreaseXUnderLowerLeftCoordinateXThenThrow() {
        Coordinates coordinates = Coordinates.builder().x(-1).y(0).build();
        Plateau plateau = createPlateau55();
        Assertions.assertThrows(PlateauSizeLimitException.class, () -> plateau.inSize(coordinates));
    }

    private Plateau createPlateau55() {
        Coordinates upperRightCoordinates = Coordinates.builder().x(5).y(5).build();
        Plateau plateau = Plateau.builder().upperRightCoordinates(upperRightCoordinates).build();
        return plateau;
    }
}
