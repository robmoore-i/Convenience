import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayJoinTest {
    private StringConveniencer c = new Conveniencer().string;

    @Test
    public void canJoinTwoStrings() {
        assertThat(c.join.apply("hello, ", "conveniencer"), equalTo("hello, conveniencer"));
    }

    @Test
    public void canEachBothJoin() throws LengthError {
        assertThat(c.join.eachBoth(new String[]{"hello, ", "ayy ", "0"}, new String[]{"conveniencer", "lmao", "0"}), equalTo(new String[]{"hello, conveniencer", "ayy lmao", "00"}));
    }
}
