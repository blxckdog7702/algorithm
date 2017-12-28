package 백준.조건문;

import java.util.Scanner;

//10871번(X보다 작은 수)

public class SmallerThanX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int tc = sc.nextInt();
		int x = sc.nextInt();
		
		int temp = 0;
		
		for(int i = 0; i < tc; i++) {
			temp = sc.nextInt();
			
			if(temp < x) {
				System.out.print(" ");
				System.out.print(temp);
			}
		}
	}

}
