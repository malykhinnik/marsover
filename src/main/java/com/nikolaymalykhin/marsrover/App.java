package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.model.CardinalCompassPoint;
import com.nikolaymalykhin.marsrover.model.Coordinates;
import com.nikolaymalykhin.marsrover.model.Instructions;
import com.nikolaymalykhin.marsrover.model.Plateau;
import com.nikolaymalykhin.marsrover.model.Position;
import com.nikolaymalykhin.marsrover.model.Rover;

public class App {
    public static void main(String[] args) {

    }

    public String run(final String[] args) {
        String[] upperRightCoordinates = args[0].split(" ");
        String[] rover1Position = args[1].split(" ");
        String[] rover2Position = args[3].split(" ");

        Plateau plateau = Plateau.builder()
                .upperRightCoordinates(
                        Coordinates.builder()
                                .x(Integer.parseInt(upperRightCoordinates[0]))
                                .y(Integer.parseInt(upperRightCoordinates[1]))
                                .build())
                .build();

        Rover rover1 = Rover.builder()
                .position(Position.builder()
                        .coordinates(Coordinates.builder()
                                .x(Integer.parseInt(rover1Position[0]))
                                .y(Integer.parseInt(rover1Position[1]))
                                .build())
                        .orientation(CardinalCompassPoint.valueOf(rover1Position[2]))
                        .build())
                .build();
        rover1.move(Instructions.builder().series(args[2]).build());

        Rover rover2 = Rover.builder()
                .position(Position.builder()
                        .coordinates(Coordinates.builder()
                                .x(Integer.parseInt(rover2Position[0]))
                                .y(Integer.parseInt(rover2Position[1]))
                                .build())
                        .orientation(CardinalCompassPoint.valueOf(rover2Position[2]))
                        .build())
                .build();
        rover2.move(Instructions.builder().series(args[4]).build());

        return rover1.getPosition() + " " + rover2.getPosition();
    }
}
