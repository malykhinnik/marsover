package com.nikolaymalykhin.marsrover;

import com.nikolaymalykhin.marsrover.models.Plateau;
import com.nikolaymalykhin.marsrover.models.Rover;
import com.nikolaymalykhin.marsrover.models.RoverPosition;
import com.nikolaymalykhin.marsrover.service.IPlateuService;
import com.nikolaymalykhin.marsrover.service.IRoverPositionService;
import com.nikolaymalykhin.marsrover.service.IRoverService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@Log4j2
@SpringBootApplication
public class App implements CommandLineRunner {
    final IPlateuService plateuService;
    final IRoverService roverService;
    final IRoverPositionService roverPositionService;

    public App(final IPlateuService plateuService, final IRoverService roverService, final IRoverPositionService roverPositionService) {
        this.plateuService = plateuService;
        this.roverService = roverService;
        this.roverPositionService = roverPositionService;
    }

    public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
        SpringApplication.run(App.class, args);
        log.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        processingInput(args);
    }

    public String processingInput(final String[] args) {
        Plateau plateau = plateuService.create(args);
        List<Rover> rovers = roverService.create(args);

        List<RoverPosition> roverPositions = new ArrayList<>();
        for (Rover rover : rovers) {
            roverPositions.add(roverPositionService.calc(plateau, rover));
        }

        StringJoiner response = new StringJoiner(" ");
        for (RoverPosition roverPosition : roverPositions) {
            response.add(roverPosition.getCurrentPositionAsString());
        }

        return response.toString();
    }
}
