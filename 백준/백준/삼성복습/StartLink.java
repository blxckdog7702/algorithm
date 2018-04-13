package 백준.삼성복습;

import java.util.Arrays;
import java.util.Scanner;

// 14889번(스타트와 링크)(복습)

public class StartLink {

	private static int result;
	private static int n;
	private static int[][] arr;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		in.close();

		boolean[] team = new boolean[n];
		result = Integer.MAX_VALUE;

		dfs(team, 0, 0);

		System.out.println(result);
	}

	private static void dfs(boolean[] team, int idx, int count) {
		// 조건 완료
		if (count == n / 2) {
//			System.out.println(Arrays.toString(team));
			result = Math.min(result, calc(team));
			return;
		}

		// 인덱스 초과
		if (idx >= n) {
			return;
		}

		team[idx] = true;
		dfs(team, idx + 1, count + 1);

		team[idx] = false;
		dfs(team, idx + 1, count);
	}

	private static int calc(boolean[] team) {
		int a = 0;
		int b = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}

				if (team[i] && team[j]) {
					a += arr[i][j];
					a += arr[j][i];
				} else if (!team[i] && !team[j]) {
					b += arr[i][j];
					b += arr[j][i];
				}

			}

		}

		return Math.abs(a - b) / 2;
	}

}
