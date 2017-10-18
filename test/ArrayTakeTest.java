import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayTakeTest {
    Dyad<Integer, Object[], Object[]> take = new Conveniencer().take();
    private Integer[] array = new Integer[]{1, 4, 9, 16, 25, 36, 49};

    @Test
    public void canTakeN() {
        assertThat(take.scalar_scalar(3, array), equalTo(new Integer[]{1, 4, 9}));
    }

    @Test
    public void canTakeNGreaterThanArrayLength() {
        assertThat(take.scalar_scalar(10, array), equalTo(new Integer[]{1, 4, 9, 16, 25, 36, 49, 1, 4, 9}));
    }

    @Test
    public void canTakeNone() {
        assertThat(take.scalar_scalar(0, array), equalTo(new Integer[]{}));
    }

    @Test
    public void canTakeNFromSingletonArray() {
        assertThat(take.scalar_scalar(5, new Integer[]{1}), equalTo(new Integer[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void canTakeNegativeN() {
        assertThat(take.scalar_scalar(-3, array), equalTo(new Integer[]{25, 36, 49}));
    }

    @Test
    public void canTakeNegativeNGreaterThanArrayLength() {
        assertThat(take.scalar_scalar(-10, array), equalTo(new Integer[]{25, 36, 49, 1, 4, 9, 16, 25, 36, 49}));
    }
}
