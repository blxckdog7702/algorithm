package 백준.DFSBFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

		sc.close();

		sn.bfs();
	}

}

class SectorNumbering {
	int n;
	int[][] map;
	boolean[][] visit;
	int move[][] = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	List<Integer> houseNumberList;

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
		houseNumberList = new ArrayList<>();
	}

	public void bfs() {
		int sectorCount = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1 && !visit[i][j]) {
					int houseNum = 0;
					Queue<int[]> q = new LinkedList<>();
					q.add(new int[] {i , j});
					visit[i][j] = true;
					houseNum++;
					
					while(!q.isEmpty()) {
						int[] currentPos = q.poll();
						
						for(int k = 0; k < move.length; k++) {
							int[] nextPos = new int[] {currentPos[0] + move[k][0], currentPos[1] + move[k][1]};
							
							if(nextPos[0] >= 0 && nextPos[0] < n && nextPos[1] >= 0 && nextPos[1] < n && !visit[nextPos[0]][nextPos[1]] && map[nextPos[0]][nextPos[1]] == 1) {
								q.add(nextPos);
								visit[nextPos[0]][nextPos[1]] = true;
								houseNum++;
							}
						}
					}
					
					houseNumberList.add(houseNum);
					sectorCount++;
				}
			}
		}
		
		System.out.println(sectorCount);
		
		Collections.sort(houseNumberList);
		
		for(int i : houseNumberList) {
			System.out.println(i);
		}
		
	}

}
