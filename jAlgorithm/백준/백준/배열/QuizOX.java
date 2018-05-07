package 백준.배열;

import java.util.Scanner;

//8958번(OX퀴즈)

public class QuizOX {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();
		
		int score;
		int sum;
		
		for(int i = 0; i < tc; i++) {
			String input = sc.nextLine();
			
			score = 0;
			sum = 0;
			
			for(int j = 0; j < input.length(); j++) {
				if(input.charAt(j) == 'O') {
					score++;
					sum += score;
				} else {
					score = 0;
				}
			}
			
			System.out.println(sum);
		}
		
		sc.close();
	}

}
