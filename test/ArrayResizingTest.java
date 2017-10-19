import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayResizingTest {
    private Conveniencer c = new Conveniencer();

    @Test
    public void canGetFirst() {
        assertThat(c.first().onScalar(new Integer[]{5, 6, 7}), equalTo(5));
    }

    @Test
    public void canGetLast() {
        assertThat(c.last().onScalar(new Integer[]{5, 6, 7}), equalTo(7));
    }

    @Test
    public void canBehead() {
        assertThat(c.behead().onScalar(new Integer[]{5, 6, 7}), equalTo(new Integer[]{6, 7}));
    }

    @Test
    public void canCurtail() {
        assertThat(c.curtail().onScalar(new Integer[]{5, 6, 7}), equalTo(new Integer[]{5, 6}));
    }

    @Test
    public void canJoinArrays() {
        assertThat(c.join().scalar_scalar(new Integer[]{5, 6, 7}, new Integer[]{8, 9, 10}), equalTo(new Integer[]{5, 6, 7, 8, 9, 10}));
    }

    @Test
    public void canEnrrayAtom() {
        assertThat(c.enrray().onScalar(5), equalTo(new Integer[]{5}));
    }
}
