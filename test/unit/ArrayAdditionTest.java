package unit;

import convenience.Conveniencer;
import convenience.Dyad;
import convenience.LengthError;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayAdditionTest {
    private Dyad<Double, Double, Double> add = new Conveniencer().add;

    @Test
    public void canAddScalarToScalar() {
        assertThat(add.one_to_one(4.0, 5.0), equalTo(9.0));
    }

    @Test
    public void canAddScalarToVector() {
        assertThat(add.one_to_many(5.0, Arrays.stream(new Double[]{3.0, 4.0, 5.0})).toArray(), equalTo(new Double[]{8.0, 9.0, 10.0}));
    }

    @Test
    public void canAddVectorToScalar() {
        assertThat(add.many_to_one(Arrays.stream(new Double[]{0.0, 2.0, 6.0, 9.0, 4.0}), 9.0).toArray(), equalTo(new Double[]{9.0, 11.0, 15.0, 18.0, 13.0}));
    }

    @Test
    public void canAddVectorToVector() throws LengthError {
        assertThat(add.many_to_many(Arrays.stream(new Double[]{0.0, 2.0, 6.0, 9.0, 4.0}), Arrays.stream(new Double[]{1.0, 2.0, 3.0, 4.0, 5.0})).toArray(), equalTo(new Double[]{1.0, 4.0, 9.0, 13.0, 9.0}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        add.many_to_many(Arrays.stream(new Double[]{0.0, 1.0, 2.0}), Arrays.stream(new Double[]{10.0, 11.0}));
    }
}
