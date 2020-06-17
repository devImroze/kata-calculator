import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFile {
    @Test
    public void emptyStringCase() {
        KataCalculator kataCalculator = new KataCalculator();
        assertEquals(0, kataCalculator.Add(""));
    }

    @Test
    public void testWithTwoNumbers() {
        KataCalculator kataCalculator = new KataCalculator();
        assertEquals(5, kataCalculator.Add("2,3"));
    }

    @Test
    public void testWithMultipleNumbers() {
        KataCalculator kataCalculator = new KataCalculator();
        assertEquals(80, kataCalculator.Add("2,2,3, 8, 9,   56"));
    }

    @Test
    public void testWithSpecialDelimiters() {
        KataCalculator kataCalculator = new KataCalculator();
        assertEquals(6, kataCalculator.Add("1\\n2,3"));
    }

    @Test
    public void testWithDifferentDelimiterSupport() {
        KataCalculator kataCalculator = new KataCalculator();
        assertEquals(3, kataCalculator.Add("//;\\n1;2"));
    }

    @Test
    public void testWithMoreDelimiter() {
        KataCalculator kataCalculator = new KataCalculator();
        assertEquals(3, kataCalculator.Add("//;\\n1;kjheeqcmm////;;;''']]]]2jobeqbdqbbqq"));
    }

    @Test
    public void testWithNumberMoreThanThousand() {
        KataCalculator kataCalculator = new KataCalculator();
        assertEquals(3, kataCalculator.Add("//;\\n1;kjheeqcmm////;;;''']]]]2jobeqbdq1001bbqq"));
    }
}
