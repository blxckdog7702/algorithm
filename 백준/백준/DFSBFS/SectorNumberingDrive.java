package 백준.DFSBFS;

import java.util.Arrays;
import java.util.Scanner;

//2667번(단지번호붙이기)

public class SectorNumberingDrive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SectorNumbering sn = new SectorNumbering();

		int n = sc.nextInt();
		sc.nextLine();

		sn.init(n);
		sn.input(sc);

		System.out.println(Arrays.deepToString(sn.map));

		sc.close();

		int sectorCount = 0;

	}

}

class SectorNumbering {
	int n;
	int[][] map;
	boolean[][] visit;
	int move[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public void input(Scanner sc) {
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();

			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
	}

	public void init(int n) {
		this.n = n;
		map = new int[n][n];
		visit = new boolean[n][n];
	}

	public void bfs() {
		
	}

}
