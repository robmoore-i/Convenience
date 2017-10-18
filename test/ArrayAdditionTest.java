import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayAdditionTest {
    private Conveniencer c = new Conveniencer();

    @Test
    public void canAddScalarToScalar() {
        assertThat(c.add.scalar_scalar(4.0, 5.0), equalTo(9.0));
    }

    @Test
    public void canAddScalarToVector() {
        assertThat(c.add.scalar_vector(5.0, new Double[]{3.0, 4.0, 5.0}), equalTo(new Double[]{8.0, 9.0, 10.0}));
    }

    @Test
    public void canAddVectorToScalar() {
        assertThat(c.add.vector_scalar(new Double[]{0.0, 2.0, 6.0, 9.0, 4.0}, 9.0), equalTo(new Double[]{9.0, 11.0, 15.0, 18.0, 13.0}));
    }

    @Test
    public void canAddVectorToVector() throws LengthError {
        assertThat(c.add.vector_vector(new Double[]{0.0, 2.0, 6.0, 9.0, 4.0}, new Double[]{1.0, 2.0, 3.0, 4.0, 5.0}), equalTo(new Double[]{1.0, 4.0, 9.0, 13.0, 9.0}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        c.add.vector_vector(new Double[]{0.0, 1.0, 2.0}, new Double[]{10.0, 11.0});
    }
}
