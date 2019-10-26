package knn.datastructures;

import knn.datastructures.vectors.IntegerVector;
import knn.datastructures.vectors.VectorSpace;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClassificationTest {
    private final List<IntegerVector> data = new ArrayList<>();
    private final List<String> labels = new ArrayList<>();

    @Before
    public void initVector() {
        data.add(new IntegerVector(5, 5));
        data.add(new IntegerVector(10, 10));
        data.add(new IntegerVector(-5, -5));

        labels.add("Positive");
        labels.add("Positive");
        labels.add("Negative");
    }

    @Test
    public void classifyNewTestItem() {
        Classifier classifier = new Classifier(new VectorSpace(data), labels);
        Assert.assertEquals(
                "Positive",
                classifier.classify(new IntegerVector(4, 4)).orElse("Not classified"));

    }

    @Test
    public void cannotClassifyItemWhenTestVectorHasDifferentSize() {
        Classifier classifier = new Classifier(new VectorSpace(data), labels);
        Assert.assertEquals(
                "Not classified",
                classifier.classify(new IntegerVector(4, 4, 4)).orElse("Not classified"));
    }

}