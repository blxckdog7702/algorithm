package 백준.DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//7576번 (BFS)

class Coor {
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Coor() {

	}

	public Coor(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Tomato {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int width = sc.nextInt();
		int height = sc.nextInt();

		int[][] box = new int[height][width];
		int[][] move = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		int count = 0;
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				box[i][j] = sc.nextInt();
			}
		}

		sc.close();
		
		Queue<ArrayList<Coor>> q = new LinkedList<>();

		ArrayList<Coor> firstList = new ArrayList<>();

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (box[i][j] == 1) {
					firstList.add(new Coor(i, j));
				}
			}
		}

		if (firstList.size() == 0) {
			System.out.println("-1");
			return;
		}

		if (firstList.size() == width * height) {
			System.out.println("0");
			return;
		}

		q.add(firstList);

		while (!q.isEmpty()) {

			ArrayList<Coor> temp = q.poll();
			ArrayList<Coor> next = new ArrayList<>();

			for (int i = 0; i < temp.size(); i++) {
				Coor item = temp.get(i);

				for (int j = 0; j < 4; j++) {
					int nextY = item.getY() + move[j][0];
					int nextX = item.getX() + move[j][1];

					if (nextY >= 0 && nextY < height && nextX >= 0 && nextX < width && box[nextY][nextX] == 0) {
						next.add(new Coor(nextY, nextX));
						box[nextY][nextX] = 1;
					}
				}
			}
			if(next.size() != 0) {
				q.add(next);
				count++;
			}
		}
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(count);
		return;
	}
}
