package 백준.정렬;

import java.util.Scanner;

//2108번(통계학)

public class Statistics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		int[] arr = new int[tc];
		int[] countArr = new int[8001];

		// 산술 평균에 필요한 합계
		float sum = 0;

		// 최빈값에 필요한 최대 빈도, 최대 빈도의 index
		int countMax = 0;
		int countMaxIndex = 0;
		int sameCount = 0;

		// 범위에 필요한 최대, 최소 값
		int max = -4000;
		int min = 4000;

		// 입력값 저장에 쓸 임시변수
		int input = 0;

		for (int i = 0; i < tc; i++) {
			input = sc.nextInt();

			// 값 입력
			arr[i] = input;

			// 산술평균
			sum += input;

			// 숫자의 개수 카운트
			countArr[input + 4000]++;

			// 범위
			if (input > max) {
				max = input;
			}

			if (input < min) {
				min = input;
			}

		}
		
		for(int i = 0; i < countArr.length; i++) {
			// 최빈값
			if (countArr[i] > countMax) {
				countMax = countArr[i];
				countMaxIndex = i - 4000;
				sameCount = 1;
			} else if(sameCount == 1 && countArr[i] == countMax) {
				countMaxIndex = i - 4000;
				sameCount = 2;
			}
		}

		sc.close();

		// 산술 평균
		System.out.printf("%.0f", sum / tc);
		System.out.println();

		countSort(arr, countArr);

		// 최빈값
		System.out.println(countMaxIndex);

		// 범위
		System.out.println(max - min);
	}

	private static void countSort(int[] arr, int[] countArr) {
		// 누적합 만들기
		for (int i = 1; i < countArr.length; i++) {
			countArr[i] += countArr[i - 1];
		}

		// System.out.println(Arrays.toString(countArr));

		// 중간 값
		for (int i = 0; i < countArr.length; i++) {
			if (countArr[i] >= (arr.length / 2) + 1) {
				System.out.println(i - 4000);
				break;
			}
		}
	}

}
