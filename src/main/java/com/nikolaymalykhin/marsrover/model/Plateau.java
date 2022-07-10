package com.nikolaymalykhin.marsrover.model;

import com.nikolaymalykhin.marsrover.exceptions.PlateauCreateException;
import com.nikolaymalykhin.marsrover.exceptions.PlateauSizeLimitException;

public class Plateau {
    private final Coordinates lowerLeftCoordinates;
    private final Coordinates upperRightCoordinates;

    private Plateau(
            final Coordinates lowerLeftCoordinates,
            final Coordinates upperRightCoordinates
    ) {
        this.lowerLeftCoordinates = lowerLeftCoordinates;
        this.upperRightCoordinates = upperRightCoordinates;
    }

    public static Plateau.Builder builder() {
        return new Plateau.Builder();
    }

    public void inSize(final Coordinates coordinates) {
        if (coordinates == null ||
                coordinates.getX() < lowerLeftCoordinates.getX() || coordinates.getX() > upperRightCoordinates.getX() ||
                coordinates.getY() < lowerLeftCoordinates.getX() || coordinates.getY() > upperRightCoordinates.getY()) {
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
