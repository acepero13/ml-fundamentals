package knn.datastructures.exceptions;

import knn.datastructures.IntegerVector;

import java.util.Arrays;

public class InvalidVectorOperation extends Exception {

    public InvalidVectorOperation(String message, IntegerVector[] vectors) {
        super(message + " : " + Arrays.toString(vectors));
    }
}
