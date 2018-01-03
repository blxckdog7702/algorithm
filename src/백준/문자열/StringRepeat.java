package 백준.문자열;

//2675번(문자열 반복) 

import java.util.Scanner;

public class StringRepeat {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// StringBuilder sb = new StringBuilder();
		//
		// int tc = sc.nextInt();
		//
		// int[] times = new int[tc];
		// String[] strs = new String[tc];
		//
		// for (int i = 0; i < tc; i++) {
		// times[i] = sc.nextInt();
		// strs[i] = sc.next();
		// }
		//
		// for (int i = 0; i < tc; i++) {
		// for(int j = 0; j < strs[i].length(); j++) {
		// for(int k = 0; k < times[i]; k++) {
		// sb.append(strs[i].charAt(j));
		// }
		// }
		// System.out.println(sb);
		// sb.delete(0, sb.length());
		// }
		//
		
		//StringBuilder 쓰면 108 MS
		//안쓰고 바로 출력하면 132 MS
		
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < tc; i++) {
			int times = Integer.parseInt(sc.next());
			String text = sc.next();
			
			for (int j = 0; j < text.length(); j++) {
				for (int k = 0; k < times; k++) {
					sb.append(text.charAt(j));
				}
			}
			sb.append(System.lineSeparator());
		}
		System.out.println(sb);
		sc.close();
	}

}
