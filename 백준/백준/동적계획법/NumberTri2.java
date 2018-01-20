package 백준.동적계획법;

import java.util.Arrays;
import java.util.Scanner;

//1932번(숫자삼각형)

public class NumberTri2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		int[][] arr = new int[size][size];
		int[][] dp = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		sc.close();

		dp[0][0] = arr[0][0];

		for (int i = 1; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				// 왼쪽 끝
				if (j == 0) {
					dp[i][j] = dp[i - 1][j];
				}
				// 오른쪽 끝
				else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1];
				}
				// 가운데 위치했을 때
				else {
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
				}

				dp[i][j] += arr[i][j];
			}
		}
		System.out.println(Arrays.stream(dp[size - 1]).max().getAsInt());
	}

}
