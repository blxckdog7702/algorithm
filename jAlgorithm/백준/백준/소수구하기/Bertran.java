package 백준.소수구하기;

import java.util.Scanner;

//4948번(베르트랑 공준)

public class Bertran {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int input = sc.nextInt();
			
			if(input == 0) {
				break;
			}
			
			int count = 0;
			
			//i <= input * 2지만 = 연산을 쓰지 않기 위해서 다음과 같이 코딩
			for(int i = input + 1; i < input * 2 + 1; i++ ) {
				if(isPrime(i)) {
					count++;
				}
			}
			
			System.out.println(count);
			
		}
		
		sc.close();
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
