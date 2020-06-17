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
        assertEquals(3, kataCalculator.Add("//;\\n1;&)&)!@#@#}{}{::><////;;;''']]]]2*(*_*_*_!@*#"));
    }

    @Test
    public void testWithNumberMoreThanThousand() {
        KataCalculator kataCalculator = new KataCalculator();
        assertEquals(3, kataCalculator.Add("//;\\n1;//1001//;;;''']]]]2(*))*!@^^&^)@!"));
    }

    @Test
    public void testWithNegativeNumber() {
        KataCalculator kataCalculator = new KataCalculator();
        try {
            kataCalculator.Add("-1;4");
        }
        catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed -1", e.getMessage());
        }
    }

    @Test
    public void testWithMultipleNegativeNumber() {
        KataCalculator kataCalculator = new KataCalculator();
        try {
            kataCalculator.Add("1;4----45*&^&---*%*-78--%^&%^&^&^][][][][]28");
        }
        catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed -45, -78", e.getMessage());
        }
    }

    @Test
    public void testYourData() {

        KataCalculator kataCalculator = new KataCalculator();

        //Test your data here:
        System.out.println("The sum is " +
                kataCalculator.Add("vuf58gU)}P}{&^F&D$YG(G)g8{M{}OG86r56dyvjYD^$U*"));
    }

}
