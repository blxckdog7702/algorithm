package 백준.큐;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//10845번(큐)

public class MyQueue {
	List<Integer> list;

	public MyQueue() {
		list = new LinkedList<>();
	}

	public void push(int x) {
		list.add(x);
	}

	public int pop() {
		if (list.isEmpty()) {
			return -1;
		}

		int output = list.get(0);

		list.remove(0);
		return output;
	}

	public int size() {
		return list.size();
	}

	public int empty() {

		if (list.isEmpty()) {
			return 1;
		} else {
			return 0;
		}
	}

	public int front() {
		if (list.isEmpty()) {
			return -1;
		}

		return list.get(0);
	}

	public int back() {
		if (list.isEmpty()) {
			return -1;
		}

		return list.get(list.size() - 1);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();
		
		MyQueue q = new MyQueue();

		String input = null;
		
		for (int i = 0; i < tc; i++) {
			input = sc.next();

			switch (input) {
			case "push":
				int number = sc.nextInt();
				q.push(number);
				break;
			case "pop":
				System.out.println(q.pop());
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				System.out.println(q.empty());
				break;
			case "front":
				System.out.println(q.front());
				break;
			case "back":
				System.out.println(q.back());
				break;
			}
		}
		
		sc.close();

	}

}
