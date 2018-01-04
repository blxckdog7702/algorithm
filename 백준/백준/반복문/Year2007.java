package 백준.반복문;

import java.util.Scanner;

//1924번(2007년)

public class Year2007 {
	public static void main(String[] args) {
		String[] weekDays = new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int[] days = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		
		Scanner sc = new Scanner(System.in);
		int mon = sc.nextInt();
		int day = sc.nextInt();

		sc.close();
		
		int sum = 0;
		
		for(int i = 0; i < mon - 1; i++) {
			sum += days[i];
		}
		
		sum += day;

		System.out.println(weekDays[sum % 7]);
	}
}
