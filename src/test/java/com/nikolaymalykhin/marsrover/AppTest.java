package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.exceptions.AppRunException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {
    @Test
    void whenNoArgsThenThrow() {
        Assertions.assertThrows(AppRunException.class, () -> App.run(new String[] {}));
    }

    @Test
    void whenRunStringNoContains6ValuesSeparatedGapThenThrow() {
        Assertions.assertThrows(AppRunException.class, () -> App.run(new String[] {"5512NLMLMLMLMM"}));
    }

    @Test
    void whenRun5512NLMLMLMLMMThen13N() {
        Assertions.assertEquals("1 3 N", App.run(new String[] {"5 5 1 2 N LMLMLMLMM"}));
    }

    @Test
    void whenNextRoverNoContains4ValuesThenThrow() {
        Assertions.assertThrows(AppRunException.class, () -> App.run(new String[] {"5 5 1 2 N LMLMLMLMM 3 3 E"}));
    }

    @Test
    void whenRun5512NLMLMLMLMM33EMMRMMRMRRMThen13N51E() {
        Assertions.assertEquals("1 3 N 5 1 E", App.run(new String[] {"5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM"}));
    }
}
