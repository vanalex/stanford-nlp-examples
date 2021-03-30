package com.ml.classification;

import com.ml.clustering.ClusteringTask;
import weka.core.Instances;

import java.io.*;

public class DataReader {

    public static Instances getInstances(String path) throws IOException {
        BufferedReader br = readData(path);
        Instances data = new Instances(br);
        System.out.println(data.numInstances()+ " instances loaded");
        System.out.println(data.toString());
        return data;
    }

    private static BufferedReader readData(String path) throws UnsupportedEncodingException {
        InputStream is = ClusteringTask.class.getClassLoader().getResourceAsStream(path);
        return new BufferedReader(new InputStreamReader(is, "UTF-8"));
    }
}
