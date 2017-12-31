package 백준.배열;

import java.util.Scanner;

//2577번(숫자의 개수)

public class NumOfNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();

		sc.close();

		int[] result = new int[10];

		String calcResult = String.valueOf(num1 * num2 * num3);
		
		for(int i = 0; i < calcResult.length(); i++) {
			result[calcResult.charAt(i) - '0']++;
		}
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
