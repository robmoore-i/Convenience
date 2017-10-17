import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayEachTest {
    private Conveniencer c = new Conveniencer();

    @Test
    public void canSquareEachOfAList() {
        assertThat(c.monad(operand -> operand * operand, Double.class).each(new Double[]{3.0, 4.0, 5.0}), equalTo(new Double[]{9.0, 16.0, 25.0}));
    }
}
