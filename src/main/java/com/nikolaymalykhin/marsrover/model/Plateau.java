package com.nikolaymalykhin.marsrover.model;

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

    public Coordinates getLowerLeftCoordinates() {
        return lowerLeftCoordinates;
    }

    public Coordinates getUpperRightCoordinates() {
        return upperRightCoordinates;
    }

    public static class Builder {
        private static final Coordinates DEFAULT_LOWER_LEFT_COORDINATES = Coordinates.builder().x(0).y(0).build();
        private Coordinates upperRightCoordinates;

        public Plateau.Builder upperRightCoordinates(final Coordinates upperRightCoordinates) {
            this.upperRightCoordinates = upperRightCoordinates;
            return this;
        }

        public Plateau build() {
            return new Plateau(DEFAULT_LOWER_LEFT_COORDINATES, upperRightCoordinates);
        }
    }
}
