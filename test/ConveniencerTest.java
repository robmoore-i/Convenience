import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConveniencerTest {
    @Test
    public void canAddScalarToScalar() {
        Conveniencer c = new Conveniencer();
        assertEquals(9, c.add(4, 5));
    }
}
