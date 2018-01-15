package 백준.피보나치;

import java.util.Scanner;

//2747번(피보나치 수)

public class Pibonacci {
	
	static int[] arr = new int[45];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		sc.close();
		
		System.out.println(pibo(num));
	}

	private static int pibo(int num) {
		if(num == 0) {
			return 0;
		}
		
		if(num == 1) {
			return 1;
		}
		
		if(arr[num - 2] == 0) {
			arr[num - 2] = pibo(num - 2);
		}
		
		if(arr[num - 1] == 0) {
			arr[num - 1] = pibo(num - 1);
		}
		
		return arr[num - 2] + arr[num - 1];
	}

}
