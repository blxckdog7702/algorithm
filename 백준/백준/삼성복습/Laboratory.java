package 백준.삼성복습;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//14502번(연구소)(복습)

public class Laboratory {

	private static int n;
	private static int m;
	private static int[][] map;
	private static List<Pos> emptyList;
	private static int max;
	private static int[] moveY = new int[] { 1, 0, -1, 0 };
	private static int[] moveX = new int[] { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		m = in.nextInt();

		map = new int[n][m];
		emptyList = new ArrayList<>();

		int input;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				input = in.nextInt();

				if (input == 0) {
					emptyList.add(new Pos(i, j));
				}

				map[i][j] = input;
			}
		}
		in.close();

		max = Integer.MIN_VALUE;

		dfs(0, 0);

		// System.out.println("뀨뀨");
		// for(int[] a : map) {
		// System.out.println(Arrays.toString(a));
		// }

		System.out.println(max);
	}

	private static void dfs(int idx, int count) {
		if (count == 3) {
			max = Math.max(max, calc(map));
			return;
		}

		if (idx >= emptyList.size()) {
			return;
		}

		Pos p = emptyList.get(idx);

		// 벽세우고
		map[p.getY()][p.getX()] = 1;
		dfs(idx + 1, count + 1);

		// 안세우고
		map[p.getY()][p.getX()] = 0;
		dfs(idx + 1, count);
	}

	private static int calc(int[][] map) {
		int count = 0;

		// Arrays.copyof 메서드
		int[][] temp = new int[n][];

		for (int i = 0; i < n; i++) {
			temp[i] = map[i].clone();
		}

		// for(int i = 0; i < n; i++) {
		// temp[i] = Arrays.copyOf(map[i], map[i].length);
		// }

		boolean[][] visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 2 && !visit[i][j]) {
					infest(temp, i, j, visit);
				}

			}
		}
		//
		// for(int[] t : temp) {
		// System.out.println(Arrays.toString(t));
		// }
		// System.out.println();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) {
					count++;
				}
			}
		}

		return count;
	}

	private static void infest(int[][] temp, int y, int x, boolean[][] visit) {
		visit[y][x] = true;
		temp[y][x] = 2;

		for (int i = 0; i < 4; i++) {
			int nextY = y + moveY[i];
			int nextX = x + moveX[i];

			if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && temp[nextY][nextX] == 0) {
				infest(temp, nextY, nextX, visit);
			}
		}
	}
}

class Pos {
	int y;
	int x;

	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}