package 백준.동적계획법;

import java.util.Arrays;
import java.util.Scanner;

//1912번(연속합)

public class ContinuousSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		int[] arr = new int[tc + 1];
		int[] dp = new int[tc + 1];

		for (int i = 1; i <= tc; i++) {
			arr[i] = sc.nextInt();
		}

		int max = -1000000000;

		for (int i = 1; i <= tc; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			if(dp[i] > max) {
				max = dp[i];
			}
		}

		System.out.println(Arrays.toString(dp));
		System.out.println(max);

		sc.close();
	}

}
