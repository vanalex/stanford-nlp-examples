package com.stats;

import com.stats.descriptive.Sum;

public class StatUtils {

    private static final Sum SUM = new Sum();

    public static double sum(final double[] values, final int begin, final int length) {
        return SUM.evaluate(values, begin, length);
    }

}
