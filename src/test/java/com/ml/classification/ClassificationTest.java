package com.ml.classification;

import org.junit.Test;
import weka.classifiers.trees.J48;
import weka.core.Instances;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassificationTest {

    @Test
    public void test() throws Exception {
        Instances data = DataReader.getInstances("data/zoo.arff");
        data = DataAssembler.assemble(data);
        J48 j48 = new J48Arranger().arrange(data);
        String result = new J48Classifier().classify(data, j48);
        assertThat(result).isEqualTo("mammal");
    }
}
