package 백준.문자열;

import java.util.Scanner;

//1152번(단어의 개수)

public class NumOfWord {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		if(str.isEmpty()) {
			System.out.println(0);
			return;
		}
		
//		//딱 한 단어만 있는 케이스
//		if(!str.contains(" ")) {
//			System.out.println(1);
//			return;
//		}
		
		String[] strs = str.split(" ");
		//띄어쓰기가 연속 두 번인 케이스
		int count = 0;
		
		for(int i = 0; i < strs.length; i++) {
			if(strs[i].isEmpty()) {
				count++;
			}
		}
		
		System.out.println(strs.length - count);
		return;
	}
}
