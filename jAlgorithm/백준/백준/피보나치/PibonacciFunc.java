package 백준.피보나치;

import java.util.Scanner;

//1003번(피보나치 함수)

public class PibonacciFunc {
	static int count0;
	static int count1;
	static int[] count0Arr = new int[41];
	static int[] count1Arr = new int[41];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		int input;

		count0Arr[0] = 1;
		count1Arr[1] = 1;

		for (int i = 0; i < tc; i++) {
			input = sc.nextInt();

			pibo1(input);
			pibo2(input);
			System.out.println(count0Arr[input] + " " + count1Arr[input]);
		}

		// for(int i = 0; i < tc; i++) {
		// input = sc.nextInt();
		//
		// count0 = 0;
		// count1 = 0;
		//
		// pibo(input);
		//
		// System.out.println(count0 + " " + count1);
		// }

		sc.close();
	}

	private static int pibo1(int num) {
		if (count0Arr[num] == 0 && count1Arr[num] == 0) {
			count0Arr[num] = count0Arr[num - 2] + count0Arr[num - 1];
			count1Arr[num] = count1Arr[num - 2] + count1Arr[num - 2];
		}
		
		if(num == 0) {
			return 1;
		}
		
		if(num == 1) {
			return 0;
		}

		if(count0Arr[num - 2] == 0) {
			count0Arr[num - 2] = pibo1(num - 2);
		}
		
		if(count0Arr[num - 1] == 0) {
			count0Arr[num - 1] = pibo1(num - 1);
		}
		
		count0Arr[num] = count0Arr[num - 2] + count0Arr[num - 1];
		
		return count0Arr[num - 2] + count0Arr[num - 1];
	}
	
	private static int pibo2(int num) {
		if(num == 0) {
			return 0;
		}
		
		if(num == 1) {
			return 1;
		}
		
		if(count1Arr[num - 2] == 0) {
			count1Arr[num - 2] = pibo2(num - 2);
		}
		
		if(count1Arr[num - 1] == 0) {
			count1Arr[num - 1] = pibo2(num - 1);
		}
		
		count1Arr[num] = count1Arr[num - 2] + count1Arr[num - 1];
		
		return count1Arr[num - 2] + count1Arr[num - 1];
	}

}
