package 백준.피보나치;

import java.util.Scanner;

//2749번(피보나치)
//1000000000000000000
//파사노 주기(100만) = 1500000

public class Main {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long input = sc.nextLong();

		int mod = 1000000;
		
		int period = mod / 10 * 15;

		int index = (int)(input % period);

		
		if(input < period) {
			period = (int) input;
			index = (int) input;
		}

		arr = new int[period + 1];

		arr[0] = 0;
		arr[1] = 1;

		for (int i = 2; i <= period; i++) {
			arr[i] = arr[i - 2] + arr[i - 1];
			arr[i] = arr[i] % mod;
		}
		System.out.println(arr[index]);
	}

}
