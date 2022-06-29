package com.nikolaymalykhin.marsrover.service.impl;

import com.nikolaymalykhin.marsrover.models.Plateau;
import com.nikolaymalykhin.marsrover.service.IPlateuService;
import org.springframework.stereotype.Service;

@Service
public class PlateuService implements IPlateuService {
    @Override
    public Plateau create(final String[] args) {
        throw new UnsupportedOperationException();
    }
}
