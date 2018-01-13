package 백준.스택;

import java.util.Scanner;
import java.util.Stack;

//2504번(괄호의 값)

public class BracketsValue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		sc.close();

		Stack<String> stack = new Stack<>();

		for (int i = 0; i < input.length(); i++) {
			// 여는 괄호일 땐 그냥 push 한다.
			if (isOpen(input.charAt(i))) {
				stack.push(input.charAt(i) + "");
			}

			// 닫는 괄호일 때는 2가지 케이스가 있다.
			if (isClose(input.charAt(i))) {
				if (!stack.isEmpty()) {

					// top과 새로 들어오는 괄호가 짝이면 pop하고 숫자로 대체한다.
					if (isRightPair(stack.peek(), input.charAt(i) + "")) {
						stack.pop();
						
						// 연달아 숫자가 있는 케이스는 체크 후 합쳐준다.
						if(!stack.isEmpty() && isNumeric(stack.peek())) {
							int previousValue = Integer.parseInt(stack.pop());
							int currentValue = Integer.parseInt(getBracketValue(input.charAt(i)));
							stack.push(String.valueOf(currentValue + previousValue));
						} else {
							stack.push(getBracketValue(input.charAt(i)));
						}
						
					}

					// top이 정수일 때,
					else if (isNumeric(stack.peek())) {
						// top - 1이 새로 들어오는 괄호와 짝이면 top과 괄호 값을 곱해서 push
						if (isRightPair(stack.get(stack.size() - 2), input.charAt(i) + "")) {
							int temp = Integer.parseInt(stack.pop());
							temp *= Integer.parseInt(getBracketValue(input.charAt(i)));

							// 여는 괄호 삭제
							stack.pop();

							// 숫자가 연달아 있는 경우는 + 처리해서 정리한다.
							if (!stack.isEmpty() && isNumeric(stack.peek())) {
								temp += Integer.parseInt(stack.pop());
							}

							stack.push(String.valueOf(temp));
						}
					}
				}
			}
		}
		int sum = 0;

		// 스택 내부의 숫자들을 모두 모아 하나로 합친다.
		for (String s : stack) {
			// 숫자가 아닌 괄호가 남아있다면 괄호 짝이 맞지 않는 케이스다.
			if (!isNumeric(s)) {
				System.out.println(0);
				return;
			}

			sum += Integer.parseInt(s);
		}

		System.out.println(sum);
	}

	// String이 숫자인지 알아내는 메서드
	private static boolean isNumeric(String text) {
		try {
			int temp = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return false;
		}

		return true;
	}

	// 열린 괄호 체크 메서드.
	private static boolean isOpen(char bracket) {
		if (bracket == '(' || bracket == '[') {
			return true;
		}

		return false;
	}

	// 닫힌 괄호 체크 메서드.
	private static boolean isClose(char bracket) {
		if (bracket == ')' || bracket == ']') {
			return true;
		}

		return false;
	}

	// () 일때는 2, [] 일때는 3을 리턴하는 메서드.
	private static String getBracketValue(char bracket) {
		if (bracket == '(' || bracket == ')') {
			return "2";
		} else {
			return "3";
		}
	}

	// 괄호 짝 검사 메서드.
	private static boolean isRightPair(String open, String close) {
		if (open.equals("(") && close.equals(")")) {
			return true;
		} else if (open.equals("[") && close.equals("]")) {
			return true;
		}

		return false;
	}

}
