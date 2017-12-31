package 백준.배열;

import java.util.Scanner;

//10039번(평균 점수)

public class AverageScore {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int input = 0;

		for (int i = 0; i < 5; i++) {
			input = sc.nextInt();

			if (input < 40) {
				sum += 40;
			} else {
				sum += input;
			}
		}
		
		System.out.println(sum / 5);
	}
}
