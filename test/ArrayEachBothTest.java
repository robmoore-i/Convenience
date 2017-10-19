import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayEachBothTest {
    private Conveniencer c = new Conveniencer();

    @Test
    public void canPerformModuloEachBoth() throws LengthError {
        Dyad<Integer, Integer, Integer> modulo = c.dyad((left, right) -> left % right);
        assertThat(modulo.each_both(new Integer[]{10, 11, 12}, new Integer[]{4, 5, 6}), equalTo(new Integer[]{2, 1, 0}));
    }
}
