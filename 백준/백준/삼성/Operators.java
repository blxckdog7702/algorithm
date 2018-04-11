package 백준.삼성;

import java.util.Scanner;

// 14888번(연산자 끼워넣기)

public class Operators {
	private static int n;
	private static int[] nums;
	private static int[] opers;
	private static int max;
	private static int min;

	public static void main(String[] args) {
		input();

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		dfs(1, 0, 0, 0, 0, nums[0]);
		
		System.out.println(max);
		System.out.println(min);

	}

	private static void dfs(int idx, int plus, int minus, int multi, int div, int total) {
		if (idx == n) {
			max = Math.max(max, total);
			min = Math.min(min, total);
			return;
		}

		if (plus < opers[0]) {
			dfs(idx + 1, plus + 1, minus, multi, div, total + nums[idx]);
		}

		if (minus < opers[1]) {
			dfs(idx + 1, plus, minus + 1, multi, div, total - nums[idx]);
		}

		if (multi < opers[2]) {
			dfs(idx + 1, plus, minus, multi + 1, div, total * nums[idx]);
		}

		if (div < opers[3]) {
			dfs(idx + 1, plus, minus, multi, div + 1, total / nums[idx]);
		}

	}

	private static void input() {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();

		nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}

		opers = new int[4];

		for (int i = 0; i < 4; i++) {
			opers[i] = in.nextInt();
		}

		in.close();
	}

}
