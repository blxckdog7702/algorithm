package 백준.동적계획법;

import java.util.Scanner;

//2293번(동전 1)

public class Coin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		// 각 동전의 가격을 담아놓는 배열.
		int[] coins = new int[n];
		// dp[j]는 j원에 대한 경우의 수.
		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}

		dp[0] = 0;

		// 동전 종류별로 dp 배열을 한번씩 순회하면서 경우의 수를 늘려준다.
		// 예시의 경우대로면 dp[n] = dp[n-1] + dp[n-2] + dp[n-5]를 더해주는 것을 동전 종류별로 순회하는 것이다.
		
		// 경우의 수를 추가하는 공식은,
		// 1. (현재 동전 값 > 구하려는 값) 경우의 수가 늘어나지 않기 때문에 기존 값을 유지한다.
		// 2. (현재 동전 값 <= 구하려는 값) dp[구하려는 값] += dp[구하려는 값 - 현재 동전 값].
		for (int i = 0; i < n; i++) {
			// 시작점은 현재 동전부터 끝 값까지 하면 된다. (어차피 현재 동전보다 작은 값은 값이 그대로이므로)
			for (int j = coins[i]; j <= k; j++) {
				if (coins[i] == j) {
					dp[j] += 1;
				} else if (coins[i] > j) {
					dp[j] = dp[j - 1];
				} else {
					dp[j] += dp[j - coins[i]];
				}
			}
		}

		System.out.println(dp[k]);

		sc.close();
	}

}
