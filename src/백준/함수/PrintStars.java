package 백준.함수;

import java.util.Arrays;
import java.util.Scanner;

//2448번(별찍기-11)

public class PrintStars {
		char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		// 첫째 줄에 N이 주어진다. N은 항상 3*2^k 수이다. (3, 6, 12, 24, 48, ...) (k<=10)
		// 높이는 3*2^k, 너비는 3*2(k+1)
		PrintStars ps = new PrintStars();
		ps.arr = new char[n][n*2];

		// 배열 초기화
		for (int i = 0; i < n; i++) {
			Arrays.fill(ps.arr[i], ' ');
		}

		// 삼각형의 높이와, 삼각형 맨 위 꼭지점 좌표를 매개변수로 넘긴다.
		ps.makeStar(n, n - 1, 0);

		StringBuilder sb = new StringBuilder();

		// 일일이 sysout으로 다 찍는 것보단 StringBuilder에 넣어서 처리하는게 더 빠르다.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n; j++) {
				sb.append(ps.arr[i][j]);
			}
			sb.append(System.lineSeparator());
		}

		System.out.println(sb);
	}

	private void makeStar(int n, int x, int y) {
		if (n == 3) {
			arr[y][x] = '*';
			arr[y + 1][x - 1] = '*';
			arr[y + 1][x + 1] = '*';
//			arr[y + 2][x - 2] = '*';
			for(int i = x - 2; i <= x + 2; i++) {
				arr[y + 2][i] = '*';
			}
//			arr[y + 2][x - 1] = '*';
//			arr[y + 2][x] = '*';
//			arr[y + 2][x + 1] = '*';
//			arr[y + 2][x + 2] = '*';
			return;
		}

		// 여기까지 넘어오면 삼각형이 3개 이상 있다는 뜻이다.
		// 최소 단위 삼각형(높이 3)의 좌표를 모두 찾을때가지 계속 재귀를 반복 후, 모든 좌표에서 *을 그린다.

		makeStar(n / 2, x, y); // 그중 가장 윗 삼각형의 높이와 좌표 보냄
		makeStar(n / 2, x - (n / 2), y + (n / 2)); // 왼쪽 밑 삼각형의 높이와 좌표 보냄
		makeStar(n / 2, x + (n / 2), y + (n / 2)); // 오른쪽 밑 삼각형의 높이와 좌표 보냄
	}
}
