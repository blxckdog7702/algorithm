package 백준.문자열;

import java.util.Scanner;

//2941번 (크로아티아 알파벳)

public class CroatiaAlpha {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		int skipCount = 0;
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (skipCount > 0) {
				skipCount--;
				continue;
			}

			if (i == s.length() - 1) {
				count++;
				continue;
			}

			if (s.charAt(i) == 'c' && s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
				count++;
				skipCount++;
				continue;
			} else if (s.charAt(i) == 'd' && s.charAt(i + 1) == '-') {
				count++;
				skipCount++;
				continue;
			} else if (s.charAt(i) == 'd' && i <= s.length() - 2 && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
				count++;
				skipCount += 2;
				continue;
			} else if (s.charAt(i) == 'l' && s.charAt(i + 1) == 'j') {
				count++;
				skipCount++;
				continue;
			} else if (s.charAt(i) == 'n' && s.charAt(i + 1) == 'j') {
				count++;
				skipCount++;
				continue;
			} else if (s.charAt(i) == 's' && s.charAt(i + 1) == '=') {
				count++;
				skipCount++;
				continue;
			} else if (s.charAt(i) == 'z' && s.charAt(i + 1) == '=') {
				count++;
				skipCount++;
				continue;
			} else {
				count++;
			}
		}

		System.out.println(count);
	}
}
