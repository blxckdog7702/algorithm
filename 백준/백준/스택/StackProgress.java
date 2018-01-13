package 백준.스택;

import java.util.Scanner;
import java.util.Stack;

//1874(스택 수열)

public class StackProgress {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		int[] arr = new int[tc];

		for (int i = 0; i < tc; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();

		Stack<Integer> stack = new Stack<>();
		int index = 0;

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= tc; i++) {
			stack.push(i);
			sb.append("+");
			sb.append(System.lineSeparator());

			// 일치
			while (!stack.empty() && stack.peek() == arr[index]) {
				stack.pop();
				index++;
				sb.append("-");
				sb.append(System.lineSeparator());
			}
			// 비교하는 수가 top 보다 크기 때문에 계속 push를 해야하는 케이스
			if (!stack.empty() && stack.peek() < arr[index]) {
				continue;
			}
			// 비교하는 수가 top 보다 작기 때문에 계속 pop을 해야하는 케이스
			else if (!stack.empty() && stack.peek() > arr[index]) {
				while (stack.peek() != arr[index]) {
					stack.pop();
					sb.append("-");
					sb.append(System.lineSeparator());
				}
			}
		}

		if(stack.isEmpty()) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}

	}

}
