package mailProgamming;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int result = 0;
		
		int x = 1;
		int y = 2;
		
		while(x < n) {
			if(x % 2 == 0) {
				result += x;
			}
			
			int next = x + y;
			x = y;
			y = next;
		}
		
		System.out.println(result);
		sc.close();
	}

}
