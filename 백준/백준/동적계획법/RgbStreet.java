package 백준.동적계획법;

import java.util.Scanner;

//1149번(RGB거리)

public class RgbStreet {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		int[][] cost = new int[tc][3];
		int[][] dp = new int[tc][3];

		for (int i = 0; i < tc; i++) {
			for (int j = 0; j < 3; j++) {
				cost[i][j] = sc.nextInt();
			}
		}

		// dp배열 1라인 초기화
		for (int j = 0; j < 3; j++) {
			dp[0][j] = cost[0][j];
		}

		for (int i = 1; i < tc; i++) {
			for (int j = 0; j < 3; j++) {
				// 빨강이면 초록과 파랑 중 작은 값을 담는다.
				if (j == 0) {
					dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][j];
				}
				// 마찬가지
				else if (j == 1) {
					dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][j];
				}
				// 마찬가지
				else {
					dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][j];
				}
			}
		}

		System.out.println(Math.min(dp[tc - 1][0], Math.min(dp[tc - 1][1], dp[tc - 1][2])));
	}

}
