package util;

import com.ml.clustering.ClusteringTask;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class DataReader {
    public static InputStream readData(String path) throws UnsupportedEncodingException {
        return ClusteringTask.class.getClassLoader().getResourceAsStream(path);
    }
}
