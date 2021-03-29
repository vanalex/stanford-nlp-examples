package com.stats;

import org.junit.Assert;
import org.junit.Test;

public class StatUtilsTest {

    @Test
    public void testArrayIndexConditions() {
        double[] values = {1.0, 2.0, 3.0, 4.0};

        Assert.assertEquals(
                "Sum not expected",
                5.0,
                StatUtils.sum(values, 1, 2),
                Double.MIN_VALUE);

        Assert.assertEquals(
                "Sum not expected",
                3.0,
                StatUtils.sum(values, 0, 2),
                Double.MIN_VALUE);
        Assert.assertEquals(
                "Sum not expected",
                7.0,
                StatUtils.sum(values, 2, 2),
                Double.MIN_VALUE);
    }
}
