package com.ml.classification;

import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;
import weka.core.Instances;
import weka.core.Utils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class DataAssembler {

    public static Instances assemble(Instances data) throws Exception {
        setupTrainingData(data);
        featureSelection(data);
        return data;
    }

    private static Instances setupTrainingData(Instances data) throws Exception {
        Remove remove = new Remove();
        String[] opts = new String[] {"-R", "1"};
        remove.setOptions(opts);
        remove.setInputFormat(data);
        data = Filter.useFilter(data, remove);
        System.out.println(data.toString());
        return data;
    }

    private static void featureSelection(Instances data) throws Exception {
        InfoGainAttributeEval eval = new InfoGainAttributeEval();
        Ranker search = new Ranker();
        AttributeSelection attselect = new AttributeSelection();
        attselect.setEvaluator(eval);
        attselect.setSearch(search);
        attselect.SelectAttributes(data);

        int[] indices = attselect.selectedAttributes();
        System.out.println(Utils.arrayToString(indices));
    }
}
