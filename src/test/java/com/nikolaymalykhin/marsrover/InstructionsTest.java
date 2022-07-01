package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.model.Instruction;
import com.nikolaymalykhin.marsrover.model.Instructions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InstructionsTest {
    @Test
    void createInstructions() {
        Instructions instructions = Instructions.builder().instruction("L").instruction("R").instruction("M").build();
        Assertions.assertEquals(Instruction.L, instructions.next());
        Assertions.assertEquals(Instruction.R, instructions.next());
        Assertions.assertEquals(Instruction.M, instructions.next());
    }

    @Test
    void createInstructionsFromSeries() {
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
    void createInstructionsHasNext() {
        Instructions instructions = Instructions.builder().instruction("L").build();
        Assertions.assertEquals(Boolean.TRUE, instructions.hasNext());
        Assertions.assertEquals(Instruction.L, instructions.next());
        Assertions.assertEquals(Boolean.FALSE, instructions.hasNext());
    }
}
