import Main.Conveniencer;
import Main.LengthError;
import Number.NumberConveniencer;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayEachBothTest {
    private NumberConveniencer c = new Conveniencer().number;

    @Test
    public void canPerformModuloEachBoth() throws LengthError {
        assertThat(c.dyad((left, right) -> left % right).eachBoth(new double[]{10, 11, 12}, new double[]{4, 5, 6}), equalTo(new double[]{2, 1, 0}));
    }
}
