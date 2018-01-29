package 백준.최대공최소공;

import java.util.Scanner;

//13241번(최소공배수)

public class Lcm2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(lcm(sc.nextInt(), sc.nextInt()));
		
		sc.close();
	}
	
	// 최소공배수
	public static long lcm(long a, long b) {
		long big = Math.max(a, b);
		long small = Math.min(a, b);

		long mod = big % small;

		while (mod > 0) {
			big = small;
			small = mod;
			mod = big % small;
		}

		return (a * b) / small;
	}

}
