package duke.util;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class UiTest {

    @Test
    public void testSetBorder() {
        String expected = Ui.border + "\n\ttesting border\n\n" + Ui.border;
        assertEquals(expected, Ui.setBorder("testing border"));
    }
}
