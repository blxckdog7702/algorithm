package 프로그래머스;


class Hopscotch {
	static int[][] dp = new int[100001][4];

	int hopscotch(int[][] board, int size) {
		int result = 0;

		for (int i = 0; i < 4; i++) {
			dp[0][i] = board[0][i];
		}

		for (int i = 1; i < size; i++) {
			for (int j = 0; j < 4; j++) {
				int maxValue = 0;
				
				for(int k = 0; k < 4; k++) {
					if(j == k) continue;
					
					maxValue = Math.max(maxValue, dp[i - 1][k] + board[i][j]);
				}
				
				dp[i][j] = maxValue;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			if(result < dp[size - 1][i]) {
				result = dp[size - 1][i];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Hopscotch c = new Hopscotch();
		int[][] test = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		// �Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
		System.out.println(c.hopscotch(test, 3));
	}

}