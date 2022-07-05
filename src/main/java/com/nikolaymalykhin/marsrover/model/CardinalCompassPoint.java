package com.nikolaymalykhin.marsrover.model;

public enum CardinalCompassPoint {
    N, E, S, W;

    public CardinalCompassPoint turnLeft() {
        int newOrdinal = this.ordinal() - 1;
        if (newOrdinal == -1) {
            return CardinalCompassPoint.values()[CardinalCompassPoint.values().length - 1];
        }
        return CardinalCompassPoint.values()[newOrdinal];
    }

    public CardinalCompassPoint turnRight() {
        int newOrdinal = this.ordinal() + 1;
        if (newOrdinal == CardinalCompassPoint.values().length) {
            return CardinalCompassPoint.values()[0];

        }
        return CardinalCompassPoint.values()[newOrdinal];
    }
}
