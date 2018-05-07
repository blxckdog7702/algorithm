package 백준.조건문;

import java.util.Scanner;

//4344번(평균은 넘겠지)

public class AverageOver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			int numOfStudent = sc.nextInt();
			int[] arr = new int[numOfStudent];
			float sum = 0;

			for (int j = 0; j < numOfStudent; j++) {
				arr[j] = sc.nextInt();
				sum += arr[j];
			}

			float avg = sum / numOfStudent;

			int count = 0;

			for (int j = 0; j < numOfStudent; j++) {
				if (arr[j] > avg) {
					count++;
				}
			}
			
			System.out.printf("%.3f", (float) count / numOfStudent * 100);
			System.out.print("%");
			System.out.println();
		}
		sc.close();

	}

}
