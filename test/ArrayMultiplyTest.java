import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayMultiplyTest {
    private Dyad<Integer, Integer, Integer> times = new Conveniencer().dyad((left, right) -> left * right);

    @Test
    public void canTimesScalarByScalar() {
        assertThat(times.scalar_scalar(4, 5), equalTo(20));
    }

    @Test
    public void canTimesScalarByVector() {
        assertThat(times.scalar_vector(6, new Integer[]{3, 4, 5}), equalTo(new Integer[]{18, 24, 30}));
    }

    @Test
    public void canTimesVectorByScalar() {
        assertThat(times.vector_scalar(new Integer[]{0, 2, 6, 9, 4}, 9), equalTo(new Integer[]{0, 18, 54, 81, 36}));
    }

    @Test
    public void canTimesVectorByVector() throws LengthError {
        assertThat(times.vector_vector(new Integer[]{0, 2, 6, 9, 4}, new Integer[]{1, 2, 3, 4, 5}), equalTo(new Integer[]{0, 4, 18, 36, 20}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        times.vector_vector(new Integer[]{0, 1, 2}, new Integer[]{10, 11});
    }
}
