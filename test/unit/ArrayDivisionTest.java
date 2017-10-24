package unit;

import convenience.Conveniencer;
import convenience.Dyad;
import convenience.LengthError;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayDivisionTest {
    Dyad<Double, Double, Double> divide = new Conveniencer().divide;

    @Test
    public void canDivideScalarByScalar() {
        assertThat(divide.one_to_one(4.0, 5.0), equalTo(0.8));
    }

    @Test
    public void canDivideScalarByVector() {
        assertThat(divide.one_to_many(5.0, new Double[]{2.0, 4.0, 5.0}), equalTo(new Double[]{2.5, 1.25, 1.0}));
    }

    @Test
    public void canDivideVectorByScalar() {
        assertThat(divide.many_to_one(new Double[]{0.0, 2.0, 6.0, 9.0, 4.0}, 8.0), equalTo(new Double[]{0.0, 0.25, 0.75, 1.125, 0.5}));
    }

    @Test
    public void canDivideVectorByVector() throws LengthError {
        assertThat(divide.many_to_many(new Double[]{0.0, 2.0, 6.0, 9.0, 4.0}, new Double[]{1.0, 2.0, 3.0, 4.0, 5.0}), equalTo(new Double[]{0.0, 1.0, 2.0, 2.25, 0.8}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        divide.many_to_many(new Double[]{0.0, 1.0, 2.0}, new Double[]{10.0, 11.0});
    }
}
