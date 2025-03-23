package com.example.resume_parser.services;


import com.example.resume_parser.util.StanFordNLPPipeLine;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Service
public class ResumeParserServiceImpl implements ResumeParserService {

    public ResponseEntity<String> resumeParser(byte[] data) {

        dataParser(new String(data));
        return null;
    }


    @Override
    public ModelMap dataParser(String data) {
        ModelMap model= new ModelMap();
        getCoreDocument(data).tokens();
       // model.addAllAttributes();
        return null;
    }

    private CoreDocument getCoreDocument(String value) {
        StanfordCoreNLP stanfordCoreNLP = StanFordNLPPipeLine.getStanfordCoreNLP();
        CoreDocument coreDocument = new CoreDocument(value);
        stanfordCoreNLP.annotate(coreDocument);
        return coreDocument;
    }
}
