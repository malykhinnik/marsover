package com.nikolaymalykhin.marsrover.model;

public class Position {
    private Coordinates coordinates;
    private CardinalCompassPoint orientation;

    private Position(final Coordinates coordinates, final CardinalCompassPoint orientation) {
        this.coordinates = coordinates;
        this.orientation = orientation;
    }

    public static Position.Builder builder() {
        return new Position.Builder();
    }

    public int getX() {
        return coordinates.getX();
    }

    public int getY() {
        return coordinates.getY();
    }

    public CardinalCompassPoint getOrientation() {
        return orientation;
    }

    public void spinLeft() {
        orientation = orientation.addDegrees(-90);
    }

    public void spinRight() {
        orientation = orientation.addDegrees(90);
    }

    public void move() {
        switch (orientation) {
            case N -> updateCoordinates(getX(), getY() + 1);
            case E -> updateCoordinates(getX() + 1, getY());
            case S -> updateCoordinates(getX(), getY() - 1);
            case W -> updateCoordinates(getX() - 1, getY());
        }
    }

    private void updateCoordinates(final Integer x, final Integer y) {
        coordinates = Coordinates.builder().x(x).y(y).build();
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", getX(), getY(), getOrientation());
    }

    public static class Builder {
        private Coordinates coordinates;
        private CardinalCompassPoint orientation;

        public Position.Builder coordinates(final Coordinates coordinates) {
            this.coordinates = coordinates;
            return this;
        }

        public Position.Builder orientation(final CardinalCompassPoint orientation) {
            this.orientation = orientation;
            return this;
        }

        public Position build() {
            return new Position(coordinates, orientation);
        }
    }
}
