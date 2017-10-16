import Main.Conveniencer;
import Main.LengthError;
import Number.NumberConveniencer;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayDivisionTest {
    private NumberConveniencer c = new Conveniencer().number;

    @Test
    public void canDivideScalarByScalar() {
        assertThat(c.divide.scalar_scalar(4, 5), equalTo(0.8));
    }

    @Test
    public void canDivideScalarByVector() {
        assertThat(c.divide.scalar_vector(5, new double[]{2, 4, 5}), equalTo(new double[]{2.5, 1.25, 1}));
    }

    @Test
    public void canDivideVectorByScalar() {
        assertThat(c.divide.vector_scalar(new double[]{0, 2, 6, 9, 4}, 8), equalTo(new double[]{0.0, 0.25, 0.75, 1.125, 0.5}));
    }

    @Test
    public void canDivideVectorByVector() throws LengthError {
        assertThat(c.divide.vector_vector(new double[]{0, 2, 6, 9, 4}, new double[]{1, 2, 3, 4, 5}), equalTo(new double[]{0, 1, 2, 2.25, 0.8}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        c.divide.vector_vector(new double[]{0, 1, 2}, new double[]{10, 11});
    }
}
