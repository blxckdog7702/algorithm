package mailProgamming;

import java.util.Arrays;

//정수 배열(int array)과 정수 N이 주어지면, N번째로 큰 배열 원소를 찾으시오.
//예제)
//Input: [-1, 3, -1, 5, 4], 2
//Output: 4
//
//Input: [2, 4, -2, -3, 8], 1
//Output: 8
//
//Input: [-5, -3, 1], 3
//Output: -5

public class Question13 {

	public static void main(String[] args) {
		int[] input = new int[] {-1,3,-1,5,4};
		int n = 2;
		System.out.println(solution(input, n));
	}

	private static int solution(int[] input, int n) {
		Arrays.sort(input);
		return input[(input.length - 1) - (n - 1)];
	}

}
