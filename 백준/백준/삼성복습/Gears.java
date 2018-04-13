package 백준.삼성복습;

import java.util.Scanner;

// 14891번(톱니바퀴)(복습)

public class Gears {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[][] gears = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String input = in.nextLine();

			for (int j = 0; j < 8; j++) {
				gears[i][j] = input.charAt(j) - '0';
			}
		}

		int tc = in.nextInt();

		for (int i = 0; i < tc; i++) {
			boolean[] visit = new boolean[4];

			int num = in.nextInt() - 1;
			int direction = in.nextInt();
			
			if(direction == 1) {
				clockwise(gears, num, visit);
			} else if(direction == -1) {
				counterClockwise(gears, num, visit);
			}
		}
		
		in.close();
		
		System.out.println(count(gears));

		// System.out.println(Arrays.toString(gears[0]));
		//
		// clockwise(gears, 0);
		//
		// System.out.println(Arrays.toString(gears[0]));

	}

	private static void clockwise(int[][] gears, int num, boolean[] visit) {
		visit[num] = true;

		// 왼쪽
		if (num - 1 >= 0 && !visit[num - 1] && gears[num][6] != gears[num - 1][2]) {
			counterClockwise(gears, num - 1, visit);
		}
		
		// 오른쪽
		if( num + 1 < 4 && !visit[num + 1] && gears[num][2] != gears[num + 1][6]) {
			counterClockwise(gears, num + 1, visit);
		}

		int temp = gears[num][7];

		for (int i = 7; i >= 1; i--) {
			gears[num][i] = gears[num][i - 1];
		}

		gears[num][0] = temp;
	}

	private static void counterClockwise(int[][] gears, int num, boolean[] visit) {
		visit[num] = true;

		// 왼쪽
		if (num - 1 >= 0 && !visit[num - 1] && gears[num][6] != gears[num - 1][2]) {
			clockwise(gears, num - 1, visit);
		}
		
		// 오른쪽
		if( num + 1 < 4 && !visit[num + 1] && gears[num][2] != gears[num + 1][6]) {
			clockwise(gears, num + 1, visit);
		}
		
		int temp = gears[num][0];

		for (int i = 1; i < 8; i++) {
			gears[num][i - 1] = gears[num][i];
		}

		gears[num][7] = temp;
	}
	
	private static int count(int[][] gears) {
		int sum = 0;
		
		if(gears[0][0] == 1) sum += 1;
		
		if(gears[1][0] == 1) sum += 2;
		
		if(gears[2][0] == 1) sum += 4;
		
		if(gears[3][0] == 1) sum += 8;

		
		return sum;
	}

}
