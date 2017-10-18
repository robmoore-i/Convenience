import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayDropTest {
    private Conveniencer c = new Conveniencer();
    private Integer[] array = new Integer[]{1, 4, 9, 16, 25, 36, 49};

    @Test
    public void canDropN() {
        assertThat(c.drop(3, array), equalTo(new Integer[]{16, 25, 36, 49}));
    }

    @Test
    public void canDropNone() {
        assertThat(c.drop(0, array), equalTo(new Integer[]{1, 4, 9, 16, 25, 36, 49}));
    }

    @Test
    public void canDropWholeArray() {
        assertThat(c.drop(1, new Integer[]{1}), equalTo(new Integer[]{}));
    }

    @Test
    public void canDropNegativeN() {
        assertThat(c.drop(-3, array), equalTo(new Integer[]{1, 4, 9, 16}));
    }
}
