package 백준.동적계획법;

import java.util.Scanner;

//10844번(쉬운 계단수)

public class EasyStairs {

	private static final int MOD = 1000000000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();

		// 행 : N개 자리수, 열 : 0~9로 끝나는 숫자의 수
		int[][] arr = new int[101][10];

		for (int i = 1; i < 10; i++) {
			arr[1][i] = 1;
		}
		
		for (int i = 2; i < input + 1; i++) {
			int index = i - 1;
			
			//0으로 끝나는 숫자의 개수는 전 번에서 1로 끝난 숫자의 개수
			arr[i][0] = arr[index][1];

			//2~8로 끝나는 숫자의 개수는 전 번에서 +-1로 끝난 숫자의 개수를 더한 것과 같다.
			for (int j = 1; j < 9; j++) {
				arr[i][j] = (arr[index][j - 1] + arr[index][j + 1]) % MOD;
			}

			//9로 끝나는 숫자의 개수는 전 번에서 8로 끝난 숫자의 개수
			arr[i][9] = arr[index][8];
		}
		
		int sum = 0;

		for (int i = 0; i < 10; i++) {
			sum = (sum + arr[input][i]) % MOD;
		}

		System.out.println(sum);
		sc.close();
	}

}
