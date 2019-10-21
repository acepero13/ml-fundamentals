package knn.datastructures;

import knn.datastructures.exceptions.InvalidVectorOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class IntegerVector {

    private final List<Integer> components;
    static final IntegerVector INITIAL_VECTOR = new IntegerVector(0, 0);

    private static class OperationValidator {
        private final List<IntegerVector> vectors;

        private OperationValidator(IntegerVector... vectors) {
            this.vectors = Arrays.asList(vectors);
        }

        private static void validateFor(IntegerVector... vectors) throws InvalidVectorOperation {
            OperationValidator validator = new OperationValidator(vectors);
            if (!validator.isValid()) {
                throw new InvalidVectorOperation("Vectors have different sizes", vectors);
            }
        }

        private boolean isValid() {
            if (vectors.size() == 0) {
                return false;
            }
            IntegerVector initialVector = vectors.get(0);
            return vectors.stream().allMatch(v -> v.length() == initialVector.length());
        }

    }

    IntegerVector(Integer... components) {
        this.components = Arrays.asList(components);
    }

    private IntegerVector(List<Integer> components) {
        this.components = components;
    }

    IntegerVector plus(IntegerVector another) throws InvalidVectorOperation {
        OperationValidator.validateFor(this, another);
        return new IntegerVector(IntStream.range(0, components.size())
                .mapToObj(i -> components.get(i) + another.components.get(i))
                .collect(Collectors.toList()));


    }

    double distanceTo(IntegerVector another) throws InvalidVectorOperation {
        OperationValidator.validateFor(this, another);
        return Math.sqrt(IntStream.range(0, components.size())
                .mapToObj(i -> Math.pow(components.get(i) - another.components.get(i), 2))
                .reduce(0D, Double::sum));
    }

    int length() {
        return components.size();
    }


    @Override
    public boolean equals(Object another) {
        if (another == this) {
            return true;
        }
        if (!(another instanceof IntegerVector)) {
            return false;
        }

        IntegerVector anotherVector = ((IntegerVector) another);
        OperationValidator validator = new OperationValidator(this, anotherVector);
        if (!validator.isValid()) {
            return false;
        }

        return IntStream.range(0, components.size())
                .allMatch(i -> components.get(i).equals(anotherVector.components.get(i)));

    }

    @Override
    public String toString() {
        return components.toString();
    }

    @Override
    public int hashCode() {
        return 31 * components.hashCode();
    }


}
