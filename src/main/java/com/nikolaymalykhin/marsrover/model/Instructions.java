package com.nikolaymalykhin.marsrover.model;

import java.util.LinkedList;

public class Instructions {
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

    public Boolean hasNext() {
        return !allInstructions.isEmpty();
    }

    public static class Builder {
        private LinkedList<Instruction> instructions = new LinkedList<>();

        public Instructions.Builder instruction(final String instruction) {
            instructions.add(Instruction.valueOf(instruction));
            return this;
        }

        public Instructions build() {
            return new Instructions(new LinkedList<>(instructions));
        }

        public Builder series(final String series) {
            for (String instruction : series.split("")) {
                this.instruction(instruction);
            }

            return this;
        }
    }
}
