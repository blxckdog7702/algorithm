package 백준.피보나치;

import java.util.Scanner;

//2749번(피보나치 수3)
//1000000000000000000
//파사노 주기(100만) = 1500000
//파사노 주기 k(m)은 k > 2라면, k(10^n) = 15 * 10^(n-1) 

public class Pibonacci3 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long input = sc.nextLong();
		
		sc.close();

		int mod = 1000000;
		
		int period = 15 * mod / 10 ;

		//나머지가 k(100만) = 150만 로 반복되니까 index를 하나 정한다.
		int index = (int)(input % period);

		// 입력받은 수가 k(100만)보다 작다면 아래 for문을 100만 까지 돌릴 필요 없이, input까지만 실행한다.
		if(input < period) {
			period = (int) input;
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
