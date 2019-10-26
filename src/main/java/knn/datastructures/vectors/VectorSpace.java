package knn.datastructures.vectors;

import knn.datastructures.exceptions.InvalidVectorOperation;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparingDouble;

public class VectorSpace
{
    private final Stream<ImmutablePair<Integer, IntegerVector>> vectors;

    public VectorSpace(List<IntegerVector> vectors) {

        this.vectors = IntStream.range(0, vectors.size()).mapToObj(i -> new ImmutablePair<>(i, vectors.get(i)));
    }

    public int findClosestTo(IntegerVector vectorToTest) {
        return vectors
                .min(comparingDouble(v -> distanceBetween(vectorToTest, v)))
                .filter(f -> f.getValue().length() == vectorToTest.length())
                .map(Pair::getKey) // get the index of the vector with the minimum distance
                .orElse(-1);
    }

    private Double distanceBetween(IntegerVector toTest, ImmutablePair<Integer, IntegerVector> current) {
        try {
            return current.getValue().distanceTo(toTest);
        } catch (InvalidVectorOperation invalidVectorOperation) {
            return Double.MAX_VALUE;
        }
    }

}
