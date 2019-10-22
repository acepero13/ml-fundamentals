package knn.datastructures;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VectorSpaceTest {
    @Test
    public void findClosestPoint() {
        List<IntegerVector> vectors = new ArrayList<>();
        vectors.add(new IntegerVector(5, 5));
        vectors.add(new IntegerVector(10, 10));
        vectors.add(new IntegerVector(-5, -5));
        VectorSpace space = new VectorSpace(vectors);
        Assert.assertEquals(
                new ImmutablePair<Integer, IntegerVector>(0, new IntegerVector(5, 5)),
                space.findClosest(new IntegerVector(4, 4)));

    }

}