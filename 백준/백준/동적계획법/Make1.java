package 백준.동적계획법;

import java.util.Scanner;

//1463번(1로 만들기)

public class Make1 {
	int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();

		Make1 mk = new Make1();

		mk.dp = new int[input + 1];

		mk.check(input);
		
		System.out.println(mk.dp[input]);
	}

	private int check(int input) {
		if (input == 1) {
			return 0;
		}

		if (dp[input] > 0) {
			return dp[input];
		}

		dp[input] = check(input - 1) + 1;

		if (input % 3 == 0) {
			int temp = check(input / 3) + 1;
			if(dp[input] > temp) {
				dp[input] = temp;
			}
		}

		if (input % 2 == 0) {
			int temp = check(input / 2) + 1;
			if(dp[input] > temp) {
				dp[input] = temp;
			}
		}

		return dp[input];
	}

}
