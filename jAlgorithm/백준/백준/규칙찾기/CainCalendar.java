package 백준.규칙찾기;

import java.util.Scanner;

//6064번(카잉 달력)

public class CainCalendar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		int M, N, x, y;

		for (int i = 0; i < tc; i++) {
			M = sc.nextInt();
			N = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();

			int year = 1;
			int tempX = 1, tempY = 1, add = 1;

			// 최소공배수
			int lcm = lcm(M, N);
			
			while (true) {
				if (year > lcm) {
					System.out.println(-1);
					break;
				}

				if (x == tempX && y == tempY) {
					System.out.println(year);
					break;
				}
				
				if (tempX == x) {
					add = M;
				}

				if (tempY == y) {
					add = N;
				}

				if (add == M) {
					tempY = (tempY + add) % N;
					if(tempY == 0) {
						tempY = N;
					}
				} else if(add == N){
					tempX = (tempX + add) % M;
					if(tempX == 0) {
						tempX = M;
					}
				}
				else {
					tempX += add;
					tempY += add;
				}

				year += add;

				
			}

		}
		sc.close();
	}

	private static int lcm(int a, int b) {
		int big = Math.max(a, b);
		int small = Math.min(a, b);

		int mod = big % small;

		while (mod > 0) {
			big = small;
			small = mod;
			mod = big % small;
		}

		return (a * b) / small;
	}

}
