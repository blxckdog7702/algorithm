package 백준.스택;

import java.util.ArrayList;
import java.util.Scanner;

//10828번(스택)

public class StackExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		sc.nextLine();

		MyStack stack = new MyStack();

		for (int i = 0; i < tc; i++) {
			switch (sc.next()) {
			case "push":
				stack.push(sc.nextInt());
				sc.nextLine();
				break;
			case "pop":
				System.out.println(stack.pop());
				break;
			case "top":
				System.out.println(stack.top());
				break;
			case "size":
				System.out.println(stack.getSize());
				break;
			case "empty":
				System.out.println(stack.empty());
				break;
			}
		}
		
		sc.close();
	}
}

class MyStack {
	ArrayList<Integer> list;
	int size;

	public MyStack() {
		list = new ArrayList<>();
		size = 0;
	}

	public void push(int x) {
		list.add(x);
		size++;
	}

	public int pop() {
		if (size < 1) {
			return -1;
		}

		int item = list.get(size - 1);
		list.remove(size - 1);
		size--;

		return item;
	}

	public int getSize() {
		return size;
	}

	public int empty() {
		if (size == 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public int top() {
		if (size < 1) {
			return -1;
		}

		return list.get(size - 1);
	}
}
