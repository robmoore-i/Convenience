import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayTakeTest {
    private Conveniencer c = new Conveniencer();
    private Integer[] array = new Integer[]{1, 4, 9, 16, 25, 36, 49};

    @Test
    public void canTakeN() {
        assertThat(c.take(3, array), equalTo(new Integer[]{1, 4, 9}));
    }

    @Test
    public void canTakeNGreaterThanArrayLength() {
        assertThat(c.take(10, array), equalTo(new Integer[]{1, 4, 9, 16, 25, 36, 49, 1, 4, 9}));
    }

    @Test
    public void canTakeNone() {
        assertThat(c.take(0, array), equalTo(new Integer[]{}));
    }

    @Test
    public void canTakeNFromSingletonArray() {
        assertThat(c.take(5, new Integer[]{1}), equalTo(new Integer[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void canTakeNegativeN() {
        assertThat(c.take(-3, array), equalTo(new Integer[]{25, 36, 49}));
    }

    @Test
    public void canTakeNegativeNGreaterThanArrayLength() {
        assertThat(c.take(-10, array), equalTo(new Integer[]{25, 36, 49, 1, 4, 9, 16, 25, 36, 49}));
    }
}
