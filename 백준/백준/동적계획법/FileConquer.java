package 백준.동적계획법;

import java.util.Scanner;

//11066번(파일합치기)

public class FileConquer {
	private static final int MAX = Integer.MAX_VALUE;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			int page = sc.nextInt();

			int[][] dp = new int[page + 1][page + 1];
			int[] novel = new int[page + 1];
			int[] sum = new int[page + 1];
			sum[0] = 0;

			for (int j = 1; j <= page; j++) {
				novel[j] = sc.nextInt();
				sum[j] = sum[j - 1] + novel[j];

				// 최소값을 구해야하니까 MAX로 초기화
				for (int k = 1; k <= page; k++) {
					dp[j][k] = MAX;
				}
			}

			System.out.println(solve(dp, novel, sum, 1, page));
			
			sc.close();
		}
	}

	private static int solve(int[][] dp, int[] novel, int[] sum, int start, int end) {

		// 자기 자신을 합치는 경우
		if (start >= end) {
			return 0;
		}

		// 근접한 경우는 둘이 더하면 됨
		if (end == start + 1) {
			return novel[start] + novel[end];
		}

		// 이미 값이 있으면 return
		if (dp[start][end] < MAX) {
			return dp[start][end];
		}

		for (int i = start; i < end; i++) {

			// Knuth Optimization ( dp[i][j] = min(dp[i][k] + dp[k+1][j]) + (i~j 수열의 합) )
			// 출처: http://stack07142.tistory.com/69 [Hello World]
			
			int temp = solve(dp, novel, sum, start, i) + solve(dp, novel, sum, i + 1, end) + sum[end] - sum[start - 1];

			dp[start][end] = Math.min(dp[start][end], temp);

		}

		return dp[start][end];
	}

}
