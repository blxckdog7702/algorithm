package 백준.덱;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//10866번(덱)

public class Deque {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		MyDeque myDeque = new MyDeque();
		
		String input = null;
		for (int i = 0; i < tc; i++) {
			input = sc.next();
			
			switch (input) {
			case "push_front":
				myDeque.pushFront(sc.nextInt());
				break;
			case "push_back":
				myDeque.pushBack(sc.nextInt());
				break;
			case "pop_front":
				System.out.println(myDeque.popFront());
				break;
			case "pop_back":
				System.out.println(myDeque.popBack());
				break;
			case "size":
				System.out.println(myDeque.size());
				break;
			case "empty":
				System.out.println(myDeque.empty());
				break;
			case "front":
				System.out.println(myDeque.front());
				break;
			case "back":
				System.out.println(myDeque.back());
				break;
			}
		}
		sc.close();
	}

}

class MyDeque {
	List<Integer> list;

	public MyDeque() {
		list = new LinkedList<>();
	}

	public void pushFront(int x) {
		list.add(0, x);
	}

	public void pushBack(int x) {
		list.add(list.size(), x);
	}

	public int popFront() {
		if (list.isEmpty()) {
			return -1;
		}

		int output = list.get(0);
		list.remove(0);

		return output;
	}

	public int popBack() {
		if (list.isEmpty()) {
			return -1;
		}

		int output = list.get(list.size() - 1);
		list.remove(list.size() - 1);

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
}
