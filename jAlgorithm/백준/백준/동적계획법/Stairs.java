package 백준.동적계획법;

import java.util.Scanner;

//2579번(계단 오르기)

public class Stairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfStairs = sc.nextInt();
		
		int[] stairs = new int[numOfStairs + 1];
		
		//[i][0]은 i-1에서 올라온 경우, [i][1]은 i-2에서 올라온 경우.
		int[][] dp = new int[numOfStairs + 1][2];
		
		for(int i = 1; i <= numOfStairs; i++) {
			stairs[i] = sc.nextInt();
		}
		
		sc.close();

		dp[1][0] = dp[1][1] = stairs[1];

		for(int i = 2; i <= numOfStairs; i++) {
			//i-1에서 올라온 경우는 3칸 연속이면 안되기 때문에 dp[i-1][1]과 현재 계단을 더해준다.
			dp[i][0] = dp[i - 1][1] + stairs[i];
			//i-2에서 올라온 경우는 3칸 연속이랑은 상관 없으므로 i-2의 1칸 경우와 2칸 경우 중 큰 것을 찾아 현재 계단과 더해준다.
			dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + stairs[i];
		}
		
		System.out.println(Math.max(dp[numOfStairs][0], dp[numOfStairs][1]));
	}

}
