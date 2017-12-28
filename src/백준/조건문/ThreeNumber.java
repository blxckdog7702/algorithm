package 백준.조건문;

import java.util.Arrays;
import java.util.Scanner;

//10817번(세 수)

public class ThreeNumber {
	public static void main(String[] args) {
		int[] arr = new int[3];
		
		Scanner sc = new Scanner(System.in); 
		
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(arr);
		
		System.out.println(arr[1]);
	}
}
