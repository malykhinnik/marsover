package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.model.Coordinates;
import com.nikolaymalykhin.marsrover.model.Plateau;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PlateauTest {
    @Test
    void createPlateau() {
        Coordinates lowerLeftCoordinates = Coordinates.builder().x(0).y(0).build();
        Coordinates upperRightCoordinates = Coordinates.builder().x(5).y(5).build();
        Plateau plateau = Plateau.builder().upperRightCoordinates(upperRightCoordinates).build();
        Assertions.assertEquals(lowerLeftCoordinates, plateau.getLowerLeftCoordinates());
        Assertions.assertEquals(upperRightCoordinates, plateau.getUpperRightCoordinates());
    }
}
