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
			int index = i - 1;
			
			// 왼쪽 끝
			dp[i][0] = dp[index][0] + arr[i][0];
			
			for (int j = 1; j < i; j++) {
				// 가운데 위치했을 때
				dp[i][j] = Math.max(dp[index][j - 1], dp[index][j]) + arr[i][j];
			}
			
			// 오른쪽 끝
			dp[i][i] = dp[index][index] + arr[i][i];

		}
		System.out.println(Arrays.stream(dp[size - 1]).max().getAsInt());
	}

}
