package 백준.삼성복습;

import java.util.Scanner;

//14888번(연산자끼워넣기)(복습)

public class Operators {
	private static int[] arr;
	private static int[] op;
	private static int max;
	private static int min;
	private static int n;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}

		op = new int[4];

		for (int i = 0; i < 4; i++) {
			op[i] = in.nextInt();
		}

		in.close();

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		dfs(1, 0, 0, 0, 0, arr[0]);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int idx, int plus, int minus, int multi, int div, int result) {
		if (idx == n) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		if (plus < op[0]) {
			dfs(idx + 1, plus + 1, minus, multi, div, result + arr[idx]);
		}

		if (minus < op[1]) {
			dfs(idx + 1, plus, minus + 1, multi, div, result - arr[idx]);
		}

		if (multi < op[2]) {
			dfs(idx + 1, plus, minus, multi + 1, div, result * arr[idx]);
		}
		
		if (div < op[3]) {
			dfs(idx + 1, plus, minus, multi, div + 1, result / arr[idx]);
		}
	}
}
