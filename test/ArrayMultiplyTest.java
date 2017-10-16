import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ArrayMultiplyTest {
    private Conveniencer c = new Conveniencer();

    @Test
    public void canTimesScalarByScalar() {
        assertEquals(20, c.times(4, 5));
    }

    @Test
    public void canTimesScalarByVector() {
        assertThat(c.times(5, new int[]{3, 4, 5}), equalTo(new int[]{15, 20, 25}));
    }

    @Test
    public void canTimesVectorByScalar() {
        assertThat(c.times(new int[]{0, 2, 6, 9, 4}, 9), equalTo(new int[]{0, 18, 54, 81, 36}));
    }

    @Test
    public void canTimesVectorByVector() throws LengthError {
        assertThat(c.times(new int[]{0, 2, 6, 9, 4}, new int[]{1, 2, 3, 4, 5}), equalTo(new int[]{0, 4, 18, 36, 20}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        c.times(new int[]{0, 1, 2}, new int[]{10, 11});
    }
}
