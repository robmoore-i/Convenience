import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ConveniencerTest {
    private Conveniencer c = new Conveniencer();

    @Test
    public void canAddScalarToScalar() {
        assertEquals(9, c.add(4, 5));
    }

    @Test
    public void canAddScalarToVector() {
        assertThat(c.add(5, new int[]{3, 4, 5}), equalTo(new int[]{8, 9, 10}));
    }

    @Test
    public void canAddVectorToScalar() {
        assertThat(c.add(new int[]{0, 2, 6, 9, 4}, 9), equalTo(new int[]{9, 11, 15, 18, 13}));
    }

    @Test
    public void canAddVectorToVector() throws LengthError {
        assertThat(c.add(new int[]{0, 2, 6, 9, 4}, new int[]{1, 2, 3, 4, 5}), equalTo(new int[]{1, 4, 9, 13, 9}));
    }

    @Test(expected = LengthError.class)
    public void throwsLengthErrorIfVectorsNotSameLength() throws LengthError {
        c.add(new int[]{0, 1, 2}, new int[]{10, 11});
    }
}
