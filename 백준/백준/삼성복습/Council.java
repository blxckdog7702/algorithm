package 백준.삼성복습;

import java.util.Scanner;

//14501번(퇴사)(복습)

public class Council {

	private static int max;
	private static int n;
	private static int[][] arr;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			arr[i][0] = in.nextInt();
			arr[i][1] = in.nextInt();
		}

		in.close();

		max = 0;

		dfs(0, 0);
		
		System.out.println(max);
	}

	private static void dfs(int idx, int sum) {
		if (idx == n) {
			max = Math.max(max, sum);
			return;
		}

		if (idx + arr[idx][0] <= n) {
			// 이번에 상담한다.
			dfs(idx + arr[idx][0], sum + arr[idx][1]);
		}

		if(idx + 1 <= n) {
			// 이번에 안한다.
			dfs(idx + 1, sum);
		}
	}

}
