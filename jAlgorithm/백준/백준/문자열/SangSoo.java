package 백준.문자열;

import java.util.Scanner;

//2908번(상수)

public class SangSoo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(num1) + String.valueOf(num2));
		sb.reverse();
		num1 = Integer.parseInt(sb.substring(0, 3));
		num2 = Integer.parseInt(sb.substring(3, 6));
		
		if(num1 > num2) {
			System.out.println(num1);
		} else {
			System.out.println(num2);
		}
	}

}
