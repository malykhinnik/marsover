package com.nikolaymalykhin.marsrover.model;

import com.nikolaymalykhin.marsrover.exceptions.PlateauCreateException;
import com.nikolaymalykhin.marsrover.exceptions.PlateauSizeLimitException;

public class Plateau {
    private final Coordinates lowerLeftCoordinates;
    private final Coordinates upperRightCoordinates;

    private Plateau(final Coordinates lowerLeftCoordinates, final Coordinates upperRightCoordinates) {
        this.lowerLeftCoordinates = lowerLeftCoordinates;
        this.upperRightCoordinates = upperRightCoordinates;
    }

    public static Plateau.Builder builder() {
        return new Plateau.Builder();
    }

    public void checkIncreaseY(final int y) {
        if (y >= upperRightCoordinates.getY()) {
            throw new PlateauSizeLimitException();
        }
    }

    public void checkIncreaseX(final int x) {
        if (x >= upperRightCoordinates.getX()) {
            throw new PlateauSizeLimitException();
        }
    }

    public void checkDecreaseY(final int y) {
        if (y <= lowerLeftCoordinates.getY()) {
            throw new PlateauSizeLimitException();
        }
    }

    public void checkDecreaseX(final int x) {
        if (x <= lowerLeftCoordinates.getX()) {
            throw new PlateauSizeLimitException();
        }
    }

    public static class Builder {
        private static final Coordinates DEFAULT_LOWER_LEFT_COORDINATES = Coordinates.builder().x(0).y(0).build();
        private Coordinates upperRightCoordinates;

        public Plateau.Builder upperRightCoordinates(final Coordinates upperRightCoordinates) {
            this.upperRightCoordinates = upperRightCoordinates;
            return this;
        }

        public Plateau build() {
            if (upperRightCoordinates == null) {
                throw new PlateauCreateException();
            }
            return new Plateau(DEFAULT_LOWER_LEFT_COORDINATES, upperRightCoordinates);
        }
    }
}
