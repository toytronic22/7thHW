package simple;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

@Tag("simple")
public class SkippedTests {
    @Test
    @Disabled("Some reason")
    void test1() {
        fail();
    }

    @Test
    @Disabled("Some reason")
    void test2() {
        fail();
    }
}