import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class NumberTest {

    private PrimeNumberService service;

    @Test
    public void testPrimeNumber() {
        service = new PrimeNumberService("17");
        assertNotNull(service.getResult());
        assertTrue("17 is prime".equalsIgnoreCase(service.getResult()));
    }

    @Test
    public void testNonPrimeNumber() {
        service = new PrimeNumberService("999");
        assertNotNull(service.getResult());
        assertEquals("999 is not prime. It is divisible by 3", service.getResult());

    }

    @Test
    public void testNegativeNumbers() {
        service = new PrimeNumberService("-1");
        assertNotNull(service.getResult());
        assertEquals("-1 is not prime.", service.getResult());
    }

    @Test
    public void testString() {
        service = new PrimeNumberService("ABC");
        assertNotNull(service.getResult());
        assertEquals("ABC Is not a valid integer.", service.getResult());
    }

    @Test
    public  void testLongRangeNumber() {
        service = new PrimeNumberService("687654654643689");
        assertNotNull(service.getResult());
        assertEquals("687654654643689 Is not a valid integer.", service.getResult());
    }

    @Test
    public void testDecimalNumber() {
        service = new PrimeNumberService("2763.71");
        assertNotNull(service.getResult());
        assertEquals("2763.71 Is not a valid integer.", service.getResult());
    }

}