package nts;

import java.util.Arrays;

//3번 문제 : first second 문자 배열이 주어질 때, 두 배열의 중복된 문자들을 가진 char[]를 리턴하라
//다만 리턴되는 char[] 안에는 중복되는 문자열이 없어야한다.
//최적과 최악의 경우를 모두 구현하고 설명하시오.
//입력값 검증 없음.

public class DuplicateChecker {

	public static void main(String[] args) {
		char[] first = new char[] { 'a', 'b', 'c' };
		char[] second = new char[] { 'c', 'd', 'e', 'b', 'c', 'f' };

		char[] result = duplicateCheck(first, second);
		
		//이렇게 해도 알아서 bc로 찍힌다.
		System.out.println(result);
	}

	//최적?
	//최악은 일일이 매칭 m*n;
	private static char[] duplicateCheck(char[] first, char[] second) {
		char[] result = new char[10];
		int[] count1 = new int[26];
		int[] count2 = new int[26];

		int index = 0;
		for (int i = 0; i < first.length; i++) {
			index = (int) (first[i] - 'a');
			count1[index]++;
		}

		for (int i = 0; i < second.length; i++) {
			index = (int) (second[i] - 'a');
			count2[index]++;
		}

		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (count1[i] > 0 && count2[i] > 0) {
				result[count] = (char) (i + 'a');
				count++;
			}
		}

		return result;
	}

}
