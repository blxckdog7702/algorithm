package 백준.삼성;

import java.util.Scanner;

//14890번(경사로)

public class SlopeWay2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int l = in.nextInt();

		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		in.close();

		int result = 0;

		int i, j;

		for (i = 0; i < n; i++) {
			int count = 1;

			for (j = 0; j < n - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					count++;
				}
				// 올라가는 경우
				else if (arr[i][j] + 1 == arr[i][j + 1] && count >= l) {
					count = 1;
				}
				// 내려가는 경우
				else if (arr[i][j] - 1 == arr[i][j + 1] && count >= 0) {
					count = -l + 1;
				}
				// 그 외
				else {
					break;
				}
			}

			if (j == n - 1 && count >= 0) {
				result++;
			}
		}

		for (j = 0; j < n; j++) {
			int count = 1;

			for (i = 0; i < n - 1; i++) {
				if (arr[i][j] == arr[i + 1][j]) {
					count++;
				}
				// 올라가는 경우
				else if (arr[i][j] + 1 == arr[i + 1][j] && count >= l) {
					count = 1;
				}
				// 내려가는 경우
				else if (arr[i][j] - 1 == arr[i + 1][j] && count >= 0) {
					count = -l + 1;
				}
				// 2차이 또는 count가 범위를 벗어났을 경우
				else {
					break;
				}
			}

			if (i == n - 1 && count >= 0) {
				result++;
			}
		}
		
		System.out.println(result);
	}
}
