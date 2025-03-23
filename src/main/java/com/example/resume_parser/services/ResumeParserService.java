package com.example.resume_parser.services;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

public interface ResumeParserService {

    ModelMap dataParser(String data);
}
