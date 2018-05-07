package 백준.조건문;

import java.util.Scanner;

//9498번(시험 성적)

public class ExamResult {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		sc.close();
		
		String grade = "";
		
		if(score >= 90 && score <= 100) {
			grade = "A";
		} else if(score >= 80 && score <= 89) {
			grade = "B";
		} else if(score >= 70 && score <= 79) {
			grade = "C";
		} else if(score >= 60 && score <= 69) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		System.out.println(grade);
	}

}
