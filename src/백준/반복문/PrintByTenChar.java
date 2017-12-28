package 백준.반복문;

import java.util.Scanner;

//11721번(열 개씩 끊어 출력하기)

public class PrintByTenChar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		for(int i = 0; i < input.length(); i++) {
			if(i % 10 == 0 && i != 0) {
				System.out.println();	
			}
			
			System.out.print(input.charAt(i));
		}
	}

}
