package 백준.DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//2178번(미로탐색)

public class MazeDrive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Maze maze = new Maze();

		// 세로
		maze.n = sc.nextInt();
		// 가로
		maze.m = sc.nextInt();
		sc.nextLine();

		maze.init();
		maze.input(sc);
		sc.close();

		maze.bfs();

		System.out.println(maze.sum[maze.n][maze.m]);

//		System.out.println();

//		Arrays.stream(maze.sum).forEach(n -> System.out.println(Arrays.toString(n)));

	}

}

class Maze {
	int m;
	int n;
	int[] dx = new int[] { 0, 0, 1, -1 };
	int[] dy = new int[] { 1, -1, 0, 0 };
	int[][] map;
	int[][] sum;
	Queue<int[]> q;

	public void init() {
		map = new int[n + 1][m + 1];
		sum = new int[n + 1][m + 1];
		q = new LinkedList<>();
	}

	public void input(Scanner sc) {
		for (int i = 1; i <= n; i++) {
			String input = sc.nextLine();

			for (int j = 0; j < m; j++) {
				map[i][j + 1] = input.charAt(j) - '0';
			}
		}
	}

	public void bfs() {
		q.add(new int[] { 1, 1 });
		sum[1][1] = 1;

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int currentY = current[0];
			int currentX = current[1];

			for (int i = 0; i < 4; i++) {
				int nextY = currentY + dy[i];
				int nextX = currentX + dx[i];

				if (nextY >= 1 && nextY <= n && nextX >= 1 && nextX <= m && map[nextY][nextX] == 1
						&& sum[nextY][nextX] == 0) {
					sum[nextY][nextX] = sum[currentY][currentX] + 1;

					if (nextY == n && nextX == m) {
						continue;
					}

					q.add(new int[] { nextY, nextX });
				}
			}
		}

	}
}
