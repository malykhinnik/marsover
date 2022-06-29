package com.nikolaymalykhin.marsrover.service.impl;

import com.nikolaymalykhin.marsrover.models.Plateau;
import com.nikolaymalykhin.marsrover.models.Rover;
import com.nikolaymalykhin.marsrover.models.RoverPosition;
import com.nikolaymalykhin.marsrover.service.IRoverPositionService;
import org.springframework.stereotype.Service;

@Service
public class RoverPositionService implements IRoverPositionService {
    @Override
    public RoverPosition calc(final Plateau plateau, final Rover rover) {
        throw new UnsupportedOperationException();
    }
}
