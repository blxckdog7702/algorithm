package 백준.이항계수;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactorialTest {
	Factorial factoial = new Factorial();
	int[] arr = new int[50];

	@Test
	public void testFac() {
		assertEquals(120, Factorial.fac(arr, 5));
		assertEquals(3628800, Factorial.fac(arr, 10));
//		fail("Not yet implemented");
	}

}
