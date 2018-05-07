package 백준.삼성;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//15686번(치킨 배달)

class Pos1 {
	int x;
	int y;
	
	public Pos1(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Chicken {

	private static int[][] map;
	private static List<Pos1> list;
	private static int m;
	private static int result;
	private static int n;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// 가로세로
		n = in.nextInt();
		// 필요한 치킨집 수
		m = in.nextInt();
		map = new int[n][n];
		list = new ArrayList<>();
		
		// 지도 입력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int input = in.nextInt();
				
				if(input == 2) {
					list.add(new Pos1(i, j));
				}
				
				map[i][j] = input;
			}
		}
		in.close();
		
		result = Integer.MAX_VALUE;
		
		dfs(0,0);
		
		System.out.println(result);
	}

	private static void dfs(int idx, int count) {
		if(count == m) {
			calc();
			//거리 재기
			return;
		}
		
		if(idx >= list.size()) {
			return;
		}
		
		Pos1 po = list.get(idx);
		
		map[po.y][po.x] = 3;
		dfs(idx + 1, count + 1);
		
		map[po.y][po.x] = 2;
		dfs(idx + 1, count);
	}

	private static void calc() {
		int tempSum = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1) {
					int minDistFromHouse = Integer.MAX_VALUE;

					for(int k = 0; k < n; k++) {
						for(int p = 0; p < n; p++) {
							if(map[k][p] == 3) {
								int distY = Math.abs(i-k);
								int distX = Math.abs(j-p);
								
								minDistFromHouse = Math.min(minDistFromHouse, distY + distX);
							}
						}
					}
					
					tempSum += minDistFromHouse;
				}
			}
		}
		
		result = Math.min(result, tempSum);
	}

}
