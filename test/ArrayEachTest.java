import Main.Conveniencer;
import Number.NumberConveniencer;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayEachTest {
    private NumberConveniencer c = new Conveniencer().number;

    @Test
    public void canSquareEachOfAList() {
        assertThat(c.monad(operand -> operand * operand).each(new double[]{3, 4, 5}), equalTo(new double[]{9.0, 16.0, 25.0}));
    }
}
