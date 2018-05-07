package 백준.시뮬레이션;

import java.util.Scanner;

//10253번(헨리)

public class Henry {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			long numerator = sc.nextInt();
			long denominator = sc.nextInt();
			int count = 2;
			
			//방법 1
			while(numerator > 1) {
				long x = (long) denominator / numerator + 1;
				
				numerator = (numerator * x) - (denominator * 1);
				denominator *= x;
				
				long gcd = gcd(numerator, denominator);
				
				numerator /= gcd;
				denominator /= gcd;
			}
			
			System.out.println(denominator);

			//방법 2
//			while (numerator > 0) {
//				// Xn 발견
//				if (numerator * count >= denominator) {
//					// 원래 값 - 1/Xn
//					// 분자 계산
//					numerator = (numerator * count) - (denominator * 1);
//
//					// 분모 계산
//					denominator = denominator * count;
//					
//					System.out.println(1 + "/" + count);
//				}
//				count++;
//			}
//			System.out.println(count - 1);
		}
		sc.close();
	}

//	// 최대공약수
	public static long gcd(long a, long b) {
		long big = Math.max(a, b);
		long small = Math.min(a, b);

		long mod = big % small;

		while (mod > 0) {
			big = small;
			small = mod;
			mod = big % small;
		}

		return small;
	}
}
