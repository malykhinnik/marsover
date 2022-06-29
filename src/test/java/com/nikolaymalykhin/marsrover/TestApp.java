package com.nikolaymalykhin.marsrover;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApp {
    private final App app;

    @Autowired
    public TestApp(final App app) {
        this.app = app;
    }

    @Test
    void testAppRun() {
        app.run();
    }
}
