package 백준.동적계획법;

import java.util.Scanner;

public class ThreeKangol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[3];
		
		for(int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		
		int distance;
		
		if(arr[1] - arr[0] >= arr[2] - arr[1]) {
			distance = arr[1] - arr[0];
		} else {
			distance = arr[2] - arr[1];
		}
		
		System.out.println(distance - 1);
	}

}
