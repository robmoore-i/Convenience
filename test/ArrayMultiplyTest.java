import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayMultiplyTest {
    private Conveniencer c = new Conveniencer();

    @Test
    public void canTimesScalarByScalar() {
        assertThat(c.times(4, 5), equalTo(20.0));
    }

    @Test
    public void canTimesScalarByVector() {
        assertThat(c.times(5, new double[]{3, 4, 5}), equalTo(new double[]{15, 20, 25}));
    }

    @Test
    public void canTimesVectorByScalar() {
        assertThat(c.times(new double[]{0, 2, 6, 9, 4}, 9), equalTo(new double[]{0, 18, 54, 81, 36}));
    }

    @Test
    public void canTimesVectorByVector() throws LengthError {
        assertThat(c.times(new double[]{0, 2, 6, 9, 4}, new double[]{1, 2, 3, 4, 5}), equalTo(new double[]{0, 4, 18, 36, 20}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        c.times(new double[]{0, 1, 2}, new double[]{10, 11});
    }
}
