package 백준.시뮬레이션;

import java.util.Scanner;

//1094번(막대기)

public class Stick {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		sc.close();
		
		int mod = 64;
		int count = 0;
		
		while(mod > 0) {
			if(x >= mod) {
				x -= mod;
				count++;
			} else {
				mod /= 2;
			}
		}
		
		System.out.println(count);
	}

}
