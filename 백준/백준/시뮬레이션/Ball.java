package 백준.시뮬레이션;

import java.util.Scanner;

//1547번(공)

public class Ball {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		int a;
		int b;
		
		int cupOnBall = 1;
		
		for(int i = 0; i < tc; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			if(a == cupOnBall) {
				cupOnBall = b;
			} else if(b == cupOnBall) {
				cupOnBall = a;
			}
			
		}
		
		System.out.println(cupOnBall);
		sc.close();
	}

}
