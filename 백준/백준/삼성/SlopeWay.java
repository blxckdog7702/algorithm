package 백준.삼성;

import java.util.Arrays;
import java.util.Scanner;

//14890번(경사로)(실패)

public class SlopeWay {
	private static int n;
	private static int l;
	private static int[][] arr;
	private static int count;
	private static boolean[][] visit;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		l = in.nextInt();

		arr = new int[n][n];
		visit = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = in.nextInt();
			}
		}

		in.close();

		count = 0;

		checkHori(arr);

		for (int i = 0; i < n; i++) {
			Arrays.fill(visit[i], false);
		}

		checkVerti(arr);

		System.out.println(count);

	}

	private static void checkVerti(int[][] arr) {
		for (int j = 0; j < n; j++) {
			boolean check = true;

			for (int i = 0; i < n - 1; i++) {
				if (Math.abs(arr[i][j] - arr[i + 1][j]) == 2) {
					check = false;
					break;
				}

				// 큰거 만났을 때
				if (arr[i][j] < arr[i + 1][j]) {
					if (i - (l - 1) < 0) {
						check = false;
						break;
					}

					for (int k = i; k >= i - (l - 1); k--) {
						if (arr[i][j] != arr[k][j]) {
							check = false;
							break;
						}

						if (visit[k][j]) {
							check = false;
							break;
						}
					}

					// 경사로 조건 모두 만족시 방문처리
					if (check) {
						for (int k = i; k >= i - (l - 1); k--) {
							visit[k][j] = true;
						}
					}
				}
				// 작은거 만났을때
				else if (arr[i][j] > arr[i + 1][j]) {
					if (i + l >= n) {
						check = false;
						break;
					}

					for (int k = i + 1; k <= i + l; k++) {
						if (arr[i + 1][j] != arr[k][j]) {
							check = false;
							break;
						}

						if (visit[k][j]) {
							check = false;
							break;
						}
					}

					// 경사로 조건 모두 만족시 방문처리
					if (check) {
						for (int k = i + 1; k <= i + l; k++) {
							visit[k][j] = true;
						}
					}

				} else {
					continue;
				}
			}

			if (check)

			{
				// System.out.println("세로 : " + j);
				count++;
			}

		}
	}

	private static void checkHori(int[][] arr) {
		for (int i = 0; i < n; i++) {
			boolean check = true;

			for (int j = 0; j < n - 1; j++) {
				if (Math.abs(arr[i][j] - arr[i][j + 1]) == 2) {
					check = false;
					break;
				}

				// 큰거 만났을 때
				if (arr[i][j] < arr[i][j + 1]) {
					if (j - (l - 1) < 0) {
						check = false;
						break;
					}

					for (int k = j; k >= j - (l - 1); k--) {
						if (arr[i][j] != arr[i][k]) {
							check = false;
							break;
						}

						if (visit[i][k]) {
							check = false;
							break;
						}
					}

					// 경사로 조건 모두 만족시 방문처리
					if (check) {
						for (int k = j; k >= j - (l - 1); k--) {
							visit[i][k] = true;
						}
					}

				}
				// 작은거 만났을때
				else if (arr[i][j] > arr[i][j + 1]) {
					if (j + l >= n) {
						check = false;
						break;
					}

					for (int k = j + 1; k <= j + l; k++) {
						if (arr[i][j + 1] != arr[i][k]) {
							check = false;
							break;
						}

						if (visit[i][k]) {
							check = false;
							break;
						}
					}

					// 경사로 조건 모두 만족시 방문처리
					if (check) {
						for (int k = j + 1; k <= j + l; k++) {
							visit[i][k] = true;
						}
					}

				} else {
					continue;
				}
			}

			if (check) {
				// System.out.println("가로 : " + i);
				count++;
			}

		}
	}
}
