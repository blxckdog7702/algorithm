package 백준.DFSBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
		
//		maze.visit[1][1] = true;
		maze.check[1][1] = 1;
		maze.dfs(new int[] {1,1}, 1);
		
//		Collections.sort(maze.counts);
//		System.out.println(maze.counts.get(0));
		System.out.println(maze.check[maze.n][maze.m]);
	}

}

class Maze {
	int m;
	int n;
	int[] dx = new int[] { 0, 0, 1, -1 };
	int[] dy = new int[] { 1, -1, 0, 0 };
	int[][] map;
	boolean[][] visit;
	int[][] check;
	List<Integer> counts;

	public void init() {
		map = new int[n + 1][m + 1];
		visit = new boolean[n + 1][m + 1];
		counts = new ArrayList<>();
		check = new int[n + 1][n + 1];
	}
	
	public void input(Scanner sc) {
		for (int i = 1; i <= n; i++) {
			String input = sc.nextLine();

			for (int j = 0; j < m; j++) {
				map[i][j + 1] = input.charAt(j) - '0';
			}
		}
	}
	
	public void dfs(int[] current, int tempCount) {
		for(int i = 0; i < 4; i++) {
			int nextY = current[0] + dy[i];
			int nextX = current[1] + dx[i];
			
			if(nextY >= 1 && nextY <= n && nextX >= 1 && nextX <= m && map[nextY][nextX] == 1 && check[nextY][nextX] == 0) {
				if(nextY == n && nextX == m) {
					if(check[nextY][nextX] > 0) {
						check[nextY][nextX] = Math.min(check[nextY][nextX], tempCount + 1);
					} else {
						check[nextY][nextX] = tempCount + 1;
					}
					continue;
				}
				
				check[nextY][nextX] = tempCount + 1;
				dfs(new int[] {nextY, nextX}, tempCount + 1);
			}
		}
		
	}
}
