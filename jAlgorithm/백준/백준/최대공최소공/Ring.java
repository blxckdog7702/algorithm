package 백준.최대공최소공;

import java.util.Scanner;

//3036번(링)

public class Ring {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		int[] arr = new int[tc];

		for (int i = 0; i < tc; i++) {
			arr[i] = sc.nextInt();
		}
		
		int gcd = 0;
		
		for (int i = 1; i < tc; i++) {
			gcd = gcd(arr[0], arr[i]);
			System.out.print(arr[0] / gcd);
			System.out.print("/");
			System.out.println(arr[i] / gcd);
		}

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
