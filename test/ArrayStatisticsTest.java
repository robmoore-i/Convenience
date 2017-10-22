import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ArrayStatisticsTest {
    private Conveniencer c = new Conveniencer();
    private Double[] example = {3.0, 1.0, 4.0, 5.0, 15.0, 7.0, 11.0, 12.0};


    @Test
    public void canComputeMean() {
        assertThat(c.mean.one(example), equalTo(7.25));
    }

    @Test
    public void canComputeVariance() {
        assertThat(c.variance.one(example), equalTo(21.1875));
    }

    @Test
    public void canComputeStdDev() {
        assertEquals(4.602988, c.stdDev.one(example), 0.01);
    }

    @Test
    public void canComputeSkewness() {
        assertEquals(0.3316435, c.skewness.one(example), 0.01);
    }
}
