package mailProgamming;

import java.util.Arrays;

//정수로된 배열이 주어지면, 각 원소가 자신을 뺀 나머지 원소들의 곱셈이 되게하라.
//단, 나누기 사용 금지, O(n) 시간복잡도
//
//예제)
//input: [1, 2, 3, 4, 5]
//output: [120, 60, 40, 30, 24]

public class Question12 {

	public static void main(String[] args) {
		int[] input = new int[] { 1, 2, 3, 4, 5 };
		
		System.out.println(Arrays.toString(solution(input)));
	}

	public static int[] solution(int[] input) {
		int[] output = new int[input.length];
		
		int product = 1;
		int[] a1 = new int[input.length];
		for(int i = 0; i < input.length; i++) {
			a1[i] = product;
			product *= input[i];
		}
		
		product = 1;
		int[] a2 = new int[input.length];
		for(int i = input.length - 1; i >= 0; i--) {
			a2[i] = product;
			product *= input[i];
		}
		
		for(int i = 0; i < input.length; i++) {
			output[i] = a1[i] * a2[i];
		}
		
		return output;
	}
}
