package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.exceptions.InstructionsCreateException;
import com.nikolaymalykhin.marsrover.model.Instruction;
import com.nikolaymalykhin.marsrover.model.Instructions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InstructionsTest {
    @Test
    void whenAddSeriesThenOrderNoChange() {
        Instructions instructions = Instructions.builder().series("LMLMLMLMM").build();
        Assertions.assertEquals(Instruction.L, instructions.next());
        Assertions.assertEquals(Instruction.M, instructions.next());
        Assertions.assertEquals(Instruction.L, instructions.next());
        Assertions.assertEquals(Instruction.M, instructions.next());
        Assertions.assertEquals(Instruction.L, instructions.next());
        Assertions.assertEquals(Instruction.M, instructions.next());
        Assertions.assertEquals(Instruction.L, instructions.next());
        Assertions.assertEquals(Instruction.M, instructions.next());
        Assertions.assertEquals(Instruction.M, instructions.next());
    }

    @Test
    void whenInstructionsContainsInstructuionThenHasNextTrue() {
        Instructions instructions = Instructions.builder().series("L").build();
        Assertions.assertEquals(Boolean.TRUE, instructions.hasNext());
    }

    @Test
    void whenInstructionsNoContainsInstructuionThenHasNextFalse() {
        Instructions instructions = Instructions.builder().series("L").build();
        instructions.next();
        Assertions.assertEquals(Boolean.FALSE, instructions.hasNext());
    }

    @Test
    void thenSeriesEmptyThenThrow() {
        Assertions.assertThrows(InstructionsCreateException.class, () -> Instructions.builder().series("").build());
    }
}
