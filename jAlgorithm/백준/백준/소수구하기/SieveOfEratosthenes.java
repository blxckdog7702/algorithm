package 백준.소수구하기;

import java.util.Scanner;

//1929번(소수구하기, 에라토스테네스의 체)

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = sc.nextInt();
		int max = sc.nextInt();
		sc.close();
		
		int[] arr = new int[max + 1];
		
		//2 ~ max 까지 초기화
		for(int i = 2; i <= max; i++) {
			arr[i] = i;
		}
		
		for(int i = 2; i <= max / 2; i++) {
			if(arr[i] == 0) {
				continue;
			}
			
			//2를 예로 들면, 2는 빼고 2의 배수들을 없애나가야 하니까
			for(int j = i * 2; j <= max; j += i) {
				arr[j] = 0;
			}
		}
		
		for(int i = min; i <= max; i++) {
			if(arr[i] != 0) {
				System.out.println(i);
			}
		}
		
		
	}

}
