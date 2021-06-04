package com.nlp;

import com.nlp.pipeline.Pipeline;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.List;

public class NERExample {

    public static void main(String[] args) {
        StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

        String text = "Hey! My  name is  Krishnan and I have friend his name is Robert." +
                " We both are living in Berlin";

        CoreDocument coreDocument = new CoreDocument(text);

        stanfordCoreNLP.annotate(coreDocument);

        List<CoreLabel> coreLabels = coreDocument.tokens();

        coreLabels.forEach(coreLabel -> System.out.println(coreLabel.originalText() + " " + coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class)));
    }
}
