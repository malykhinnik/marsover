package com.nikolaymalykhin.marsrover.model;

public enum CardinalCompassPoint {
    N(0), E(90), S(180), W(270);
    private final int degrees;

    CardinalCompassPoint(final int degrees) {
        this.degrees = degrees;
    }

    public CardinalCompassPoint addDegrees(int degrees) {
        while (degrees < 0) {
            degrees += 360;
        }

        int newDegrees = (this.degrees + degrees) % 360;
        for (CardinalCompassPoint cardinalCompassPoint : CardinalCompassPoint.values()) {
            if (cardinalCompassPoint.degrees == newDegrees) {
                return cardinalCompassPoint;
            }
        }

        throw new IllegalArgumentException("No CardinalCompassPoint with degrees" + newDegrees);
    }
}
