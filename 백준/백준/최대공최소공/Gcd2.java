package 백준.최대공최소공;

import java.util.Scanner;

//1850번(최대공약수)

public class Gcd2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long small = sc.nextLong();
		long big = sc.nextLong();
		
		System.out.println(makeNumber(gcd(small,big)));

		sc.close();
	}

	// 최대공약수
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

	private static String makeNumber(long a) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < a; i++) {
			sb.append(1);
		}

		return sb.toString();
	}
}
