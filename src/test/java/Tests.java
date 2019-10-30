import org.junit.Test;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void testStandardConstructor() {
        Rational standard = new Rational();
        assertEquals("Standard constructor returns wrong numerator", 0, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 1, standard.getDenominator());
    }

    @Test
    public void testNotEmptyConstructor() {
        Rational standard = new Rational(1, 2);
        assertEquals("Standard constructor returns wrong numerator", 1, standard.getNumerator());
        assertEquals("Standard constructor returns wrong denominator", 2, standard.getDenominator());
    }

    @Test
    public void testDivisionZeroInConstructor() {
    	try {
    		Rational standard = new Rational(1, 0);
    		fail("Expected ArithmeticException");
    	} catch(ArithmeticException ex){
    		assertEquals("Wrong Assert", "division by zero !", ex.getMessage());
    	}
    }

    @Test
    public void testSetNumerator() {
        Rational standard = new Rational();
        standard.setNumerator(1);
        assertEquals("Standard constructor returns wrong numerator", 1, standard.getNumerator());
    }

    @Test
    public void testSetDenominator() {
        Rational standard = new Rational(1,1);
        standard.setDenominator(2);
        assertEquals("Standard constructor returns wrong denominator", 2, standard.getDenominator());
    }
}