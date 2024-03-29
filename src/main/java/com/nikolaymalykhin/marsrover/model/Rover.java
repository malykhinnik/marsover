package com.nikolaymalykhin.marsrover.model;

import com.nikolaymalykhin.marsrover.exceptions.RoverCreateException;

public class Rover {
    private final Position position;

    public Rover(final Position position) {
        this.position = position;
    }

    public static Rover.Builder builder() {
        return new Rover.Builder();
    }

    public String getPosition() {
        return position.toString();
    }

    public void move(final Instructions instructions) {
        // вот какая красота то получилась!
        instructions.forEachRemaining(this::move);
    }

    private void move(final Instruction instruction) {
        switch (instruction) {
            case L -> position.spinLeft();
            case R -> position.spinRight();
            case M -> position.move();
        }
    }

    public static class Builder {
        private Position position;

        public Rover.Builder position(final Position position) {
            this.position = position;
            return this;
        }

        public Rover build() {
            if (position == null) {
                throw new RoverCreateException();
            }
            return new Rover(position);
        }
    }
}
