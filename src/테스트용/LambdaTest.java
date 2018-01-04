package 테스트용;

import java.util.Arrays;

public class LambdaTest {

	public static void main(String[] args) {
		String[] arr = new String[] {"one", "two", "three"};
		Arrays.sort(arr, (o1, o2) -> o2.compareTo(o1));
		System.out.println(Arrays.toString(arr));
	}

}
