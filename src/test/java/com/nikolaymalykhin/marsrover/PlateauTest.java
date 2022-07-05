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
        Plateau plateau = createPlateau55();
        Assertions.assertThrows(PlateauSizeLimitException.class, () -> plateau.checkIncreaseY(5));
    }

    @Test
    void whenCheckIncreaseXOverUpperRightCoordinateXThenThrow() {
        Plateau plateau = createPlateau55();
        Assertions.assertThrows(PlateauSizeLimitException.class, () -> plateau.checkIncreaseX(5));
    }

    @Test
    void whenCheckDecreaseYUnderLowerLeftCoordinateYThenThrow() {
        Plateau plateau = createPlateau55();
        Assertions.assertThrows(PlateauSizeLimitException.class, () -> plateau.checkDecreaseY(0));
    }

    @Test
    void whenCheckDecreaseXUnderLowerLeftCoordinateXThenThrow() {
        Plateau plateau = createPlateau55();
        Assertions.assertThrows(PlateauSizeLimitException.class, () -> plateau.checkDecreaseX(0));
    }

    private Plateau createPlateau55() {
        Coordinates upperRightCoordinates = Coordinates.builder().x(5).y(5).build();
        Plateau plateau = Plateau.builder().upperRightCoordinates(upperRightCoordinates).build();
        return plateau;
    }
}
