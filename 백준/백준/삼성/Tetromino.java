package 백준.삼성;

import java.util.Scanner;

//14500번(테트로미노)

public class Tetromino {
	private static int n;
	private static int m;
	private static int max;
	private static int[][] origin;
	private static int maxleng;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		m = in.nextInt();

		maxleng = 500;

		origin = new int[maxleng][maxleng];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				origin[i][j] = in.nextInt();
			}
		}
		in.close();

		max = 0;

		// for (int[] a : origin) {
		// System.out.println(Arrays.toString(a));
		// }
		//

		// int[][] result = turnToClockwise(origin);

		// for (int[] a : origin) {
		// System.out.println(Arrays.toString(a));
		// }
		//
		// System.out.println();
		//
		// turnToClockwise(origin);
		//
		// for (int[] a : origin) {
		// System.out.println(Arrays.toString(a));
		// }

		for (int i = 0; i < 4; i++) {
			turnToClockwise(origin);
			calc();
			turnToReverse(origin);
			calc();
			turnToReverse(origin);
		}

		System.out.println(max);
	}

	public static void calc() {
		for (int i = 0; i < maxleng; i++) {
			for (int j = 0; j < maxleng; j++) {
				if (j + 3 < maxleng) {
					int m1 = origin[i][j] + origin[i][j + 1] + origin[i][j + 2] + origin[i][j + 3];
					// System.out.println(m1);
					max = Math.max(max, m1);
				}

				if (i + 1 < maxleng && j + 1 < maxleng) {
					int m2 = origin[i][j] + origin[i][j + 1] + origin[i + 1][j] + origin[i + 1][j + 1];
					// System.out.println(m2);
					max = Math.max(max, m2);
				}

				if (i + 2 < maxleng && j + 1 < maxleng) {
					int m3 = origin[i][j] + origin[i + 1][j] + origin[i + 2][j] + origin[i + 2][j + 1];
					// System.out.println(m3);
					max = Math.max(max, m3);
				}

				if (i + 2 < maxleng && j + 1 < maxleng) {
					int m4 = origin[i][j] + origin[i + 1][j] + origin[i + 1][j + 1] + origin[i + 2][j + 1];
					// System.out.println(m4);
					max = Math.max(max, m4);
				}

				if (i + 1 < maxleng && j + 2 < maxleng) {
					int m5 = origin[i][j] + origin[i][j + 1] + origin[i][j + 2] + origin[i + 1][j + 1];
					// System.out.println(m5);
					max = Math.max(max, m5);
				}
			}
		}
	}

	public static void turnToClockwise(int[][] arr) {
		int[][] result = new int[maxleng][maxleng];

		for (int i = 0; i < maxleng; i++) {
			for (int j = 0; j < maxleng; j++) {
				result[i][j] = arr[(maxleng - 1) - j][i];
			}
		}

		origin = result;

		// for(int[] a : result) {
		// System.out.println(Arrays.toString(a));
		// }
	}

	public static void turnToReverse(int[][] arr) {
		int[][] result = new int[maxleng][maxleng];

		for (int i = 0; i < maxleng; i++) {
			for (int j = 0; j < maxleng; j++) {
				result[i][j] = arr[i][(maxleng - 1) - j];
			}
		}

		origin = result;
		// for(int[] a : result) {
		// System.out.println(Arrays.toString(a));
		// }
	}

}
