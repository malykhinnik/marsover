package com.nikolaymalykhin.marsrover.model;

import com.nikolaymalykhin.marsrover.exceptions.CoordinatesCreateException;

import java.util.Objects;

public class Coordinates {
    private final int x;
    private final int y;

    private Coordinates(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates.Builder builder() {
        return new Coordinates.Builder();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Coordinates increaseX() {
        return Coordinates.builder().x(x + 1).y(y).build();
    }

    public Coordinates decreaseX() {
        return Coordinates.builder().x(x - 1).y(y).build();
    }

    public Coordinates increaseY() {
        return Coordinates.builder().x(x).y(y + 1).build();
    }

    public Coordinates decreaseY() {
        return Coordinates.builder().x(x).y(y - 1).build();
    }

    public static class Builder {
        private Integer x;
        private Integer y;

        public Coordinates.Builder x(final int x) {
            this.x = x;
            return this;
        }

        public Coordinates.Builder y(final int y) {
            this.y = y;
            return this;
        }

        public Coordinates build() {
            if (x == null || y == null) {
                throw new CoordinatesCreateException();
            }
            return new Coordinates(x, y);
        }
    }
}
