package 백준.삼성복습;

import java.util.Scanner;

//14890번(경사로)(복습)

public class SlopeWay {

	private static int count;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int l = in.nextInt();

		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = in.nextInt();
			}
		}

		in.close();

		count = 0;

		int i, j;

		for (i = 0; i < n; i++) {
			// boolean check = true;
			int temp = 1;

			for (j = 0; j < n - 1; j++) {
				if (map[i][j] == map[i][j + 1]) {
					temp++;
				} else if (map[i][j] + 1 == map[i][j + 1] && temp >= l) {
					temp = 1;
				} else if (map[i][j] - 1 == map[i][j + 1] && temp >= 0) {
					temp = -l + 1;
				} else {
					break;
				}
			}

			if (j == n - 1 && temp >= 0) {
				count++;
			}

			// if(check) {
			// count++;
			// }
		}

		for (j = 0; j < n; j++) {
			// boolean check = true;
			int temp = 1;

			for (i = 0; i < n - 1; i++) {
				if (map[i][j] == map[i + 1][j]) {
					temp++;
				} else if (map[i][j] + 1 == map[i + 1][j] && temp >= l) {
					temp = 1;
				} else if (map[i][j] - 1 == map[i + 1][j] && temp >= 0) {
					temp = -l + 1;
				} else {
					break;
				}
			}

			if (i == n - 1 && temp >= 0) {
				count++;
			}

			// if(check) {
			// count++;
			// }
		}

		System.out.println(count);

	}

}
