package 백준.동적계획법;

import java.util.Arrays;
import java.util.Scanner;

//1149번(RGB거리)

public class RgbStreet2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] cost = new int[n][3];
		int[][] dp = new int[n][3];

		// 각 집에 r,g,b 색상으로 칠했을 때 드는 비용 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				cost[i][j] = sc.nextInt();
			}
		}
		
		sc.close();

		for (int i = 0; i < 3; i++) {
			dp[0][i] = cost[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				// 빨간색을 칠하려는 경우 이전 누적치에서 초록, 파랑 중 낮은 값을 골라 더한다.
				if (j == 0) {
					dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]);
				}
				// 초록색을 칠하려는 경우
				else if (j == 1) {
					dp[i][j] = Math.min(dp[i - 1][0], dp[i - 1][2]);
				}
				// 파랑색을 칠하려는 경우
				else {
					dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][0]);
				}
				
				// 그리고 이번에 색깔을 칠하는 값도 추가해준다.
				dp[i][j] += cost[i][j];
			}
		}
		
		System.out.println(Arrays.stream(dp[n - 1]).min().getAsInt());
	}

}
