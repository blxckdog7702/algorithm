package 백준.동적계획법;

import java.util.Scanner;

//9461번(파도반 수열)

public class Wave {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		long[] dp = new long[101];
		
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		
		for (int i = 0; i < tc; i++) {
			System.out.println(calc(dp, sc.nextInt()));
		}
		
		sc.close();
	}

	private static long calc(long[] dp, int n) {
		if(dp[n] == 0) {
			dp[n] = calc(dp, n - 5) + calc(dp, n - 1);
		}
		
		return dp[n];
	}

}
