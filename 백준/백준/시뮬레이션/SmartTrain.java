package 백준.시뮬레이션;

import java.util.Scanner;

//2455번(지능형기차)

public class SmartTrain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = 0;
		int passengers = 0;
		
		for(int i = 0; i < 4; i++) {
			passengers -= sc.nextInt();
			passengers += sc.nextInt();
			if(max < passengers) {
				max = passengers;
			}
		}
		
		System.out.println(max);
		
		sc.close();
	}

}
