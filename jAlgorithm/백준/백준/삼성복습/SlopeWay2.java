package 백준.삼성복습;

import java.util.Scanner;

//14890번(경사로)(실패)

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
			boolean check = true;
			boolean[] visit = new boolean[n];

			for (j = 0; j < n - 1; j++) {
				if (Math.abs(arr[i][j] - arr[i][j + 1]) == 2) {
					check = false;
					break;
				} else if (arr[i][j] + 1 == arr[i][j + 1]) {
					//배열 벗어남
					if(j - (l - 1) < 0) {
						check = false;
						break;
					}
					
					for (int k = j; k >= j - (l - 1); k--) {
						if (arr[i][j] != arr[i][k] || visit[k]) {
							check = false;
							break;
						}
					}

					if (check) {
						for (int k = j; k >= j - (l - 1); k--) {
							visit[k] = true;
						}
					}

				} else if (arr[i][j] - 1 == arr[i][j + 1]) {
					//배열 벗어남
					if(j + l >= n) {
						check = false;
						break;
					}
					
					for (int k = j + 1; k <= j + l; k++) {
						if (arr[i][j + 1] != arr[i][k] || visit[k]) {
							check = false;
							break;
						}
					}

					if (check) {
						for (int k = j + 1; k <= j + l; k++) {
							visit[k] = true;
						}
					}
				} else {
					continue;
				}
			}

			if (check) {
				result++;
			}
		}
		
		for (j = 0; j < n; j++) {
			boolean check = true;
			boolean[] visit = new boolean[n];

			for (i = 0; i < n - 1; i++) {
				if (Math.abs(arr[i][j] - arr[i + 1][j]) == 2) {
					check = false;
					break;
				} else if (arr[i][j] + 1 == arr[i + 1][j]) {
					//배열 벗어남
					if(i - (l - 1) < 0) {
						check = false;
						break;
					}
					
					for (int k = i; k >= i - (l - 1); k--) {
						if (arr[i][j] != arr[k][j] || visit[k]) {
							check = false;
							break;
						}
					}

					if (check) {
						for (int k = i; k >= i - (l - 1); k--) {
							visit[k] = true;
						}
					}

				} else if (arr[i][j] - 1 == arr[i + 1][j]) {
					//배열 벗어남
					if(i + l >= n) {
						check = false;
						break;
					}
					
					for (int k = i + 1; k <= i + l; k++) {
						if (arr[i + 1][j] != arr[k][j] || visit[k]) {
							check = false;
							break;
						}
					}

					if (check) {
						for (int k = i + 1; k <= i + l; k++) {
							visit[k] = true;
						}
					}
				} else {
					continue;
				}
			}

			if (check) {
				result++;
			}
		}

		System.out.println(result);
	}

}
