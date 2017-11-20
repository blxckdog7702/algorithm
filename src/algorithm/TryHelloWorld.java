package algorithm;

class TryHelloWorld {
	static int[] dp;

	public int tiling(int n) {
		dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % (int)Math.pow(10,5);
		}

		return dp[n];
	}

	public static void main(String args[]) {
		TryHelloWorld tryHelloWorld = new TryHelloWorld();
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.print(tryHelloWorld.tiling(30));
	}
}