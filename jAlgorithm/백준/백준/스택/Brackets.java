package 백준.스택;

import java.util.Scanner;
import java.util.Stack;

//9012번(괄호)

public class Brackets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();

		String input = null;
		
		for (int i = 0; i < tc; i++) {
			input = sc.nextLine();
			
			while(input.contains("()")) {
				input = input.replace("()", "");
			}
			
			if(input.equals("") ) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		sc.close();
	}

}
