package unit;

import convenience.Conveniencer;
import convenience.Dyad;
import convenience.LengthError;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayMultiplyTest {
    private Dyad<Integer, Integer, Integer> times = new Conveniencer().dyad((left, right) -> left * right);

    @Test
    public void canTimesScalarByScalar() {
        assertThat(times.one_to_one(4, 5), equalTo(20));
    }

    @Test
    public void canTimesScalarByVector() {
        assertThat(times.one_to_many(6, Arrays.stream(new Integer[]{3, 4, 5})).toArray(), equalTo(new Integer[]{18, 24, 30}));
    }

    @Test
    public void canTimesVectorByScalar() {
        assertThat(times.many_to_one(Arrays.stream(new Integer[]{0, 2, 6, 9, 4}), 9).toArray(), equalTo(new Integer[]{0, 18, 54, 81, 36}));
    }

    @Test
    public void canTimesVectorByVector() throws LengthError {
        assertThat(times.many_to_many(Arrays.stream(new Integer[]{0, 2, 6, 9, 4}), Arrays.stream(new Integer[]{1, 2, 3, 4, 5})).toArray(), equalTo(new Integer[]{0, 4, 18, 36, 20}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        times.many_to_many(Arrays.stream(new Integer[]{0, 1, 2}), Arrays.stream(new Integer[]{10, 11}));
    }
}
