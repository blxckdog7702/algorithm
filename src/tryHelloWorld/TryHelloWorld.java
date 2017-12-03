package tryHelloWorld;

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
		// �Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
		System.out.print(tryHelloWorld.tiling(30));
	}
}