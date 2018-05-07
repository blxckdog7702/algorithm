package mailProgamming;

import java.util.Arrays;
import java.util.Scanner;

//정수(int)가 주어지면, 팰린드롬(palindrome)인지 알아내시오.
//팰린드롬이란, 앞에서부터 읽으나 뒤에서부터 읽으나 같은 단어를 말합니다. 단, 정수를 문자열로 바꾸면 안됩니다.

//예제)
//Input: 12345
//Output: False
//
//Input: -101
//Output: False
//
//Input: 11111
//Output: True
//
//Input: 12421
//Output: True

public class Question4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input = sc.nextInt();
		sc.close();

		if (input < 0) {
			System.out.println("False");
			return;
		}

		int length = 0;

		int temp = input;
		while (temp > 0) {
			temp /= 10;
			length++;
		}
		
		int[] arr = new int[length];

		boolean check = true;
		
		for(int i = 0; i < length; i++) {
			arr[i] = input % 10;
			input /= 10;
		}
		
		System.out.println(Arrays.toString(arr));
		
		for(int i = 0; i <= arr.length / 2; i++) {
			if(arr[i] != arr[arr.length -1 - i]) {
				check = false;
				break;
			}
		}
		
		System.out.println(check);
	}

}
