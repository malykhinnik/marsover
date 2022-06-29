package com.nikolaymalykhin.marsrover.service.impl;

import com.nikolaymalykhin.marsrover.models.Rover;
import com.nikolaymalykhin.marsrover.service.IRoverService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoverService implements IRoverService {
    @Override
    public List<Rover> create(final String[] args) {
        throw new UnsupportedOperationException();
    }
}
