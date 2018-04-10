package 백준.삼성;

import java.util.Scanner;

// 14503번(로봇 청소기)

public class RobotCleaner {
	static int count = 0;
	static int[] moveX = { 0, 1, 0, -1 };
	static int[] moveY = { -1, 0, 1, 0 };
	private static int n;
	private static int m;
	private static int r;
	private static int c;
	private static int d;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 가로
		n = in.nextInt();
		// 세로
		m = in.nextInt();
		// 로봇 Y
		r = in.nextInt();
		// 로봇 X
		c = in.nextInt();
		// 방향
		d = in.nextInt();

		int[][] map = new int[n][m];
		boolean[][] check = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = in.nextInt();
			}
		}
		in.close();

		move(r, c, d, map, check);
		
		System.out.println(count);
	}

	private static void move(int r, int c, int d, int[][] map, boolean[][] check) {
//		System.out.println(r + " " + c + " " + d);
		
		// 방문 & 청소
		if(map[r][c] == 0 && !check[r][c]) {
			check[r][c] = true;
			count++;
		}
		
		int nextY;
		int nextX;
		int nextD = d;
		
		for(int i = 0; i < 4; i++) {
			nextD = (nextD + 3) % 4;
			nextY = r + moveY[nextD];
			nextX = c + moveX[nextD];
			
			if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && map[nextY][nextX] == 0 && !check[nextY][nextX]) {
				move(nextY, nextX, nextD, map, check);
				//왜 여기서 return을 해줘야하는걸까?
				return;
			}
		}
		
		int opposite = (d + 2) % 4;
		int oppoY = r + moveY[opposite];
		int oppoX = c + moveX[opposite];
		
		if(map[oppoY][oppoX] == 1) {
			return;
		} else {
			move(oppoY, oppoX, d, map, check);
		}
	}
}
