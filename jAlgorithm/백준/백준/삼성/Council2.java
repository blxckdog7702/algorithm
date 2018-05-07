package 백준.삼성;

import java.util.Scanner;

// 14501번(퇴사)

public class Council2 {

	private static int n;
	private static int[] days;
	private static int[] costs;
	private static int max;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		days = new int[n + 1];
		costs = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			days[i] = in.nextInt();
			costs[i] = in.nextInt();
		}

		in.close();
		max = 0;

		dfs(1, 0);

		System.out.println(max);
	}

	private static void dfs(int d, int sum) {
		if (d > n) {
			max = Math.max(max, sum);
			return;
		}

		// 오늘 한다면
		if (d + days[d] <= n + 1) {
			dfs(d + days[d], sum + costs[d]);
		}

		// 오늘 안한다면
		if (d + 1 <= n + 1) {
			dfs(d + 1, sum);
		}
	}

}
