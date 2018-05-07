package 백준.정렬;

import java.util.Scanner;

//1427번(소트인사이드)

public class SortInside {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		int[] arr = new int[10];
		
		for(int i = 0; i < input.length(); i++) {
			int number = input.charAt(i) - '0';
			
			arr[number]++;
		}
		
		for(int i = arr.length - 1; i >= 0; i--) {
			while(arr[i] != 0) {
				arr[i]--;
				System.out.print(i);
			}
		}
	}

}
