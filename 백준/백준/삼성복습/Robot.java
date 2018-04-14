package 백준.삼성복습;

import java.util.Scanner;

//14503(�κ�û�ұ�)(����)

public class Robot {

	private static int count;
	private static int[][] map;
	private static int[] moveY = new int[] { -1, 0, 1, 0 };
	private static int[] moveX = new int[] { 0, 1, 0, -1 };
	private static boolean[][] visit;
	private static int n;
	private static int m;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		m = in.nextInt();

		int r = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();

		map = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = in.nextInt();
			}
		}
		in.close();

		count = 0;

		clean(r, c, d);

		System.out.println(count);

	}

	private static void clean(int y, int x, int d) {
		if (!visit[y][x]) {
			count++;
			visit[y][x] = true;
		}

		int currentD = d;

		for (int i = 1; i <= 4; i++) {
			currentD = getNextDir(currentD);

			int nextY = y + moveY[currentD];
			int nextX = x + moveX[currentD];

			if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && map[nextY][nextX] == 0 && !visit[nextY][nextX]) {
				clean(nextY, nextX, currentD);
				return;
			}
		}

		int oppo = (d + 2) % 4;
		int oppoY = y + moveY[oppo];
		int oppoX = x + moveX[oppo];

		if (map[oppoY][oppoX] == 1) {
			return;
		} else {
			clean(oppoY, oppoX, d);
			return;
		}

	}

	private static int getNextDir(int d) {
		if (d > 0) {
			return d - 1;
		} else {
			return 3;
		}

	}

}
