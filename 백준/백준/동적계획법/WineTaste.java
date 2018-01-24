package 백준.동적계획법;

import java.util.Scanner;

//2156번(포도주 시식)

public class WineTaste {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n + 1];
		int[][] dp = new int[n + 1][2];
		
		for(int i = 1; i < n + 1; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		dp[1][0] = dp[1][1] = arr[1];
		
		for(int i = 2; i < n + 1; i++) {
			dp[i][0] = dp[i - 1][1] + arr[i];
			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + arr[i];
			
			//dp[i-1]이 dp[i] 보다 큰 경우가 있기 때문에 해준다.
			dp[i][0] = Math.max(dp[i - 1][0], dp[i][0]);
			dp[i][1] = Math.max(dp[i - 1][1], dp[i][1]);
		}
		
		System.out.println(Math.max(dp[n][0], dp[n][1]));
		
	}

}
