package 백준.트리;

import java.util.Scanner;
import java.util.Stack;

//11725번(트리의 부모 찾기)

public class FindParents {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		int[] parentArr = new int[tc + 1];
		parentArr[1] = 1;

		Stack<Pair> stack1 = new Stack<Pair>();
		Stack<Pair> stack2 = new Stack<Pair>();

		for (int i = 1; i < tc; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();

			if (parentArr[first] > 0) {
				parentArr[second] = first;
			} else if (parentArr[second] > 0) {
				parentArr[first] = second;
			} else {
				stack1.push(new Pair(first, second));
			}
		}

		sc.close();

		Stack<Pair> currentStack = null;
		Stack<Pair> nextStack = null;

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			if (stack1.isEmpty()) {
				currentStack = stack2;
				nextStack = stack1;
			} else if (stack2.isEmpty()) {
				currentStack = stack1;
				nextStack = stack2;
			}

			Pair top = currentStack.peek();

			if (parentArr[top.first] > 0) {
				parentArr[top.second] = top.first;
				currentStack.pop();
			} else if (parentArr[top.second] > 0) {
				parentArr[top.first] = top.second;
				currentStack.pop();
			} else {
				nextStack.push(currentStack.pop());
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 2; i < parentArr.length; i++) {
			sb.append(parentArr[i]);
			sb.append(System.lineSeparator());
		}

		System.out.println(sb);
	}

}

class Pair {
	int first;
	int second;

	public Pair(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
