package 백준.문자열;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1316번 (문자열)

public class GroupWordChecker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		String[] strs = new String[tc];

		for (int i = 0; i < tc; i++) {
			strs[i] = sc.next();
		}

		int count = 0;
		
		List<Character> buff = new ArrayList<>();

		for (int i = 0; i < strs.length; i++) {
			for (int j = 0; j < strs[i].length(); j++) {
				if (buff.contains(strs[i].charAt(j))) {
					count++;
					break;
				}
				
				if(j == strs[i].length() - 1) {
					
				} else {
					if (strs[i].charAt(j) != strs[i].charAt(j + 1)) {
						buff.add(strs[i].charAt(j));
					}
				}
			}
			
			buff.clear();
		}
		
		System.out.println(strs.length - count);

	}

}
