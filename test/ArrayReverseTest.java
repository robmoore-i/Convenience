import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayReverseTest {
    private Monad<Object[], Object[]> reverse = new Conveniencer().reverse();

    @Test
    public void canReverseOneElement() {
        assertThat(reverse.onScalar(new Integer[]{1}), equalTo(new Integer[]{1}));
    }

    @Test
    public void canReverseAFewElements() {
        assertThat(reverse.onScalar(new Integer[]{1, 2, 3}), equalTo(new Integer[]{3, 2, 1}));
    }
}
