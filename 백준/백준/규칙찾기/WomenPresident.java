package 백준.규칙찾기;

import java.util.Scanner;

//2775번(부녀회장이 될테야)

public class WomenPresident {

	public static void main(String[] args) {
		int[][] arr = new int[15][15];

		// 0층 1호 ~ 14호 초기화
		// 1~14층 1호 초기화
		for (int i = 1; i <= 14; i++) {
			arr[0][i] = i;
			arr[i][1] = 1;
		}

		for (int i = 1; i <= 14; i++) {
			for (int j = 1; j <= 14; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		int floor = 0;
		int room = 0;

		for (int i = 0; i < tc; i++) {
			floor = sc.nextInt();
			room = sc.nextInt();

			System.out.println(arr[floor][room]);
		}

		sc.close();

	}

}
