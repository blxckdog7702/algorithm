package 백준.브루트포스;

import java.util.Scanner;

//2231번(분해합)

public class DivideSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int temp = 0;
		int result = 0;
		
		for(int i = 1; i < n; i++) {
			temp = i;
			
			String digits = String.valueOf(i);
			
			for(int j = 0; j < digits.length(); j++) {
				temp += (digits.charAt(j) - '0');
			}
			
			if(temp == n) {
				result = i;
				break;
			}
		}
		
		System.out.println(result);
		
		
		sc.close();
	}

}
