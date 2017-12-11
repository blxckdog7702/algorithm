package nts;

//4번 문제 : 1q2w3e4r 식으로 숫자문자 꼴로 입력했을 때, qwweeerrrr처럼 출력하게 구현하시오.
//입력값 검증 없음

public class CharacterRepeater {

	public static void main(String[] args) {
		String input = "1q2w3e4r";

		String result = repeater(input);
		
		System.out.println(result);
	}

	private static String repeater(String input) {
		StringBuilder sb = new StringBuilder();
		
		int time;
		
		for(int i = 0; i < input.length(); i++) {
			if(i % 2 == 0) {
				time = input.charAt(i) - '0';
				for(int j = 0; j < time; j++) {
					sb.append(input.charAt(i + 1));
				}
			}
		}
		
		return sb.toString();
	}

}
