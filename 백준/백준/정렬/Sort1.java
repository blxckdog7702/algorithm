package 백준.정렬;

import java.util.Arrays;
import java.util.Scanner;

//2750번(수 정렬하기)

public class Sort1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		int[] arr = new int[tc];

		for (int i = 0; i < tc; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();

		// sort() 메서드를 이용한 정렬
		// Arrays.sort(arr);

		// 선택 정렬
		// 시간복잡도 O(n^2) 공간복잡도 O(n)
		// int minIndex = 0;
		// for(int i = 0; i < arr.length; i++) {
		// minIndex = i;
		// for(int j = i + 1; j < arr.length; j++) {
		// if(arr[minIndex] > arr[j]) {
		// minIndex = j;
		// }
		// }
		// swap(arr, i, minIndex);
		// }

		// 삽입 정렬
		// 최악 시간복잡도 O(n^2) 공간복잡도 O(n)
		// int target = 0;
		// int key = 0;
		// for (int i = 1; i < arr.length; i++) {
		// key = arr[i]; target = i - 1;
		//
		// while(target >= 0 && key < arr[target]) {
		// arr[target + 1] = arr[target];
		// target--;
		// }
		// arr[target + 1] = key;
		// }

		// 버블 정렬
		// 시간복잡도 O(n^2)
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 1; j < arr.length - i; j++) {
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
				}
			}
		}

		// 출력
		Arrays.stream(arr).forEach((n) -> System.out.println(n));

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
