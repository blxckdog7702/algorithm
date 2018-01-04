package 백준.배열;

import java.util.Scanner;

//2920번(음계)

public class Scale {
	public static void main(String[] args) {
		int[] arr = new int[8];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		if (arr[0] != 1 && arr[0] != 8) {
			System.out.println("mixed");
			return;
		}

		if (arr[0] == 1) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i + 1] - arr[i] != 1) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("ascending");
			return;
		}

		if (arr[0] == 8) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] - arr[i + 1] != 1) {
					System.out.println("mixed");
					return;
				}
			}
			System.out.println("descending");
			return;
		}
	}
}
