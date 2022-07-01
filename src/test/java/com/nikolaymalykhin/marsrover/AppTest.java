package com.nikolaymalykhin.marsrover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void appTest() {
        String upperRightCoordinates = "5 5";
        String rover1Position = "1 2 N";
        String rover1Instructions = "LMLMLMLMM";
        String rover2Position = "3 3 E";
        String rover2Instructions = "MMRMMRMRRM";

        App app = new App();
        String response =
                app.run(new String[] {upperRightCoordinates, rover1Position, rover1Instructions, rover2Position, rover2Instructions});
        Assertions.assertEquals("1 3 N 5 1 E", response);
    }
}
