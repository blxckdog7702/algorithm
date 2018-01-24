package 백준.구현;

import java.util.Scanner;

//3053번(택시 기하학)

public class Taxi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		
		sc.close();
		
		double circle = r * r * Math.PI;
		double taxiCircle = r * r * 2;
		
		System.out.printf("%.6f", circle);
		System.out.println();
		System.out.printf("%.6f", taxiCircle);
	}

}
