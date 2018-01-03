package 백준.문자열;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//1316번 (문자열)

public class GroupWordChecker {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		//
		// int tc = sc.nextInt();
		//
		// String[] strs = new String[tc];
		//
		// for (int i = 0; i < tc; i++) {
		// strs[i] = sc.next();
		// }
		//
		// int count = 0;
		//
		// List<Character> buff = new ArrayList<>();
		//
		// for (int i = 0; i < strs.length; i++) {
		// for (int j = 0; j < strs[i].length(); j++) {
		// if (buff.contains(strs[i].charAt(j))) {
		// count++;
		// break;
		// }
		//
		// if(j == strs[i].length() - 1) {
		//
		// } else {
		// if (strs[i].charAt(j) != strs[i].charAt(j + 1)) {
		// buff.add(strs[i].charAt(j));
		// }
		// }
		// }
		//
		// buff.clear();
		// }
		//
		// System.out.println(strs.length - count);

		int count = 0;
		boolean isGroupWord = false;
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < tc; i++) {
			isGroupWord = true;
			String input = sc.nextLine();
			Set<Character> set = new HashSet<>();

			// 중복된 알파벳 제거
			for (int j = 0; j < input.length(); j++) {
				set.add(input.charAt(j));
			}

			for (Character letter : set) {
				int letterCount = input.length() - input.replace(letter.toString(), "").length();

				//연속된 글자만 있다면 마지막 인덱스 - 첫 인덱스 = 글자 수 - 1 이여야 한다.
				if (input.lastIndexOf(letter) - input.indexOf(letter) != letterCount - 1) {
					isGroupWord = false;
					break;
				}
			}

			if (isGroupWord) {
				count++;
			}
		}

		sc.close();
		System.out.println(count);
	}

}
