package com.ml.classification;

import weka.classifiers.trees.J48;
import weka.core.Instances;

public class J48Arranger extends ClassifyArranger<J48> {
    @Override
    public J48 arrange(Instances data) throws Exception {
        J48 tree = new J48();
        String[] options = new String[1];
        options[0] = "-U";
        tree.setOptions(options);
        tree.buildClassifier(data);
        System.out.println(tree);
        return tree;
    }
}
