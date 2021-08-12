import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class StringExampleTest {
    @Test
    public void TestForCompareFirstAndLastCharacterAreSane(){
        StringExample se = new StringExample();
        boolean actualValue = se.compareFirstAndLastCharactersAreSane("ABAB");
        boolean expectedValue = true;
        assertEquals(expectedValue,actualValue);
        assertTrue(actualValue);
//        assertFalse(actualValue);
    }
}
