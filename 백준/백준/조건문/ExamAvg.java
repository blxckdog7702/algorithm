package 백준.조건문;

import java.util.Scanner;

//1546번(평균)

public class ExamAvg {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int subject = sc.nextInt();

		float sum = 0;
		int temp = 0;
		float max = 0;
		
		float[] arr = new float[subject];

		for (int i = 0; i < subject; i++) {
			 temp = sc.nextInt();
			 arr[i] = temp;
			 
			if (temp > max) {
				max = temp;
			}
		}
		
		sc.close();
		
		for (int i = 0; i < subject; i++) {
			sum += (arr[i] / max * 100);
		}
		
		float avg = sum / subject;
		System.out.printf("%.2f", avg);
	}
}
