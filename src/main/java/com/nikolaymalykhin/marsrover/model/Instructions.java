package com.nikolaymalykhin.marsrover.model;

import com.nikolaymalykhin.marsrover.exceptions.InstructionsCreateException;

import java.util.Iterator;
import java.util.LinkedList;

public class Instructions implements Iterator<Instruction> {
    private final LinkedList<Instruction> allInstructions;

    private Instructions(final LinkedList<Instruction> allInstructions) {
        this.allInstructions = allInstructions;
    }

    public static Instructions.Builder builder() {
        return new Instructions.Builder();
    }

    public Instruction next() {
        return allInstructions.removeFirst();
    }

    public boolean hasNext() {
        return !allInstructions.isEmpty();
    }

    public static class Builder {
        private final LinkedList<Instruction> instructions = new LinkedList<>();

        private Instructions.Builder instruction(final String instruction) {
            instructions.add(Instruction.valueOf(instruction));
            return this;
        }

        public Instructions build() {
            return new Instructions(new LinkedList<>(instructions));
        }

        public Builder series(final String series) {
            if (series == null || series.isEmpty()) {
                throw new InstructionsCreateException();
            }
            for (String instruction : series.split("")) {
                this.instruction(instruction);
            }

            return this;
        }
    }
}
