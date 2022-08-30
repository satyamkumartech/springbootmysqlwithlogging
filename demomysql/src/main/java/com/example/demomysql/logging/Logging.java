package com.example.demomysql.logging;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Logging {
    private static final Logger logger = LoggerFactory.getLogger(Logging.class);
    public static void main(String[] args) {
        SpringApplication.run(Logging.class, args);
        logger.info("This is a info message");
    }
}
