package level5;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 3503. 초보자를 위한 점프대 배치하기 

public class JumpStand {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for(int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			Deque<Integer> deque = new LinkedList<>();
			
			deque.add(arr[0]);
			
			for(int j = 1; j < n; j++) {
				if(j % 2 == 0) {
					deque.addLast(arr[j]);
				} else {
					deque.addFirst(arr[j]);
				}
			}
			
			Integer[] result;
			
			int max = 0;
			
			result = deque.toArray(new Integer[0]);
			
			for(int j = 1; j < n; j++) {
				if(j == n - 1) {
					max = Math.max(max, Math.abs(result[j] - result[0]));
				} else {
					max = Math.max(max, Math.abs(result[j] - result[j + 1]));
				}
			}
			
			System.out.println(max);
		}
		
		sc.close();
	}
}
