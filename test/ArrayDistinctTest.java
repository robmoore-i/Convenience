import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayDistinctTest {
    private Monad<Object[], Object[]> distinct = new Conveniencer().distinct();

    @Test
    public void doesntMessWithSingletonArray() {
        assertThat(distinct.one(new Integer[]{1}), equalTo(new Integer[]{1}));
    }

    @Test
    public void doesntMessWithDistinctArray() {
        assertThat(distinct.one(new Integer[]{1, 2, 3}), equalTo(new Integer[]{1, 2, 3}));
    }

    @Test
    public void canRemoveDuplicates() {
        assertThat(distinct.one(new Integer[]{3, 1, 2, 5, 2, 1, 3, 7, 7}), equalTo(new Integer[]{3, 1, 2, 5, 7}));
    }
}
