package 백준.피보나치;

import java.util.Scanner;

//2748번(피보나치 수2)

public class Pibonacci2 {
	static long[] arr = new long[91];

		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			int num = sc.nextInt();
			
			sc.close();
			
			//시간은 똑같음
//			arr[1] = 1;
//			
//			for(int i = 2; i < num + 1; i++) {
//				arr[i] = arr[i - 2] + arr[i - 1]; 
//			}
//			
//			System.out.println(arr[num]);
			
			System.out.println(pibo(num));
	}
		private static long pibo(int num) {
			if(num == 0) {
				return 0;
			}
			
			if(num == 1) {
				return 1;
			}
			
			if(arr[num - 2] == 0) {
				arr[num - 2] = pibo(num - 2);
			}
			
			if(arr[num - 1] == 0) {
				arr[num - 1] = pibo(num - 1);
			}
			
			return arr[num - 2] + arr[num - 1];
		}
}
