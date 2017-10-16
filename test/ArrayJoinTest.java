import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayJoinTest {
    private StringConveniencer c = new Conveniencer().string;

    @Test
    public void canJoinTwoStrings() {
        assertThat(c.join.apply("hello, ", "conveniencer"), equalTo("hello, conveniencer"));
    }
}
