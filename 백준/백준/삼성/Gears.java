package 백준.삼성;

import java.util.Scanner;

//14891(톱니바퀴)

public class Gears {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int[][] gears = new int[4][8];

		// 입력
		for (int i = 0; i < 4; i++) {
			String input = in.nextLine();

			for (int j = 0; j < input.length(); j++) {
				gears[i][j] = input.charAt(j) - '0';
			}
		}

		int tc = in.nextInt();

		for (int i = 0; i < tc; i++) {
			int gearNum = in.nextInt();
			int direction = in.nextInt();
			boolean[] check = new boolean[4];

			if (direction == 1) {
				clockwise(gears, gearNum - 1, check);
			} else {
				counterClockwise(gears, gearNum - 1, check);
			}
		}
		
		System.out.println(count(gears));
		
		in.close();
	}

	public static void clockwise(int[][] gears, int num, boolean[] check) {
		// 체크
		check[num] = true;

		// 왼쪽
		if (num - 1 >= 0 && !check[num - 1] && gears[num - 1][2] != gears[num][6]) {
			counterClockwise(gears, num - 1, check);
		}

		// 오른쪽
		if (num + 1 <= 3 && !check[num + 1] && gears[num + 1][6] != gears[num][2]) {
			counterClockwise(gears, num + 1, check);
		}

		int temp = gears[num][7];

		for (int i = 6; i >= 0; i--) {
			gears[num][i + 1] = gears[num][i];
		}

		gears[num][0] = temp;

	}

	public static void counterClockwise(int[][] gears, int num, boolean[] check) {
		// 체크
		check[num] = true;

		// 왼쪽
		if (num - 1 >= 0 && !check[num - 1] && gears[num - 1][2] != gears[num][6]) {
			clockwise(gears, num - 1, check);
		}

		// 오른쪽
		if (num + 1 <= 3 && !check[num + 1] && gears[num + 1][6] != gears[num][2]) {
			clockwise(gears, num + 1, check);
		}

		int temp = gears[num][0];

		for (int i = 1; i < 8; i++) {
			gears[num][i - 1] = gears[num][i];
		}

		gears[num][7] = temp;
	}

	public static int count(int[][] gears) {
		int sum = 0;
		
		if(gears[0][0] == 1) {
			sum += 1;
		}
		
		if(gears[1][0] == 1) {
			sum += 2;
		}
		
		if(gears[2][0] == 1) {
			sum += 4;
		}
		
		if(gears[3][0] == 1) {
			sum += 8;
		}
		
		return sum;
	}
}
