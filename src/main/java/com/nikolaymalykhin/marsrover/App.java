package com.nikolaymalykhin.marsrover;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class App implements CommandLineRunner {
    public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
        SpringApplication.run(App.class, args);
        log.info("APPLICATION FINISHED");
    }

    /**
     * This method will be executed after the application context is loaded and
     * right before the Spring Application main method is completed.
     */
    @Override
    public void run(String... args)  {
        log.info("EXECUTING : command line runner");
        for (int i = 0; i < args.length; ++i) {
            log.info("args[{}]: {}", i, args[i]);
        }
    }
}
