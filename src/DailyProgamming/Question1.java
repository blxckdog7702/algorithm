package DailyProgamming;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		int input = sc.nextInt();

		int currentSum = input;
		int maxSum = input;

		for (int i = 1; i < tc; i++) {
			input = sc.nextInt();
			
			currentSum = Math.max(currentSum + input, input);
			
			maxSum = Math.max(maxSum, currentSum);
			
//			dp[i] = Math.max(dp[i - 1] + input, input);
		}

//		System.out.println(dp[tc - 1]);
		System.out.println(maxSum);

		sc.close();

	}

}
