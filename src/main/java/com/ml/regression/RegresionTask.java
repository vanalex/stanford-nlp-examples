package com.ml.regression;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.classifiers.trees.M5P;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.*;
import java.util.Random;

public class RegresionTask {
    public static void main(String args[]) {
        try {
            /*
             * Load data
             */
            Instances data = getInstances();

            // System.out.println(data);

            /*
             * Build regression models
             */
            // set class index to Y1 (heating load)
            data = setupTrainingData(data);

            // build a regression model
            LinearRegression model = buildModel(data);

            // 10-fold cross-validation
            Evaluation eval = evaluate(data, model);

            // build a regression tree model

            M5P md5 = setupClassifier(data);

            // 10-fold cross-validation
            validateModel(data, eval, md5);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void validateModel(Instances data, Evaluation eval, M5P md5) throws Exception {
        eval.crossValidateModel(md5, data, 10, new Random(1), new String[] {});
        System.out.println(eval.toSummaryString());
        System.out.println();
    }

    private static M5P setupClassifier(Instances data) throws Exception {
        M5P md5 = new M5P();
        md5.setOptions(new String[] { "" });
        md5.buildClassifier(data);
        System.out.println(md5);
        return md5;
    }

    private static Evaluation evaluate(Instances data, LinearRegression model) throws Exception {
        Evaluation eval = new Evaluation(data);
        eval.crossValidateModel(model, data, 10, new Random(1), new String[] {});
        System.out.println(eval.toSummaryString());
        double coef[] = model.coefficients();
        System.out.println();
        return eval;
    }

    private static LinearRegression buildModel(Instances data) throws Exception {
        LinearRegression model = new LinearRegression();
        model.buildClassifier(data);
        System.out.println(model);
        return model;
    }

    private static Instances setupTrainingData(Instances data) throws Exception {
        data.setClassIndex(data.numAttributes() - 2);
        // remove last attribute Y2
        Remove remove = new Remove();
        remove.setOptions(new String[] { "-R", data.numAttributes() + "" });
        remove.setInputFormat(data);
        data = Filter.useFilter(data, remove);
        return data;
    }

    private static Instances getInstances() throws IOException {
        CSVLoader loader = new CSVLoader();
        loader.setFieldSeparator(",");
        loader.setSource(readData());
        Instances data = loader.getDataSet();
        return data;
    }

    private static InputStream readData() {
        return RegresionTask.class.getClassLoader().getResourceAsStream("data/ENB2012_data.csv");
    }
}
