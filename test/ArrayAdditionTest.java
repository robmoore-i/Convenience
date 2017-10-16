import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayAdditionTest {
    private NumberConveniencer c = new Conveniencer().number;

    @Test
    public void canAddScalarToScalar() {
        assertThat(c.add.scalar_scalar(4, 5), equalTo(9.0));
    }

    @Test
    public void canAddScalarToVector() {
        assertThat(c.add.scalar_vector(5, new double[]{3, 4, 5}), equalTo(new double[]{8, 9, 10}));
    }

    @Test
    public void canAddVectorToScalar() {
        assertThat(c.add.vector_scalar(new double[]{0, 2, 6, 9, 4}, 9), equalTo(new double[]{9, 11, 15, 18, 13}));
    }

    @Test
    public void canAddVectorToVector() throws LengthError {
        assertThat(c.add.vector_vector(new double[]{0, 2, 6, 9, 4}, new double[]{1, 2, 3, 4, 5}), equalTo(new double[]{1, 4, 9, 13, 9}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        c.add.vector_vector(new double[]{0, 1, 2}, new double[]{10, 11});
    }
}
