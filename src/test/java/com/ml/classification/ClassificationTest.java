package com.ml.classification;

import com.ml.classification.arranger.J48Arranger;
import com.ml.classification.arranger.ZeroRArranger;
import com.ml.classification.classifier.J48Classifier;
import com.ml.classification.classifier.ZeroRClassifier;
import org.junit.Test;
import weka.classifiers.rules.ZeroR;
import weka.classifiers.trees.J48;
import weka.core.Instances;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassificationTest {

    @Test
    public void testJ48() throws Exception {
        Instances data = DataReader.getInstances("data/zoo.arff");
        data = DataAssembler.assemble(data);
        J48 j48 = new J48Arranger().arrange(data);
        String result = new J48Classifier().classify(data, j48);
        assertThat(result).isEqualTo("mammal");
    }

    @Test
    public void testZeroR() throws Exception {
        Instances data = DataReader.getInstances("data/zoo.arff");
        data = DataAssembler.assemble(data);
        ZeroR zeroR = new ZeroRArranger().arrange(data);
        String result = new ZeroRClassifier().classify(data, zeroR);
        assertThat(result).isEqualTo("mammal");
    }
}
