import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArraySubtractionTest {
    private NumericConveniencer c = new Conveniencer().numbers;

    @Test
    public void canSubtractScalarFromScalar() {
        assertThat(c.minus(4, 5), equalTo(-1.0));
    }

    @Test
    public void canSubtractVectorFromScalar() {
        assertThat(c.minus(5, new double[]{3, 4, 5}), equalTo(new double[]{2, 1, 0}));
    }

    @Test
    public void canSubtractScalarFromVector() {
        assertThat(c.minus(new double[]{0, 2, 6, 9, 4}, 3), equalTo(new double[]{-3, -1, 3, 6, 1}));
    }

    @Test
    public void canSubtractVectorFromVector() throws LengthError {
        assertThat(c.minus(new double[]{0, 2, 6, 9, 4}, new double[]{1, 2, 3, 4, 5}), equalTo(new double[]{-1, 0, 3, 5, -1}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        c.minus(new double[]{0, 1, 2}, new double[]{10, 11});
    }
}
