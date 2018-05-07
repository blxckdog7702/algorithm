package mailProgamming;

//정수 배열(int array)이 주어지면 두번째로 큰 값을 프린트하시오.

//예제)
//Input: [10, 5, 4, 3, -1]
//Output: 5
//
//Input: [3, 3, 3]
//Output: Does not exist.

public class Question8 {
	public static void main(String[] args) {
//		int[] input = new int[] { 10, 5, 4, 3, -1 };
		 int[] input = new int[] { 3, 3, 3 };

		System.out.println(solution(input));
	}

	private static String solution(int[] input) {
		if (input.length < 2) {
			return "Does not exist.";
		}
		
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;

		for (int i = 0; i < input.length; i++) {
			if (input[i] > first) {
				second = first;
				first = input[i];
			} else if (input[i] > second && input[i] != first) {
				second = input[i];
			}
		}

		if (second == Integer.MIN_VALUE) {
			return "Does not exist.";
		}

		return String.valueOf(second);
	}
}
