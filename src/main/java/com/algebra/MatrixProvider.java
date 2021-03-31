package com.algebra;

public class MatrixProvider {
    private double [][] firstMatrix;
    private double [][] secondMatrix;
    private double [][] resultMatrix;

    public MatrixProvider() {
        firstMatrix =
                new double[][] {
                        new double[] {1d, 5d},
                        new double[] {2d, 3d},
                        new double[] {1d ,7d}
                };

        secondMatrix =
                new double[][] {
                        new double[] {1d, 2d, 3d, 7d},
                        new double[] {5d, 2d, 8d, 1d}
                };
    }

    public double[][] getFirstMatrix() {
        return firstMatrix;
    }

    public double[][] getSecondMatrix() {
        return secondMatrix;
    }

    public static double[][] getResultMatrix() {
        return new double[][] {
                new double[] {26d, 12d, 43d, 12d},
                new double[] {17d, 10d, 30d, 17d},
                new double[] {36d ,16d, 59d, 14d}
        };
    }
}
