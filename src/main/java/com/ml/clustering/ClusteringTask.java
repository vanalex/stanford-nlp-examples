package com.ml.clustering;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class ClusteringTask {

    public static void main(String args[]) throws Exception{

        //load data
        InputStream is = ClusteringTask.class.getClassLoader().getResourceAsStream("data/bank-data.arff");
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        Instances data = new Instances(br);

        // new instance of clusterer
        EM model = new EM();
        // build the clusterer
        model.buildClusterer(data);
        System.out.println(model);

        double logLikelihood = ClusterEvaluation.crossValidateModel(model, data, 10, new Random(1));
        System.out.println(logLikelihood);


    }

}
