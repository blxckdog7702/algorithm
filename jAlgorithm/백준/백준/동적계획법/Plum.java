package 백준.동적계획법;

import java.util.Scanner;

//2240번(자두나무)

public class Plum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		int w = in.nextInt();

		int[][] arr = new int[2][t + 1];

		for (int i = 1; i <= t; i++) {
			int input = in.nextInt();
			if (input == 1) {
				arr[0][i]++;
			} else {
				arr[1][i]++;
			}
		}

		//[나무번호][T초][움직인 횟수]
		int[][][] dp = new int[2][t + 1][w + 2];

		for (int i = 1; i <= t; i++) {
			for (int j = 1; j <= w + 1; j++) {
				if (arr[0][i] == 1) {
					//T의 경우는 이전 값을 사용하기 때문에 i - 1이 되고
					//W의 경우는 움직였다는 의미로 j - 1을 썼다.
					dp[0][i][j] = Math.max(dp[0][i - 1][j] + 1, dp[1][i - 1][j - 1] + 1);
					dp[1][i][j] = Math.max(dp[0][i - 1][j - 1], dp[1][i - 1][j]);
				} else if (arr[1][i] == 1) {
					dp[0][i][j] = Math.max(dp[0][i - 1][j], dp[1][i - 1][j - 1]);
					dp[1][i][j] = Math.max(dp[0][i - 1][j - 1] + 1, dp[1][i - 1][j] + 1);	
				}
			}
		}
		
		int max = 0;
		
		//t초 진행된 상태에서,각 나무에서 w번~0번 움직여서 받아낸 케이스 중 가장 큰 값을 출력
		for(int i = 1; i <= w + 1; i++) { 
			max = Math.max(max, dp[0][t][i]);
			max = Math.max(max, dp[1][t][i]);
		}
		
		System.out.println(max);
		in.close();
	}

}
