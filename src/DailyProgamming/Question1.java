package DailyProgamming;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		int[] dp = new int[tc];

		dp[0] = sc.nextInt();

		for (int i = 1; i < tc; i++) {
			int input = sc.nextInt();

			dp[i] = Math.max(dp[i - 1] + input, input);
		}

		System.out.println(dp[tc - 1]);

		sc.close();

	}

}
