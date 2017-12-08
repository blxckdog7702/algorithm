package nts;

import java.util.Scanner;

//1번문제 : 변수 표기법 중, 단어를 기점으로 this_is_snake_case 처럼 표기하는 것을 snake 표기법이라 하고,
//thisIsCamelCase와 같이 표기하는 것을 camel 표기법이라고 한다. input에 snake 표기법이 주어지면 camel로, camel 일 때는
//snake로 변환하는 메서드를 작성하시오.
//입력값 검증은 하지 않는다.


public class CaseConverter {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// String input = sc.nextLine();
		String input = "is_contain_parameter";
//		String input = "isContainParameter";

		caseConverter(input);
	}

	private static void caseConverter(String input) {
		String result = "";
		StringBuilder temp = new StringBuilder();
		String[] words;

		if (input.contains("_")) {
			words = input.split("_");

			temp.append(words[0]);

			for (int i = 1; i < words.length; i++) {
				//String의 특정 위치에 set하는 방법
				//방법 1 substring + set할 문자 + 나머지 subString 이어붙이기
				temp.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1, words[i].length()));
				//방법 2 stringBuilder.setCharAt(index, '?');
			}
		} else {
			//정규식
//			words = input.split("[A-Z]");
			for (int i = 0; i < input.length(); i++) {
				if(input.charAt(i) - 'A' >= 0 && input.charAt(i) - 'A' <= 25) {
					temp.append("_" + (char)(input.charAt(i) + 32)); 
				} else {
					temp.append(input.charAt(i));
				}
			}
			
		}

		result = temp.toString();
		System.out.println(result);
	}
}
