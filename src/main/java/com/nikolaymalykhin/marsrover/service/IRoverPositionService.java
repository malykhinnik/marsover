package com.nikolaymalykhin.marsrover.service;

import com.nikolaymalykhin.marsrover.models.Plateau;
import com.nikolaymalykhin.marsrover.models.Rover;
import com.nikolaymalykhin.marsrover.models.RoverPosition;

public interface IRoverPositionService {
    RoverPosition calc(Plateau plateau, Rover rover);
}
