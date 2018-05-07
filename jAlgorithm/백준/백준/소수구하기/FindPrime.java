package 백준.소수구하기;

import java.util.Scanner;

//2518번(소수)

public class FindPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		int count = 0;
		
		for(int i = 0; i < tc; i++) {
			if(isPrime(sc.nextInt())) {
				count++;
			}
		}
		
		sc.close();
		
		System.out.println(count);
	}

	// 소수 판별 메서드
	public static boolean isPrime(int num) {
		if(num == 1) {
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
