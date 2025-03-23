package com.example.resume_parser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@Slf4j
public class ResumeParserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeParserApplication.class, args);
        log.info("RESUME-PARSER APPLICATION SUCCESSFULLY STARTED");
    }

}
