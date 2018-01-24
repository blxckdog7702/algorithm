package 백준.동적계획법;

import java.util.Arrays;
import java.util.Scanner;

//1520번(내리막 길)

public class Downhill {
	int m;
	int n;
	
	int[][] map;
	int[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Downhill dh = new Downhill();
		
		// 세로의 크기
		dh.m = sc.nextInt();
		// 가로의 크기
		dh.n = sc.nextInt();
		
		int m = dh.m;
		int n = dh.n;

		dh.map = new int[m + 1][n + 1];
		dh.visit = new int[m + 1][n + 1];

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dh.map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i <= m; i++) {
			Arrays.fill(dh.visit[i], -1);
		}

		int result = dh.search(1, 1);
		System.out.println(result);
		sc.close();

	}

	private int search(int x, int y) {
		int[] moveX = new int[] {0, 1, 0, -1, 0};
		int[] moveY = new int[] {0, 0, 1, 0, -1};
		
//		int current = map[y][x];
		
		if(x == n && y == m) {
			return 1;
		}
		
		if (visit[y][x] > -1) {
			return visit[y][x];
		}
		
		int temp = 0;
		
		for(int i = 1; i < 5; i++) {
			int nextX = x + moveX[i];
			int nextY = y + moveY[i];
			
			if(nextX > 0 && nextX <= n && nextY > 0 && nextY <= m && map[nextY][nextX] < map[y][x]) {
				 
				temp += search(nextX, nextY);
			}
		}
		
		return visit[y][x] = temp;

	}
}

class Coor {
	int x;
	int y;

	public Coor(int i, int j) {
		y = i;
		x = j;
	}
}
