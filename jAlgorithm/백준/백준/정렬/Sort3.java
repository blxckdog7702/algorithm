package 백준.정렬;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

//10989번(수 정렬하기3)

public class Sort3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		
		Set<Integer> set = new TreeSet<>();
		int[] countArr = new int[10001];

		int input;
		
		for(int i = 0; i < tc; i++) {
			input = sc.nextInt();
			countArr[input]++;
			
			//검사 해주는게 메모리 절약에 도움이된다.
			if(!set.contains(input)) {
				set.add(input);	
			}
		}
		
		sc.close();
		
		
		//계수 정렬(count sort)
		//시간복잡도 O(n + k) k는 정렬할 숫자들 중 가장 큰 값.
		//n이 10일 때, k가 100이면 O(n^2)
		countSort(set, countArr);
		
//		printSortedArr(sorted);
	}

	private static void countSort(Set<Integer> set, int[] countArr) {
		//각 숫자의 개수 세기
//		for(int i = 0; i < arr.length; i++) {
//			countArr[arr[i]]++;
//		}
//		System.out.println(Arrays.toString(countArr));	

		//누적합 만들기
//		for(int i = 1; i < countArr.length; i++) {
//			countArr[i] += countArr[i - 1];
//		}
		
//		System.out.println(Arrays.toString(countArr));	
		
		StringBuilder sb = new StringBuilder();
		
		for(int number : set) {
			while(countArr[number] != 0) {
				sb.append(number);
				sb.append(System.lineSeparator());
				countArr[number]--;
			}
		}
		
		System.out.println(sb);
		
//		int number = 0;
		//원본 배열의 뒤부터 탐색. 만나는 숫자의 누적합을 통해 인덱스를 구해서 넣는다.
//		for(int i = arr.length - 1; i >= 0; i--) {
//			number = arr[i];
//			sorted[countArr[number] - 1] = number;
//			countArr[number]--;
//		}
	}
	
	private static void printSortedArr(int[] sorted) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < sorted.length; i++) {
			sb.append(sorted[i]);
			sb.append(System.lineSeparator());
		}
		
		System.out.println(sb);
	}
}
