import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayMultiplyTest {
    private Conveniencer c = new Conveniencer();

    @Test
    public void canTimesScalarByScalar() {
        assertThat(c.times.scalar_scalar(4, 5), equalTo(20.0));
    }

    @Test
    public void canTimesScalarByVector() {
        assertThat(c.times.scalar_vector(6, new double[]{3, 4, 5}), equalTo(new double[]{18, 24, 30}));
    }

    @Test
    public void canTimesVectorByScalar() {
        assertThat(c.times.vector_scalar(new double[]{0, 2, 6, 9, 4}, 9), equalTo(new double[]{0, 18, 54, 81, 36}));
    }

    @Test
    public void canTimesVectorByVector() throws LengthError {
        assertThat(c.times.vector_vector(new double[]{0, 2, 6, 9, 4}, new double[]{1, 2, 3, 4, 5}), equalTo(new double[]{0, 4, 18, 36, 20}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        c.times.vector_vector(new double[]{0, 1, 2}, new double[]{10, 11});
    }
}
