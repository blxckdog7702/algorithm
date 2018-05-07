package 백준.삼성;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//15685번(드래곤커브)

class DragonPos {
	int y;
	int x;
	
	public DragonPos(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class DragonCurve {
	static int[] moveY = new int[] {0, -1, 0, 1};
	static int[] moveX = new int[] {1, 0, -1, 0};

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[][] map = new int[100][100];
		
		for (int i = 0; i < n; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int d = in.nextInt();
			int g = in.nextInt();
			
			int nextY = y + moveY[d];
			int nextX = x + moveX[d];
			
			int[][] temp = new int[100][100];
			
			List<DragonPos> list = new ArrayList<>();
			
			temp[y][x] = 1;
			
			list.add(new DragonPos(y, x));
			
			temp[nextY][nextX] = 1;
			
			list.add(new DragonPos(nextY, nextX));
			
			turn(temp, list, nextY, nextX, 1, g);
			
		}

		in.close();
	}

	private static void turn(int[][] temp, List<DragonPos> list, int y, int x, int count, int g) {
		if(count == g) {
			for(int[] a : temp) {
				System.out.println(Arrays.toString(a));
			}
			
			System.out.println();
			return;
		}
		
		DragonPos ori = list.get(list.size() - 1);
		
		for(int i = list.size() - 2; i >= 0; i--) {
			DragonPos p = list.get(i);
			
			int nextY = 0;
			int nextX = 0;
			
			int distY = ori.y - p.y;
			int distX = ori.x - p.x;
			
			if(distY > 0) {
				nextX = ori.x - Math.abs(distY);
			} else if(distX < 0) {
				nextX = ori.x + Math.abs(distY);
			} else {
				nextX = ori.x;
			}
			
			if(distX > 0) {
				nextY = ori.y - Math.abs(distX);
			} else if(distX < 0) {
				nextY = ori.y + Math.abs(distX);
			} else {
				nextY = ori.y;
			}
			
			temp[nextY][nextX] = 1;
			
			list.add(new DragonPos(nextY, nextX));
		}
		
		DragonPos last = list.get(list.size() - 1);
		
		turn(temp, list, last.y, last.x, count, g);
		
	}

}
