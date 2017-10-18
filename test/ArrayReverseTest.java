import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayReverseTest {
    private Conveniencer c = new Conveniencer();

    @Test
    public void canReverseOneElement() {
        assertThat(c.reverse(new Integer[]{1}), equalTo(new Integer[]{1}));
    }

    @Test
    public void canReverseAFewElements() {
        assertThat(c.reverse(new Integer[]{1, 2, 3}), equalTo(new Integer[]{3, 2, 1}));
    }
}
