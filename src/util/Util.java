package util;

public class Util {
	// n개중에 r개 뽑는 경우의 수(조합)
	public static int combination(int n, int r) {
		if (n == r || r == 0)
			return 1;
		else
			return combination(n - 1, r - 1) + combination(n - 1, r);
	}

	// dp 버전 조합
	// public static long combination(int n, int r) {
	// if (n == r || r == 0)
	// return 1;
	//
	// if (dp[n][r] > 0) {
	// return dp[n][r];
	// }
	//
	// dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	// return dp[n][r];
	// }

	// 소수 판별 메서드
	public static boolean isPrime(int num) {
		boolean result = true;
		int end = (int) Math.sqrt(num);
		for (int i = 2; i <= end; i++) {
			if (num % i == 0) {
				result = false;
				break;
			} else {
				result = true;
			}
		}
		return result;
	}

	// 최대공약수 / 최소공배수
	public int[] gcdlcm(int a, int b) {
		int big = Math.max(a, b);
		int small = Math.min(a, b);

		int mod = big % small;

		while (mod > 0) {
			big = small;
			small = mod;
			mod = big % small;
		}

		int[] answer = new int[2];

		answer[0] = small;
		answer[1] = (a * b) / small;

		return answer;
	}

	// 최대공약수
	public static int gcd(int a, int b) {
		int big = Math.max(a, b);
		int small = Math.min(a, b);

		int mod = big % small;

		while (mod > 0) {
			big = small;
			small = mod;
			mod = big % small;
		}

		return small;
	}

	// 최소공배수
	public int lcm(int a, int b) {
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
