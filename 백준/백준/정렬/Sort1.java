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
		
		// 삽입 정렬
		int target = 0;
		int key = 0;
		for (int i = 1; i < arr.length; i++) {
			key = arr[i]; target = i - 1;
			
			while(target >= 0 && key < arr[target]) {
				arr[target + 1] = arr[target];
				target--;
			}
			arr[target + 1] = key;
		}

		// 출력
		Arrays.stream(arr).forEach((n) -> System.out.println(n));

	}
}
