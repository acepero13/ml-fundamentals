package knn.datastructures.vectors;

import knn.datastructures.vectors.IntegerVector;
import knn.datastructures.vectors.VectorSpace;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VectorSpaceTest {

    private List<IntegerVector> vectors;

    @Before
    public void initVector(){
        vectors = new ArrayList<>();
        vectors.add(new IntegerVector(5, 5));
        vectors.add(new IntegerVector(10, 10));
        vectors.add(new IntegerVector(-5, -5));
    }

    @Test
    public void findClosestPoint() {
        VectorSpace space = new VectorSpace(vectors);
        Assert.assertEquals(
                0,
                space.findClosest(new IntegerVector(4, 4)));

    }

    @Test
    public void findClosestPointAnotherTestPoint() {
        VectorSpace space = new VectorSpace(vectors);
        Assert.assertEquals(
                1,
                space.findClosest(new IntegerVector(9, 8)));

    }

    @Test
    public void returnsMinusOneWhenTryingWithInvalidVector(){
        VectorSpace space = new VectorSpace(vectors);
        Assert.assertEquals(
                -1,
                space.findClosest(new IntegerVector(4, 4, 5)));

    }



}