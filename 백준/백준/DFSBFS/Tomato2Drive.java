package 백준.DFSBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//7589번(토마토)

public class Tomato2Drive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Tomato2 tm = new Tomato2();

		// 가로
		tm.x = sc.nextInt();
		// 세로
		tm.y = sc.nextInt();
		// 높이
		tm.z = sc.nextInt();

		tm.init();

		tm.input(sc);

		sc.close();

		if(tm.q.peek().size() == 0) {
			System.out.println(-1);
			return;
		}
		
		if(tm.q.peek().size() == tm.x * tm.y * tm.z) {
			System.out.println(0);
			return;
		}
		
		
		tm.dfs();
		
		if(tm.unripeTomatoes > 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(tm.days);

	}

}

class Tomato2 {
	int x;
	int y;
	int z;
	
	int[][][] box;
	boolean[][][] visit;
	Queue<ArrayList<int[]>> q;

	int unripeTomatoes = 0;
	int days = -1;
	
	int[] dx = new int[] { 0, 0, 0, 0, 1, -1 };
	int[] dy = new int[] { 0, 0, 1, -1, 0, 0 };
	int[] dz = new int[] { 1, -1, 0, 0, 0, 0 };
	
	public void dfs() {
		while(!q.isEmpty()) {
			days++;
			ArrayList<int[]> todayCoors = q.poll();
			ArrayList<int[]> nextCoors = new ArrayList<>();
			
			for(int[] ripeTomato : todayCoors ) {
				for(int i = 0; i < 6; i++) {
					int nextZ = ripeTomato[0] + dz[i];
					int nextY = ripeTomato[1] + dy[i];
					int nextX = ripeTomato[2] + dx[i];
					
					if(nextZ >= 0 && nextZ < z && nextY >= 0 && nextY < y && nextX >= 0 && nextX < x
							&& !visit[nextZ][nextY][nextX] && box[nextZ][nextY][nextX] == 0) {
						visit[nextZ][nextY][nextX] = true;
						box[nextZ][nextY][nextX] = 1;
						unripeTomatoes--;
						nextCoors.add(new int[] {nextZ, nextY, nextX});
					}
				}
			}
			
			if(!nextCoors.isEmpty()) {
				q.add(nextCoors);
			}
			
		}
	}

	public void init() {
		box = new int[z][y][x];
		visit = new boolean[z][y][x];
		q = new LinkedList<>();
	}

	public void input(Scanner sc) {
		ArrayList<int[]> firstCoor = new ArrayList<>();
		
		for (int i = 0; i < z; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < x; k++) {
					int input = sc.nextInt();
					box[i][j][k] = input;

					if (input == 1) {
						firstCoor.add(new int[] {i, j, k});
						visit[i][j][k] = true;
					}
					
					if (input == 0) {
						unripeTomatoes++;
					}
				}
			}
		}
		
		q.add(firstCoor);
	}
}
