package 백준.입출력;

import java.util.Scanner;

//11718번 : 그대로 출력하기

public class SameInOut {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		
		sc.close();
	}
}
