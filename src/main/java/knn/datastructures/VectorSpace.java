package knn.datastructures;

import knn.datastructures.exceptions.InvalidVectorOperation;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingDouble;

public class VectorSpace
{
    private final List<IntegerVector> vectors;

    public VectorSpace(List<IntegerVector> vectors) {
        this.vectors = vectors;
    }

    ImmutablePair<Integer, IntegerVector> findClosest(IntegerVector vector) {
        int minimum = IntStream.range(0, vectors.size())
                .mapToObj(distance(vector))
                .min(comparingDouble(ImmutablePair::getValue))
                .map(ImmutablePair::getKey)
                .orElse(-1);
        ;
        return new ImmutablePair<>(minimum, vectors.get(minimum));

    }

    private IntFunction<ImmutablePair<Integer, Double>> distance(IntegerVector vector) {
        return i -> {
            try {
                return new ImmutablePair<>(i, vectors.get(i).distanceTo(vector));
            } catch (InvalidVectorOperation invalidVectorOperation) {
                return new ImmutablePair<>(-1, Double.MAX_VALUE);
            }
        };
    }
}
