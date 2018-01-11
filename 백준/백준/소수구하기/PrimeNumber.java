package 백준.소수구하기;

import java.util.Scanner;

//2581번(소수)

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int small = sc.nextInt();
		int big = sc.nextInt();
		sc.close();
		
		int sum = 0;
		int min = 0;
		
		for(int i = small; i < big + 1; i++) {
			if(isPrime(i)) {
				sum += i;
				
				if(min == 0) {
					min = i;
				}
			}
		}
		
		if(sum == 0) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(sum);
		System.out.println(min);
	}

	// 소수 판별 메서드
	public static boolean isPrime(int num) {
		if (num == 1) {
			return false;
		}

		boolean result = true;

		int end = (int) Math.sqrt(num);
		for (int i = 2; i <= end; i++) {
			if (num % i == 0) {
				result = false;
				break;
			} else {
				result = true;
			}
		}
		return result;
	}
}
