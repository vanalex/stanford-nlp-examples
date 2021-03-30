package com.ml.classification;

import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

public class J48Classifier extends Classifier<J48>{

    @Override
    String classify(Instances instances, J48 j48) throws Exception {
        double[] vals = new double[instances.numAttributes()];
        vals[0] = 1.0; //hair {false, true}
        vals[1] = 0.0; //feathers {false, true}
        vals[2] = 0.0; //eggs {false, true}
        vals[3] = 1.0; //milk {false, true}
        vals[4] = 0.0; //airborne {false, true}
        vals[5] = 0.0; //aquatic {false, true}
        vals[6] = 0.0; //predator {false, true}
        vals[7] = 1.0; //toothed {false, true}
        vals[8] = 1.0; //backbone {false, true}
        vals[9] = 1.0; //breathes {false, true}
        vals[10] = 1.0; //venomous {false, true}
        vals[11] = 0.0; //fins {false, true}
        vals[12] = 4.0; //legs INTEGER [0,9]
        vals[13] = 1.0; //tail {false, true}
        vals[14] = 1.0; //domestic {false, true}
        vals[15] = 0.0; //catsize {false, true}

        Instance myUnicorn = new DenseInstance(1.0, vals);
        myUnicorn.setDataset(instances);

        double result = j48.classifyInstance(myUnicorn);
        System.out.println(instances.classAttribute().value((int) result));
        return instances.classAttribute().value((int) result);
    }
}
