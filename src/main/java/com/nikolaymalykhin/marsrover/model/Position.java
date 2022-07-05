package com.nikolaymalykhin.marsrover.model;

import com.nikolaymalykhin.marsrover.exceptions.PositionCreateException;

import java.util.Objects;

public class Position {
    private final Plateau plateau;
    private Coordinates coordinates;
    private CardinalCompassPoint orientation;

    private Position(final Coordinates coordinates, final CardinalCompassPoint orientation,
                     final Plateau plateau) {
        this.coordinates = coordinates;
        this.orientation = orientation;
        this.plateau = plateau;
    }

    public static Position.Builder builder() {
        return new Position.Builder();
    }

    private int getX() {
        return coordinates.getX();
    }

    private int getY() {
        return coordinates.getY();
    }

    private CardinalCompassPoint getOrientation() {
        return orientation;
    }

    public void spinLeft() {
        orientation = orientation.turnLeft();
    }

    public void spinRight() {
        orientation = orientation.turnRight();
    }

    public void move() {
        checkPlateauSize();
        switch (orientation) {
            case N -> coordinates = coordinates.increaseY();
            case E -> coordinates = coordinates.increaseX();
            case S -> coordinates = coordinates.decreaseY();
            case W -> coordinates = coordinates.decreaseX();
        }
    }

    private void checkPlateauSize() {
        switch (orientation) {
            case N -> plateau.checkIncreaseY(getY());
            case E -> plateau.checkIncreaseX(getX());
            case S -> plateau.checkDecreaseY(getY());
            case W -> plateau.checkDecreaseX(getX());
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getX(), getY(), getOrientation());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position position = (Position) o;
        return Objects.equals(coordinates, position.coordinates) && orientation == position.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, orientation);
    }

    public static class Builder {
        private Coordinates coordinates;
        private CardinalCompassPoint orientation;
        private Plateau plateau;

        public Position.Builder coordinates(final Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public Position.Builder orientation(final CardinalCompassPoint orientation) {
            this.orientation = orientation;
            return this;
        }

        public Position.Builder plateau(final Plateau plateau) {
            this.plateau = plateau;
            return this;
        }

        public Position build() {
            if (plateau == null || orientation == null || coordinates == null) {
                throw new PositionCreateException();
            }
            return new Position(coordinates, orientation, plateau);
        }
    }
}
