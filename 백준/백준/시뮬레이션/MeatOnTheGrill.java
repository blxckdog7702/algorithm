package 백준.시뮬레이션;

import java.util.Scanner;

//10219번(Meat On The Grill)

public class MeatOnTheGrill {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0) {
			int row = sc.nextInt();
			sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < row; i++) System.out.println(new StringBuilder(sc.nextLine()).reverse());		
		}
		sc.close();
	}
}
