package com.nikolaymalykhin.marsrover.service;

import com.nikolaymalykhin.marsrover.models.Rover;

import java.util.List;

public interface IRoverService {
    List<Rover> create(String[] args);
}
