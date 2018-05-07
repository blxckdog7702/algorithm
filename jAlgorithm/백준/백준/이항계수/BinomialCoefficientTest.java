package 백준.이항계수;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinomialCoefficientTest {
	BinomialCoefficient test = new BinomialCoefficient();
	
	@Test(timeout=1000)
	public void testCombination() {
		assertEquals(1, test.combination(1000, 1000));
		assertEquals(1, test.combination(1000, 0));
		assertEquals(1, test.combination(1, 1));
		assertEquals(1000, test.combination(1000, 1));
		assertEquals(10, test.combination(5, 3));
		assertEquals(10, test.combination(5, 2));
		assertEquals(5418, test.combination(1000, 500));
		assertEquals(5418, test.combination(4000000, 2000000));
	}

}
