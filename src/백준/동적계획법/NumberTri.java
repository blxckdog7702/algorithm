package 백준.동적계획법;

import java.util.Scanner;

//1932번(숫자삼각형)

public class NumberTri {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();

		int max = 0;

		int[][] tree = new int[height + 1][height + 1];
		int[][] dp = new int[height][height];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < i + 1; j++) {
				tree[i][j] = sc.nextInt();
			}
		}

		dp[0][0] = tree[0][0];

		for (int i = 1; i < height; i++) {
			for (int j = 0; j <= i; j++) {
				// 삼각형에서 왼쪽 변 케이스
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + tree[i][j];
				}
				// 삼각형에서 오른쪽 변 케이스
				else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + tree[i][j];
				}
				// 중간에 위치한 나머지 케이스
				else {
					// 중간 노드의 값은 둘 중 큰 것을 넣는다.
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tree[i][j];
				}

				// 마지막 라인일 때, max 비교
				if (i == height - 1) {
					if (max < dp[i][j]) {
						max = dp[i][j];
					}
				}
			}
		}

		System.out.println(max);
	}
}
