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
		
		//sort 메서드
		Arrays.sort(arr);
		
		Arrays.stream(arr).forEach((n) -> System.out.println(n));
		
		//삽입
//		int key = 0;
//		
//		for(int i = 0; i < arr.length; i++) {
//			
//		}

	}

}
