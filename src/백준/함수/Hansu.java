package 백준.함수;

import java.util.Scanner;

//1065번(한수)

public class Hansu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();

		if(input < 99) {
			System.out.println(input);
			return;
		}
		
		if (input < 111) {
			System.out.println(99);
			return;
		}

		int count = 99;

		int num1, num2, num3 = 0;

		for (int i = 111; i <= input; i++) {
			if(i == 1000) {
				break;
			}
			
			num1 = i / 100;
			num2 = (i % 100) / 10;
			num3 = i % 10;
			
			if(num2 - num1 == num3 - num2) {
				count++;
			}
		}
		
		System.out.println(count);
	}

}
