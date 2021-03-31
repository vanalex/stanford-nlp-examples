package com.algebra;

import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import static com.algebra.MatrixProvider.getResultMatrix;
import static org.assertj.core.api.Assertions.assertThat;

public class MatrixMultiplicationTest {
    @Test
    public void testMatrixMultiplication(){
        MatrixProvider matrixProvider = new MatrixProvider();
        INDArray firstMatrix = Nd4j.create(matrixProvider.getFirstMatrix());
        INDArray secondMatrix = Nd4j.create(matrixProvider.getSecondMatrix());
        INDArray result = firstMatrix.mmul(secondMatrix);
        assertThat(result).isEqualTo(Nd4j.create(getResultMatrix()));
    }
}
