package 백준.기타;

import java.util.Scanner;

public class StringExplosion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		String bomb = sc.nextLine();

		char[] ans = new char[1000001];

		int idx = 0;
		int len = bomb.length();

		for (int i = 0; i < input.length(); i++) {
			ans[idx++] = input.charAt(i);

			if (ans[idx - 1] == bomb.charAt(len - 1)) {
				if (idx - len < 0)
					continue;

				boolean c = false;
				for (int j = 0; j < len; j++) {
					if (ans[idx - 1 - j] != bomb.charAt(len - 1 - j)) {
						c = true;
						break;
					}
				}
				if (!c)
					idx -= len;
			}
		}
		ans[idx] = '\0';

		if (idx == 0) {
			System.out.println("FRULA");
		} else {
			for(int i = 0; i < idx; i++) {
				System.out.print(ans[i]);
			}
		}

		sc.close();
	}

}
