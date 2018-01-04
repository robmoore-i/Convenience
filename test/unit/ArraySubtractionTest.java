package unit;

import convenience.Conveniencer;
import convenience.Dyad;
import convenience.LengthError;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArraySubtractionTest {
    private Dyad<Integer, Integer, Integer> minus = new Conveniencer().dyad((left, right) -> left - right);

    @Test
    public void canSubtractScalarFromScalar() {
        assertThat(minus.one_to_one(4, 5), equalTo(-1));
    }

    @Test
    public void canSubtractVectorFromScalar() {
        assertThat(minus.one_to_many(5, Arrays.stream(new Integer[]{3, 4, 5})).toArray(), equalTo(new Integer[]{2, 1, 0}));
    }

    @Test
    public void canSubtractScalarFromVector() {
        assertThat(minus.many_to_one(Arrays.stream(new Integer[]{0, 2, 6, 9, 4}), 3).toArray(), equalTo(new Integer[]{-3, -1, 3, 6, 1}));
    }

    @Test
    public void canSubtractVectorFromVector() throws LengthError {
        assertThat(minus.many_to_many(Arrays.stream(new Integer[]{0, 2, 6, 9, 4}), Arrays.stream(new Integer[]{1, 2, 3, 4, 5})).toArray(), equalTo(new Integer[]{-1, 0, 3, 5, -1}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        minus.many_to_many(Arrays.stream(new Integer[]{0, 1, 2}), Arrays.stream(new Integer[]{10, 11}));
    }
}
