package 알고스팟;

import java.util.Scanner;

//https://algospot.com/judge/problem/read/DRAWRECT

public class DrawRect {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			// 원점 x,y
			int x = sc.nextInt();
			int y = sc.nextInt();

			// 원점 대비 x축 증가량
			int m = 0;
			// 원점 대비 y축 증가량
			int n = 0;

			boolean[] check = new boolean[3];

			for (int j = 0; j < 2; j++) {
				int tempX = sc.nextInt();
				int tempY = sc.nextInt();

				if (x == tempX && y != tempY) {
					n = tempY - y;
					check[0] = true;
				} else if (x != tempX && y == tempY) {
					m = tempX - x;
					check[1] = true;
				} else if (x != tempX && y != tempY) {
					n = tempY - y;
					m = tempX - x;
					check[2] = true;
				}
			}

			if (check[0] == false) {
				System.out.println(x + " " + (y + n));
			} else if (check[1] == false) {
				System.out.println((x + m) + " " + y);
			} else if (check[2] == false) {
				System.out.println((x + m) + " " + (y + n));
			}
		}

		sc.close();
	}

}
