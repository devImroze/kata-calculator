import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFile {
    @Test
    public void emptyStringCase(){
        KataCalculator kataCalculator = new KataCalculator();
        assertEquals(0, kataCalculator.Add(""));
    }

}
