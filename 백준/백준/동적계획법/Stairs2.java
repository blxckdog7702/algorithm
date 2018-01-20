package 백준.동적계획법;

import java.util.Scanner;

//2579번(계단 오르기)

public class Stairs2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numberOfStairs = sc.nextInt();
		
		int[] stairs = new int[numberOfStairs + 1];
		
		//[i][0]은 i-1에서 올라온 경우, [i][1]은 i-2에서 올라온 경우.
		int[][] dp = new int[numberOfStairs + 1][2];
		
		for(int i = 1; i <= numberOfStairs; i++) {
			stairs[i] = sc.nextInt();
		}
		
		sc.close();
		
		dp[1][0] = dp[1][1] = stairs[1];
		
		for(int i = 2; i <= numberOfStairs; i++ ) {
			dp[i][0] = dp[i - 1][1] + stairs[i];
			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
		}
		
		System.out.println(Math.max(dp[numberOfStairs][0], dp[numberOfStairs][1]));
		
	}

}
