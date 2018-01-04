package 백준.조건문;

import java.util.Scanner;

//1110번(더하기 사이클)

public class PlusCycle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		sc.close();
		
		int count = 0;
		int next = (input % 10) * 10 + ((input / 10) + (input % 10)) % 10;
		
		while(input != next) {
			next = (next % 10) * 10 + ((next / 10) + (next % 10)) % 10;
			count++;
		}
		
		System.out.println(count + 1);
	}

}
