package com.example.resume_parser.util;

import edu.stanford.nlp.pipeline.*;

import java.util.Properties;

public class StanFordNLPPipeLine {

    private static final Properties properties;
    private static StanfordCoreNLP STANFORD_NLP_PIPELINE = null;

    private StanFordNLPPipeLine() {

    }

    static {
        properties = new Properties();
        String propertiesNameList = "tokenize, pos, ssplit";
        properties.setProperty("annotators", propertiesNameList);

    }

    public static StanfordCoreNLP getStanfordCoreNLP() {
        if (STANFORD_NLP_PIPELINE == null) {
            STANFORD_NLP_PIPELINE = new StanfordCoreNLP(properties);
        }
        return STANFORD_NLP_PIPELINE;
    }

}
