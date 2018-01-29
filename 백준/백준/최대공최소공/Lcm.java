package 백준.최대공최소공;

import java.util.Scanner;

//1934번(최소공배수)

public class Lcm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i = 0; i < tc; i++) {
			System.out.println(lcm(sc.nextInt(), sc.nextInt()));
		}
		
		sc.close();
	}
	
	// 최소공배수
		public static int lcm(int a, int b) {
			int big = Math.max(a, b);
			int small = Math.min(a, b);

			int mod = big % small;

			while (mod > 0) {
				big = small;
				small = mod;
				mod = big % small;
			}

			return (a * b) / small;
		}

}
