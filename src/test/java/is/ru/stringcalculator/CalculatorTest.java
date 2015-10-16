package is.ru.StringCalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.StringCalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testMultipleNumbersWithNewline(){
    	assertEquals(6, Calculator.add("1,2\n3"));
    }

    @Test
    public void testMultipleNumbersJustNewline(){
    	assertEquals(6, Calculator.add("1\n2\n3"));
    }

    @Test
    public void testMultipleDelimeters(){
    	assertEquals(6, Calculator.add("//:\n1:2:3"));
    }

    @Test
    public void testMultipleDelimeters2(){
    	assertEquals(6, Calculator.add("//;\n1;2;3"));
    }

    @Test
    public void testMultipleDelimeters3(){
    	assertEquals(6, Calculator.add("//\n\n1\n2\n3"));
    }

    @Test
    (expected=IllegalArgumentException.class)
        public void testNegNumber(){
        assertEquals("Negatives not allowed: -1", Calculator.add("-1,2"));
    }

   	@Test
    (expected=IllegalArgumentException.class)
    	public void testNegNumberS(){
    	assertEquals("Negatives not allowed: -2, -3", Calculator.add("1, -2, -3"));
    }

    @Test
    (expected=IllegalArgumentException.class)
    	public void testAllNegNumberS(){
    	assertEquals("Negatives not allowed: -1, -2, -3", Calculator.add("-1, -2, -3"));
    }

    @Test
    public void testOver1000(){
    	assertEquals(3, Calculator.add("3,1002"));
    }

    @Test
    public void testOver1000nr2(){
    	assertEquals(3, Calculator.add("1002,3"));
    }

    @Test
    public void test1000(){
    	assertEquals(2000, Calculator.add("1000,1000"));
    }

	@Test
    public void testOnlyOver1000(){
    	assertEquals(0, Calculator.add("1001,1002"));
    }


}