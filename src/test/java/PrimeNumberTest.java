import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PrimeNumberTest {

    private PrimeNumber primeNumber;

    @Test
    public void testPrimeNumber() {
        primeNumber = new PrimeNumber("17");
        assertNotNull(primeNumber.getResult());
        assertTrue("17 is prime".equalsIgnoreCase(primeNumber.getResult()));
    }

    @Test
    public void testNonPrimeNumber() {
        primeNumber = new PrimeNumber("999");
        assertNotNull(primeNumber.getResult());
        assertEquals("999 is not prime. It is divisible by 3", primeNumber.getResult());

    }

    @Test
    public void testNegativeNumbers() {
        primeNumber = new PrimeNumber("-1");
        assertNotNull(primeNumber.getResult());
        assertEquals(primeNumber.getNumber() + " is not prime.", primeNumber.getResult());
    }

    @Test
    public void testString() {
        primeNumber = new PrimeNumber("ABC");
        assertNotNull(primeNumber.getResult());
        assertEquals("Please enter valid integer.", primeNumber.getResult());
    }

    @Test
    public  void testLongRangeNumber() {
        primeNumber = new PrimeNumber("687654654643689");
        assertNotNull(primeNumber.getResult());
        assertEquals("Please enter valid integer.", primeNumber.getResult());
    }

    @Test
    public void testDecimalNumber() {
        primeNumber = new PrimeNumber("2763.71");
        assertNotNull(primeNumber.getResult());
        assertEquals("Please enter valid integer.", primeNumber.getResult());
    }

}