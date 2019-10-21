package knn.datastructures;

import knn.datastructures.exceptions.InvalidVectorOperation;
import org.junit.Assert;
import org.junit.Test;


public class IntegerVectorTest {

    private static final IntegerVector VECTOR_L2 = new IntegerVector(5, 5);

    @Test
    public void addTwoSameSizedVectors() throws InvalidVectorOperation {
        IntegerVector v2 = new IntegerVector(2, 1);
        Assert.assertEquals(new IntegerVector(7, 6), VECTOR_L2.plus(v2));
    }

    @Test
    public void vectorIsEqualsToItself() {
        Assert.assertEquals(VECTOR_L2, VECTOR_L2);
    }

    @Test
    public void vectorIsNotEqualToDifferentClassObject() {
        Assert.assertNotEquals(VECTOR_L2, 1);
    }

    @Test
    public void twoDifferentVectorsAreNotEqual() {
        Assert.assertNotEquals(VECTOR_L2, IntegerVector.INITIAL_VECTOR);
    }

    @Test
    public void computeDistanceBetweenTwoVectors() throws InvalidVectorOperation {
        Assert.assertEquals(7.07, VECTOR_L2.distanceTo(IntegerVector.INITIAL_VECTOR), 0.01);
    }

    @Test
    public void computeDistanceBetweenTwoVectorsLengthLongerThanTwo() throws InvalidVectorOperation {
        Assert.assertEquals(4, new IntegerVector(3, 3, 3, 3).distanceTo(new IntegerVector(1, 1, 1, 1)), 0.01);

    }

    @Test(expected = InvalidVectorOperation.class)
    public void tryToAddTwoVectorsWithDifferentLength() throws InvalidVectorOperation {
        VECTOR_L2.distanceTo(new IntegerVector(1, 2, 3));
    }

    @Test
    public void twoDifferentSizedVectorsAreNotEqual(){
        Assert.assertNotEquals(new IntegerVector(3, 3, 3, 3), new IntegerVector(3, 3, 3));
    }


}