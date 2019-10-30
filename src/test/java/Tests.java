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
        assertEquals("Not standard constructor returns wrong numerator", 1, standard.getNumerator());
        assertEquals("Not standard constructor returns wrong denominator", 2, standard.getDenominator());
    }

    @Test
    public void testDivisionZeroInConstructor() {
        try {
            Rational standard = new Rational(1, 0);
            fail("Expected ArithmeticException");
        } catch(ArithmeticException ex){
            assertEquals("Wrong message at assert in constructor", "division by zero !", ex.getMessage());
        }
    }

    @Test
    public void testSetNumerator() {
        Rational standard = new Rational();
        standard.setNumerator(1);
        assertEquals("Wrong set numerator", 1, standard.getNumerator());
    }

    @Test
    public void testSetDenominator() {
        Rational standard = new Rational(1,1);
        standard.setDenominator(2);
        assertEquals("Wrong set denominator", 2, standard.getDenominator());
    }

    @Test
    public void testSetZeroDenominator() {
        Rational standard = new Rational(1,1);
        try {
            standard.setDenominator(0);
            fail("Expected ArithmeticException");
        } catch(ArithmeticException ex){
            assertEquals("Wrong message at assert in set denominator", "division by zero !", ex.getMessage());
        }
    }

    @Test
    public void testToString() {
        Rational standard = new Rational(1,1);
        assertEquals("Wrong string transformation", "1/1", standard.toString());
    }

    @Test
    public void testPlus() {
        Rational standard1 = new Rational(1,1);
        Rational standard2 = new Rational(1,2);
        assertEquals("Wrong plus method", new Rational(3,2), standard1.plus(standard2));
    }

    @Test
    public void testMinus() {
        Rational standard1 = new Rational(1,1);
        Rational standard2 = new Rational(1,2);
        assertEquals("Wrong minus method", new Rational(1,2), standard1.minus(standard2));
    }

    @Test
    public void testMultiply() {
        Rational standard1 = new Rational(1,1);
        Rational standard2 = new Rational(1,2);
        assertEquals("Wrong multiply method", new Rational(1,2), standard1.multiply(standard2));
    }

    @Test
    public void testNotZeroDivide() {
        Rational standard1 = new Rational(1,1);
        Rational standard2 = new Rational(1,2);
        assertEquals("Wrong divide method", new Rational(2,1), standard1.divide(standard2));
    }

    @Test
    public void testZeroDivide() {
        Rational standard1 = new Rational(1,1);
        Rational standard2 = new Rational(0,1);
        try {
            standard1.divide(standard2);
            fail("Expected ArithmeticException");
        } catch(ArithmeticException ex){
            assertEquals("Wrong message at divide assert", "division by zero !", ex.getMessage());
        }
    }

    @Test
    public void testLessWhenEqualDenominator() {
        Rational standard1 = new Rational(2,1);
        Rational standard2 = new Rational(1,1);
        assertTrue("Wrong! Right number less then left number", standard2.less(standard1));
    }

    @Test
    public void testLessWhenEqualNumerator() {
        Rational standard1 = new Rational(1,1);
        Rational standard2 = new Rational(1,2);
        assertTrue("Wrong! Right number less then left number", standard2.less(standard1));
    }

    @Test
    public void testLessWhenNothingEqual() {
        Rational standard1 = new Rational(3,4);
        Rational standard2 = new Rational(1,2);
        assertFalse("Wrong! Right number less then left number", standard1.less(standard2));
    }

    @Test
    public void testSimplifyMinuses() {
        assertEquals("Wrong simplify minuses", new Rational(-1,2), new Rational(1,-2));
    }

    @Test
    public void testZeroReduce() {
        assertEquals("Wrong reduce zero", new Rational(0,1), new Rational(0,4));
    }

    @Test
    public void testReduce() {
        assertEquals("Wrong reduce", new Rational(1,2), new Rational(2,4));
    }

    @Test
    public void testEquals() {
        Rational standard1 = new Rational(1,2);
        Rational standard2 = new Rational(1,2);
        assertTrue("not Equal", standard1.equals(standard2));
    }

    @Test
    public void testEqualsWithNull() {
        Rational standard1 = new Rational(1,2);
        assertTrue("Equal with null", !standard1.equals(null));
    }

    @Test
    public void testEqualsWithNotRational() {
        Rational standard1 = new Rational(1,2);
        assertTrue("Equal with null", !standard1.equals("null"));
    }

    @Test
    public void testLessOrEqual() {
        Rational standard1 = new Rational(1,2);
        Rational standard2 = new Rational(1,2);
        assertTrue("not less or equal", standard1.lessOrEqual(standard2));
    }
}
