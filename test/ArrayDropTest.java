import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayDropTest {
    private Dyad<Integer, Object[], Object[]> drop = new Conveniencer().drop();
    private Integer[] array = new Integer[]{1, 4, 9, 16, 25, 36, 49};

    @Test
    public void canDropN() {
        assertThat(drop.scalar_scalar(3, array), equalTo(new Integer[]{16, 25, 36, 49}));
    }

    @Test
    public void canDropNone() {
        assertThat(drop.scalar_scalar(0, array), equalTo(new Integer[]{1, 4, 9, 16, 25, 36, 49}));
    }

    @Test
    public void canDropWholeArray() {
        assertThat(drop.scalar_scalar(1, new Integer[]{1}), equalTo(new Integer[]{}));
    }

    @Test
    public void canDropNegativeN() {
        assertThat(drop.scalar_scalar(-3, array), equalTo(new Integer[]{1, 4, 9, 16}));
    }
}
