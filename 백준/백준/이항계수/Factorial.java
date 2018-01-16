package 백준.이항계수;

import java.util.Scanner;

//10872번(팩토리얼)

public class Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();

		int[] arr = new int[100];

		int result = fac(arr, number);

		System.out.println(result);
		
		sc.close();
	}

	public static int fac(int[] arr, int number) {
		if(number == 0 || number == 1) {
			return 1;
		}
		
		if(arr[number] == 0) {
			arr[number] = fac(arr, number - 1) * number;
		}
		
		return arr[number];
	}

}
