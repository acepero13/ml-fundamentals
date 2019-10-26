package knn.datastructures;

import knn.datastructures.vectors.IntegerVector;
import knn.datastructures.vectors.VectorSpace;

import java.util.List;

public class Classifier {
    private final VectorSpace vectorSpace;
    private final List<String> labels;

    public Classifier(VectorSpace data, List<String> labels) {
        this.vectorSpace = data;
        this.labels = labels;
    }

    public String classify(IntegerVector test) throws Exception {
        int indexOfClosestVector = vectorSpace.findClosest(test);
        if (isInvalidIndex(indexOfClosestVector)) {
            throw new Exception("Could not classify element");
        }
        return labels.get(indexOfClosestVector);
    }

    private boolean isInvalidIndex(int indexOfClosestVector) {
        return indexOfClosestVector == -1 || indexOfClosestVector >= labels.size();
    }
}
