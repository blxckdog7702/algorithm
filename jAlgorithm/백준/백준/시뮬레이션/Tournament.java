package 백준.시뮬레이션;

import java.util.Scanner;

//1057번(토너먼트)

public class Tournament {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();

		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();

		int count = 1;

		int small = Math.min(a, b);
		int big = Math.max(a, b);

		while (number > 1) {
			// 1,2면 바로 끝나지만 2,3이면 1라운드 더 돌아야한다.
			if (big - small == 1 && big % 2 == 0) {
				break;
			}

			// 1라운드가 끝나면 번호가 짝수였으면 /2 로 바뀌고 홀수였으면 /2 + 1로 바뀐다.
			if (big % 2 == 0) {
				big /= 2;
			} else {
				big = (big / 2) + 1;
			}

			if (small % 2 == 0) {
				small /= 2;
			} else {
				small = (small / 2) + 1;
			}

			// 라운드 카운트 증가
			count++;
		}

		System.out.println(count);
	}
}
