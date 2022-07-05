package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.exceptions.AppRunException;
import com.nikolaymalykhin.marsrover.model.CardinalCompassPoint;
import com.nikolaymalykhin.marsrover.model.Coordinates;
import com.nikolaymalykhin.marsrover.model.Instructions;
import com.nikolaymalykhin.marsrover.model.Plateau;
import com.nikolaymalykhin.marsrover.model.Position;
import com.nikolaymalykhin.marsrover.model.Rover;

import java.util.Arrays;
import java.util.StringJoiner;

public class App {
    public static void main(String[] args) {
        run(args);
    }

    public static String run(final String[] args) {
        if (args == null || args.length < 1) {
            throw new AppRunException();
        }

        final String[] arr = args[0].split(" ");
        checkArrLength(arr.length);

        final Plateau plateau = createPlateau(arr);
        final StringJoiner stringJoiner = new StringJoiner(" ");
        createRovers(arr, plateau, stringJoiner);
        return stringJoiner.toString();
    }

    private static void createRovers(final String[] arr, final Plateau plateau, final StringJoiner stringJoiner) {
        int chunk = 4;
        for (int i = 2; i < arr.length; i += chunk) {
            final String[] roverArr = Arrays.copyOfRange(arr, i, Math.min(arr.length, i + chunk));
            createRover(roverArr, plateau, stringJoiner);
        }
    }

    private static void createRover(final String[] arr, final Plateau plateau, final StringJoiner stringJoiner) {
        final Coordinates roverPositionCoordinates = Coordinates.builder().x(Integer.parseInt(arr[0])).y(Integer.parseInt(arr[1])).build();
        Position roverPosition =
                Position.builder().coordinates(roverPositionCoordinates).orientation(CardinalCompassPoint.valueOf(arr[2])).plateau(plateau)
                        .build();
        final Rover rover = Rover.builder().position(roverPosition).build();
        final Instructions roverInstructions = Instructions.builder().series(arr[3]).build();
        rover.move(roverInstructions);
        stringJoiner.add(rover.getPosition());
    }

    private static Plateau createPlateau(final String[] arr) {
        final Coordinates upperRightCoordinates = Coordinates.builder().x(Integer.parseInt(arr[0])).y(Integer.parseInt(arr[1])).build();
        final Plateau plateau = Plateau.builder().upperRightCoordinates(upperRightCoordinates).build();
        return plateau;
    }

    private static void checkArrLength(final int length) {
        if (length == 6 || (length - 6) % 4 == 0) {
            return;
        }

        throw new AppRunException();
    }
}
