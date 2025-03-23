package com.example.resume_parser.controller;

import com.example.resume_parser.services.ResumeParserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping
@AllArgsConstructor
@Slf4j
public class ResumeParserController {

    private final ResumeParserServiceImpl impl;

    @PostMapping(value = "/upload")
    public ResponseEntity<String> parse(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        log.info("File= {} received ", file.getName());
        return impl.resumeParser(file.getBytes());
    }

}
