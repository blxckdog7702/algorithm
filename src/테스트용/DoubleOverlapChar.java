package 테스트용;

import java.util.Stack;

public class DoubleOverlapChar {

	public static void main(String[] args) {
		String input = "aabbccaabb";

		System.out.println(solution(input));
	}

	private static int solution(String s) {
        int answer = 0;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if(stack.empty()) {
				stack.add(s.charAt(i));
				continue;
			}
			
			if(stack.peek() == s.charAt(i)) {
				stack.pop();
			} else {
				stack.add(s.charAt(i));
			}
		}
		
		if(stack.isEmpty()) {
			answer = 1;
		} else {
			answer = 0;
		}
		
		return answer;
		
	}

}
