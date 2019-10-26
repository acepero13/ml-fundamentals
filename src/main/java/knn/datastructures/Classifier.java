package knn.datastructures;

import knn.datastructures.vectors.IntegerVector;
import knn.datastructures.vectors.VectorSpace;

import java.util.List;
import java.util.Optional;

public class Classifier {
    private final VectorSpace vectorSpace;
    private final List<String> labels;

    public Classifier(VectorSpace data, List<String> labels) {
        this.vectorSpace = data;
        this.labels = labels;
    }

    public Optional<String> classify(IntegerVector test) {
        int indexOfClosestVector = vectorSpace.findClosestTo(test);
        if (isInvalidIndex(indexOfClosestVector)) {
            return Optional.empty();
        }
        return Optional.of(labels.get(indexOfClosestVector));
    }

    private boolean isInvalidIndex(int indexOfClosestVector) {
        return indexOfClosestVector == -1 || indexOfClosestVector >= labels.size();
    }
}
