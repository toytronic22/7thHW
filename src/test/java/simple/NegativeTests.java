package simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class NegativeTests {
    @Test
    @Disabled
    void test1() {
        assertTrue(true);
    }

    @Test
    @Disabled("Some reason")
    void test2() {
        assertTrue(true);
    }

    @Test
    @Disabled("Some reason")
    void test3() {
        assertTrue(true);
    }

    @Test
    @Disabled("Some reason")
    void test4() {
        assertTrue(true);
    }

    @Test
    @Disabled("Some reason")
    void test5() {
        assertTrue(true);
    }
}