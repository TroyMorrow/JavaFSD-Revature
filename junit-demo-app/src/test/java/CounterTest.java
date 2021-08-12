import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CounterTest {
    Counter counter;

    @BeforeEach
    public void setup(){
        System.out.println("Before test");
        counter = new Counter();
    }
    @Test
    public void testForCounterIncrement(){
        System.out.println("increment test");
        int countValue = counter.increment();
        assertEquals(countValue,1);
    }
    @Test
    public void testForCounterDecrement(){
        System.out.println("decrement test");
        int countValue = counter.decrement();
        assertEquals(countValue,-1);
    }
    @AfterEach
    public void tearDown(){
        System.out.println("after test");
        counter = null;
    }
}
