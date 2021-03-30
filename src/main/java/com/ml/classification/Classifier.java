package com.ml.classification;

import weka.classifiers.AbstractClassifier;
import weka.core.Instances;

public abstract class Classifier<A extends AbstractClassifier> {
    abstract String classify(Instances instances, A a) throws Exception;
}