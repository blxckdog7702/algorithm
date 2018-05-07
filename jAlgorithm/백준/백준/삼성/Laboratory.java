package 백준.삼성;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//14502번(연구소)

class Pos {
	int x;
	int y;

	public Pos(int y, int x) {
		this.y = y;
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

public class Laboratory {
	private static List<Pos> emptyList;
	private static int n;
	private static int m;
	private static int[][] arr;
	private static int count;
	private static int[] moveX;
	private static int[] moveY;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		m = in.nextInt();

		arr = new int[n][m];

		emptyList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int input = in.nextInt();

				if (input == 0) {
					emptyList.add(new Pos(i, j));
				}
				arr[i][j] = input;
			}
		}

		in.close();

		count = 0;

		dfs(0, 0);

		System.out.println(count);
		
	}

	private static void dfs(int idx, int wallCount) {
		if (wallCount == 3) {
			count = Math.max(count, calculate(arr));
			
//			for(int[] ar : arr) {
//				System.out.println(Arrays.toString(ar));
//			}
//			System.out.println();
			return;
		}
		
		if (idx >= emptyList.size()) {
			return;
		}
		
		Pos pos = emptyList.get(idx);
		
//		if(pos.getY() == 3 && pos.getX() == 3) {
//			System.out.println("!!!");
//		}
		// 여기서 세우고
		arr[pos.getY()][pos.getX()] = 1;
		dfs(idx + 1, wallCount + 1);

		// 안세우고
		arr[pos.getY()][pos.getX()] = 0;
		dfs(idx + 1, wallCount);
	}

	private static int calculate(int[][] arr) {
		int[][] temp = new int[n][m];
		boolean[][] visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				temp[i][j] = arr[i][j];
			}
		}
//			temp[i] = Arrays.copyOf(arr[i], arr[i].length);

		moveX = new int[] { 0, 1, 0, -1 };
		moveY = new int[] { 1, 0, -1, 0 };

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 2 && !visit[i][j]) {
					infest(temp, visit, i, j);
				}
			}
		}

		return countSafeArea(temp);
	}

	private static void infest(int[][] temp, boolean[][] visit, int currentY, int currentX) {
		visit[currentY][currentX] = true;
		temp[currentY][currentX] = 2;

		for (int k = 0; k < 4; k++) {
			int nextY = currentY + moveY[k];
			int nextX = currentX + moveX[k];

			if (nextY >= 0 && nextY < n && nextX >= 0 && nextX < m && !visit[nextY][nextX] && temp[nextY][nextX] == 0) {
				infest(temp, visit, nextY, nextX);
			}
		}
	}

	private static int countSafeArea(int[][] temp) {
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) {
					count++;
				}
			}
		}

		return count;
	}

}
