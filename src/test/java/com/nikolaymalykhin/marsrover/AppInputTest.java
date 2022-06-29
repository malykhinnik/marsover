package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.exceptions.RoverExploreInstructionException;
import com.nikolaymalykhin.marsrover.exceptions.RoverNotFoundException;
import com.nikolaymalykhin.marsrover.exceptions.WrongUpperRightCoordinateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppInputTest {
    private final App app;

    @Autowired
    public AppInputTest(final App app) {
        this.app = app;
    }

    @Test
    void testInputUpperRightCoordinateWithoutRover() {
        Assertions.assertThrows(RoverNotFoundException.class, () -> app.run("5", "5"));
    }

    @Test
    void testInputUpperRightCoordinateWrongFirstElement() {
        Assertions.assertThrows(WrongUpperRightCoordinateException.class, () -> app.run("N", "5"));
    }

    @Test
    void testInputUpperRightCoordinateWrongSecondElement() {
        Assertions.assertThrows(WrongUpperRightCoordinateException.class, () -> app.run("5", "L"));
    }

    @Test
    void testInputRoverWrongFirstCoordinate() {
        Assertions.assertThrows(RoverNotFoundException.class, () -> app.run("5", "5", "N", "2", "N"));
    }

    @Test
    void testInputRoverWrongSecondCoordinate() {
        Assertions.assertThrows(RoverNotFoundException.class, () -> app.run("5", "5", "1", "L", "N"));
    }

    @Test
    void testInputRoverCardinalCompasPointContainsNumber() {
        Assertions.assertThrows(RoverNotFoundException.class, () -> app.run("5", "5", "1", "2", "1"));
    }

    @Test
    void testInputRoverCardinalCompasPointContainsWrongLetter() {
        Assertions.assertThrows(RoverNotFoundException.class, () -> app.run("5", "5", "1", "2", "L"));
    }

    @Test
    void testInputRoverExploreInstructionContainsNumber() {
        Assertions.assertThrows(RoverExploreInstructionException.class, () -> app.run("5", "5", "1", "2", "N", "1MLMLMLMM"));
    }

    @Test
    void testInputRoverWrongExploreInstructionContainsWrongLetter() {
        Assertions.assertThrows(RoverExploreInstructionException.class, () -> app.run("5", "5", "1", "2", "N", "LNLMLMLMM"));
    }

    @Test
    void testInputRoverWrongExploreInstructionContainsSpace() {
        Assertions.assertThrows(RoverExploreInstructionException.class, () -> app.run("5", "5", "1", "2", "N", "LM LMLMLMM"));
    }

    @Test
    void testInputRover() {
        Assertions.assertAll(() -> app.run("5", "5", "1", "2", "N", "LMLMLMLMM"));
    }

    @Test
    void testInputTwoRovers() {
        Assertions.assertAll(() -> app.run("5", "5", "1", "2", "N", "LMLMLMLMM", "3", "3", "E", "MMRMMRMRRM"));
    }
}
