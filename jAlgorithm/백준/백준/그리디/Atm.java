package 백준.그리디;

import java.util.Arrays;
import java.util.Scanner;

//11399번(그리디)

public class Atm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int sum = 0;
		int arr[] = new int[tc];

		for (int i = 0; i < tc; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		for (int i = 0; i < tc; i++) {
			sum += (tc - i) * arr[i];
		}
		System.out.println(sum);
	}
}
