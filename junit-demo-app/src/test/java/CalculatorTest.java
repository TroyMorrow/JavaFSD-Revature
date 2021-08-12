import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {

    @Test
    public void addNumberTest(){
        //Arrange
        Calculator cal = new Calculator();
        //Act
        int actualResult = cal.addNumber(10,20);
        //Assert
        int expectedResult = 30;
        assertEquals(expectedResult,actualResult);
    }
    @Test
    public void testForFindMaxNumber(){
        Calculator cal = new Calculator();
        int actualResult = cal.findMaxNumber(new int[]{1,2,3});
        int expectedResult = 3;
        assertEquals(expectedResult,actualResult);

        int actualResult2 =  cal.findMaxNumber(new int[]{-12,-5,-7,-4,-1});
        int expectedResult2 = -1;

        assertEquals(expectedResult2,actualResult2);
    }
    @Test
    public void testForMultiplyTwoNumbers(){
        Calculator calculator = new Calculator();
        int result = calculator.multiplyTwoNumbers(20,30);
        assertEquals(600,result);
    }
}
