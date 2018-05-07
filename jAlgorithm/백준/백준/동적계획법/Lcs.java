package 백준.동적계획법;

import java.util.Scanner;

//9251번(LCS)

public class Lcs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String first = sc.nextLine();
		String second = sc.nextLine();

		String letter;

		// 두 문자열 중, 한 문자열에만 있는 알파벳은 가지고 있을 필요가 없으므로 제거해준다.
		for (int i = 0; i < 26; i++) {
			letter = (char) (i + 'A') + "";

			if (first.contains(letter) && !second.contains(letter)) {
				first = first.replace(letter, "");
			} else if (!first.contains(letter) && second.contains(letter)) {
				second = second.replace(letter, "");
			}
		}

		String shortStr;
		String longStr;

		if (first.length() >= second.length()) {
			longStr = first;
			shortStr = second;
		} else {
			longStr = second;
			shortStr = first;
		}

		int[][] dp = new int[shortStr.length() + 1][longStr.length() + 1];

		// x,y가 비교할 문자열이고, i,j는 그에 해당하는 인덱스라면
		// i == 0, j == 0 이면 0
		// i == j 면 dp[x][y] = dp[x-1][y-1] + 1;
		// i != j 면 dp[x][y] = max(dp[x-1][y], dp[x][y-1]);

		for (int i = 1; i <= shortStr.length(); i++) {
			for (int j = 1; j <= longStr.length(); j++) {
				if (shortStr.charAt(i - 1) == longStr.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		System.out.println(dp[shortStr.length()][longStr.length()]);

		sc.close();

	}

}
