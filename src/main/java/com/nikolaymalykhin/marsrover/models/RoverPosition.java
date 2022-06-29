package com.nikolaymalykhin.marsrover.models;

import lombok.Data;

import javax.swing.text.Position;

@Data
public class RoverPosition {
    private Plateau plateau;
    private Rover rover;
    private Position currentPosition;

    public String getCurrentPositionAsString() {
        throw new UnsupportedOperationException();
    }
}
