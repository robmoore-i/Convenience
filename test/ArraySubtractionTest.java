import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ArraySubtractionTest {
    private Conveniencer c = new Conveniencer();

    @Test
    public void canSubtractScalarFromScalar() {
        assertEquals(-1, c.minus(4, 5));
    }

    @Test
    public void canSubtractVectorFromScalar() {
        assertThat(c.minus(5, new int[]{3, 4, 5}), equalTo(new int[]{2, 1, 0}));
    }

    @Test
    public void canSubtractScalarFromVector() {
        assertThat(c.minus(new int[]{0, 2, 6, 9, 4}, 3), equalTo(new int[]{-3, -1, 3, 6, 1}));
    }

    @Test
    public void canSubtractVectorFromVector() throws LengthError {
        assertThat(c.minus(new int[]{0, 2, 6, 9, 4}, new int[]{1, 2, 3, 4, 5}), equalTo(new int[]{-1, 0, 3, 5, -1}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        c.minus(new int[]{0, 1, 2}, new int[]{10, 11});
    }
}
