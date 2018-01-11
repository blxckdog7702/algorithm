package 백준.소수구하기;

import java.util.Scanner;

//9020번(골드바흐의 추측)

public class Goldbach {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		int input = 0;
		int small = 0;
		int big = 0;
		
		for(int i = 0; i < tc; i++) {
			input = sc.nextInt();
			
			//중간값에서 +-n 해가면서 소수를 찾는다.
			for(int j = 0; j < input / 4; j++) {
				small = input / 2 - j;
				big = input / 2 + j;
				
				if(small + big == input && isPrime(small) && isPrime(big)) {
					System.out.println(small + " " + big);
					break;
				}
			}
		}
		
		sc.close();
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
