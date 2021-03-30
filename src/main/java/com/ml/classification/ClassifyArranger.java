package com.ml.classification;

import weka.classifiers.AbstractClassifier;
import weka.core.Instances;

public abstract class ClassifyArranger<A extends AbstractClassifier> {
    public abstract A arrange(Instances instances) throws Exception;
}
