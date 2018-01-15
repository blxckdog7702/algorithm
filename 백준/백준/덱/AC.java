package 백준.덱;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

//5430번(AC)

public class AC {
	Deque<Integer> deque;

	static int tc;

	String func;
	int leng;
	String input;
	boolean reverse;


	public AC() {
		func = null;
		leng = 0;
		input = null;
		reverse = false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < tc; i++) {
			AC ac = new AC();
			
			ac.setValues(sc);

			ac.deque = ac.stringToDeque();
			
			try {
				ac.excuteFunc();
			} catch (NoSuchElementException e) {
				System.out.println("error");
				continue;
			}

			ac.print();
		}
		
		sc.close();
	}

	private void print() {
		StringBuilder sb = new StringBuilder();

		if (reverse) {
			sb.append("[");
			
			for(int i = deque.size(); i > 0; i--) {
				if(i == 1) {
					sb.append(deque.removeLast());
					break;
				}
				sb.append(deque.removeLast() + ",");
			}
			
			sb.append("]");
			System.out.println(sb);
		} else {
			System.out.println(deque.toString().replace(" ", ""));
		}
		
	}

	private void setValues(Scanner sc) {
		func = sc.nextLine().replace("RR", "");
		leng = sc.nextInt();
		sc.nextLine();
		input = sc.nextLine();
	}

	private void excuteFunc() {
		for (int i = 0; i < func.length(); i++) {
			if (func.charAt(i) == 'R') {
				funcR();
			} else if (func.charAt(i) == 'D') {
				funcD();
			}
		}
	}

	private void funcD() {
		if (reverse) {
			deque.removeLast();
		} else {
			deque.removeFirst();
		}
	}

	private void funcR() {
		reverse = !reverse;
	}

	private Deque<Integer> stringToDeque() {
		Deque<Integer> deque = new LinkedList<>();
		
		String parse = this.input.replace("[", "").replace("]", "");

		//입력이 "[]"인 경우는 그대로 return
		if(parse.equals("")) {
			return deque;
		}
		
		String[] values = parse.split(",");

		for (int i = 0; i < values.length; i++) {
			deque.addLast(Integer.parseInt(values[i]));
		}

		return deque;
	}

}
