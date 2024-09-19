import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/*
Calculator Class
@author hxa.dev
 */
public class CalculatorTest {



    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(10, 3);
        assertEquals(7, result);
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(4, 5);
        assertEquals(20, result);
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        double result = calculator.divide(15, 3);
        assertEquals(5.0, result);
    }

    @Test
    public void testDivideByZero() {
        Calculator calculator = new Calculator();
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }
}