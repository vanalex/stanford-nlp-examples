package com.ml.classification.arranger;

import com.ml.classification.ClassifyArranger;
import weka.classifiers.rules.ZeroR;
import weka.core.Instances;

public class ZeroRArranger extends ClassifyArranger<ZeroR> {
    @Override
    public ZeroR arrange(Instances data) throws Exception {
        ZeroR tree = new ZeroR();
        String[] options = new String[1];
        options[0] = "-U";
        tree.setOptions(options);
        tree.buildClassifier(data);
        System.out.println(tree);
        return tree;
    }
}
