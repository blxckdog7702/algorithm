package nts;

import java.util.Stack;

//2번 문제 : 소중대괄호( '(', ')', '{', '}', '[', ']')가 짝에 맞게 열고 닫혔는지 true/false로 반환하는
//메서드를 구현하시오.
//입력값 검증은 하지 않는다.

public class BraketChecker {

	public static void main(String[] args) {
		String input = "1 + [(1 + 4 {) } ]";
		
		boolean result = braketCheck(input);
		
		System.out.println(result);
	}

	private static boolean braketCheck(String input) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < input.length(); i++) {
			if(isBraket(input.charAt(i))) {
				
				
				if(input.charAt(i) == ')' && stack.peek() == '(') {
					stack.pop();
					continue;
				}
				
				if(input.charAt(i) == '}' && stack.peek() == '{') {
					stack.pop();
					continue;
				}
				
				if(input.charAt(i) == ']' && stack.peek() == '[') {
					stack.pop();
					continue;
				}
				
				stack.push(input.charAt(i));
			}
		}
		
		if(stack.size() == 0) {
			return true;
		}
		
		return false;
	}

	private static boolean isBraket(char c) {
		if(c == '(' || c == ')' || c == '{' || c == '}' || c == '[' || c == ']') {
			return true;
		}
		
		return false;
	}
	
}
