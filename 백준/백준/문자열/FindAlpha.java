package 백준.문자열;

import java.util.Arrays;
import java.util.Scanner;

public class FindAlpha {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine();
//		sc.close();
//
//		int[] arr = new int[26];
//		Arrays.fill(arr, -1);
//		
//		for(int i = 0; i < input.length(); i++) {
//			int index = (int)input.charAt(i) - 'a';
//			
//			if(arr[index] == -1) {
//				arr[index] = i;
//			}
//		}
//		
//		Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
		
		
		Scanner scan = new Scanner(System.in);
		String text = scan.next();
		for(int i = 97; i <= 122; i++) {
			System.out.print(text.indexOf(i) + " ");
		}
		scan.close();
	}

}
