package 백준.반복문;

import java.util.Scanner;

//11720번(숫자의 합)

public class SumOfNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfInput = sc.nextInt();
		sc.nextLine();
		
		String input = sc.nextLine();
		
		sc.close();
		
		int sum = 0;
		
		for(int i = 0; i < numOfInput; i++) {
			sum += input.charAt(i) - '0';
		}
		
		System.out.println(sum);
	}

}
