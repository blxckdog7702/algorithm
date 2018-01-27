package 백준.구현;

import java.util.Scanner;

//1022번(소용돌이 예쁘게 출력하기)

public class PrintVortex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 왼쪽 위 좌표 (c = x, r = y)
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		// 오른쪽 아래 좌표
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();

		sc.close();

		// 입력 중 절대값이 큰 수의 제곱으로 배열을 생성해준다.
		int row = Math.max(Math.abs(r1), Math.abs(r2));
		int col = Math.max(Math.abs(c1), Math.abs(c2));
		int leng = Math.max(row, col) * 2 + 1;

		// 배열 생성
		int[][] arr = new int[leng][leng];
		int zero = leng / 2;
		arr[zero][zero] = 1;

		// 영점 조정
		int x = zero;
		int y = zero;

		// 소용돌이에 채워지는 숫자 카운트
		int count = 2;
		// 소용돌이 (오른/위, 왼/아래) 반복 횟수
		int times = 1;

		while (times != leng) {

			// 반복 횟수가 홀수면 오른/위, 반복 횟수가 짝수면 왼/아래
			if (times % 2 == 1) {
				for (int i = 0; i < times; i++) {
					// 오른쪽
					x++;
					arr[y][x] = count++;
				}

				for (int i = 0; i < times; i++) {
					// 위쪽
					y--;
					arr[y][x] = count++;
				}

				times++;
			} else {

				for (int i = 0; i < times; i++) {
					// 왼쪽
					x--;
					arr[y][x] = count++;
				}

				for (int i = 0; i < times; i++) {
					// 아래쪽
					y++;
					arr[y][x] = count++;
				}

				times++;
			}
		}

		// 다 돌고나면 맨 마지막에 times - 1 만큼 오른방향으로 채워줘야 소용돌이가 완성된다.
		for (int i = 0; i < times - 1; i++) {
			// 오른쪽
			x++;
			arr[y][x] = count++;
		}

		int printY = zero + r1;
		int printX = zero + c1;

		int max = 0;

		// 자릿수세기
		for (int i = printY; i <= zero + r2; i++) {
			for (int j = printX; j <= zero + c2; j++) {
				if (max < arr[i][j]) {
					max = arr[i][j];
				}
			}
		}

		// 숫자 중 가장 큰 자릿수
		int digitLength = (max + "").length();

		// 출력
		for (int i = printY; i <= zero + r2; i++) {
			for (int j = printX; j <= zero + c2; j++) {
				if (digitLength == 4) {
					System.out.printf("%4d", arr[i][j]);
				} else if (digitLength == 3) {
					System.out.printf("%3d", arr[i][j]);
				} else if (digitLength == 2) {
					System.out.printf("%2d", arr[i][j]);
				} else {
					System.out.printf("%d", arr[i][j]);
				}
				// 마지막 열 공백 제거
				if (j < zero + c2) {
					System.out.print(" ");
				}
			}
			// 마지막 행 개행 제거
			if (i < zero + r2) {
				System.out.println();
			}
		}
	}
}
