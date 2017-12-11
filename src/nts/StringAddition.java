package nts;

import java.security.Timestamp;
import java.util.Scanner;

//4번 문제 : addition("123", "46")의 결과가 169가 출력되게 하시오. 단 Integer.parseInt() 함수를 쓰지 말것.

public class StringAddition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int result = addition("123", "46");
		
		System.out.println(result);
	}

	private static int addition(String str1, String str2) {
		
		int result1 = 0;
		int result2 = 0;
		
		for(int i = 0; i < str1.length(); i++) {
			int time = (int)Math.pow(10, str1.length() - i - 1);
			result1 += (str1.charAt(i) - '0') * time;
		}
		
		for(int i = 0; i < str2.length(); i++) {
			int time = (int)Math.pow(10, str2.length() - i - 1);
			result2 += (str2.charAt(i) - '0') * time;
		}
		
		return result1 + result2;
	}

}
