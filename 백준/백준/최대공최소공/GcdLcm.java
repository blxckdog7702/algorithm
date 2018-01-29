package 백준.최대공최소공;

import java.util.Scanner;

//2609번(최대공약수와 최소공배수)

public class GcdLcm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int gcd = gcd(a,b);
		
		System.out.println(gcd);
		System.out.println((a * b) / gcd);
		
		sc.close();
	}
	
	// 최대공약수
		public static int gcd(int a, int b) {
			int big = Math.max(a, b);
			int small = Math.min(a, b);

			int mod = big % small;

			while (mod > 0) {
				big = small;
				small = mod;
				mod = big % small;
			}

			return small;
		}

}
