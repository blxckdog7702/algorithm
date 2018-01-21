package 백준.동적계획법;

import java.util.Scanner;

//1005번(ACM Craft)

public class ACMCraft {
	// 건물의 개수
	int n;
	// 건물간 건설 규칙의 개수
	int k;
	// 각 건물의 건설 기간
	int[] periods;
	// 건물 간 관계
	boolean[][] paths;
	// dp[n] : n번 건물까지 짓는데 필요한 시간
	int[] dp;
	// 스캐너
	Scanner sc;

	public ACMCraft() {
		sc = new Scanner(System.in);
	}

	public static void main(String[] args) {
		ACMCraft game = new ACMCraft();

		int tc = game.sc.nextInt();

		for (int i = 0; i < tc; i++) {
			// n과 k 입력
			game.inputBuildingSize();

			// 각 배열 할당
			game.init();

			// 각 건물 짓는 기간 저장
			game.inputPeriod();

			// 건물 간 경로 저장
			game.inputPaths();
			
			// 최종 목적지
			int goal = game.sc.nextInt();

			System.out.println(game.calcTimes(goal));
		}

		game.sc.close();
	}

	private void inputBuildingSize() {
		n = sc.nextInt();
		k = sc.nextInt();
	}
	
	private void init() {
		periods = new int[n + 1];
		paths = new boolean[n + 1][n + 1];
		dp = new int[n + 1];
	}
	
	private void inputPeriod() {
		for (int j = 1; j <= n; j++) {
			periods[j] = sc.nextInt();
		}
	}
	
	private void inputPaths() {
		int start = 0;
		int end = 0;

		for (int j = 0; j < k; j++) {
			start = sc.nextInt();
			end = sc.nextInt();

			paths[start][end] = true;
		}
	}

	private int calcTimes(int goal) {
		if (dp[goal] > 0) {
			return dp[goal];
		}

		int max = 0;

		for (int i = 1; i < periods.length; i++) {
			if (paths[i][goal] == true) {

				int temp = calcTimes(i);
				if (max < temp) {
					max = temp;
				}
			}
		}
		
		if(max == 0) {
			dp[goal] = periods[goal];
			return dp[goal];
		}

		dp[goal] = max + periods[goal];
		
		return dp[goal];
	}

}
