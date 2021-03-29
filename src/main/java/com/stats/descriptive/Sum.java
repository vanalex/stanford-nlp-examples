package com.stats.descriptive;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Sum<T> {

    private T[] values;
    private int begin;
    private int length;
    
    public double evaluate(final double[] values, final int begin, final int length) {
        return DoubleStream.of(Arrays.copyOfRange(values, begin, begin + length)).sum();
    }
}
