package 백준.시뮬레이션;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

//3163번(떨어지는 개미)

public class Ant2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			int num = sc.nextInt();
			int length = sc.nextInt();
			int k = sc.nextInt();

			Deque<Integer> antIds = new LinkedList<>();
			Queue<Integer> leftQueue = new LinkedList<>();
			Stack<Integer> rightStack = new Stack<>();

			// 개미 입력
			int position;
			int id;
			for (int j = 0; j < num; j++) {
				position = sc.nextInt();
				id = sc.nextInt();

				// 남은 거리는 방향에 따라서 다르게 계산
				if (id > 0) {
					rightStack.push(length - position);
				} else {
					leftQueue.add(position);
				}

				antIds.add(id);
			}

			int result = 0;

			while (k-- > 0) {
				if (leftQueue.isEmpty()) {
					result = antIds.removeLast();
					rightStack.pop();
				} else if (rightStack.isEmpty()) {
					result = antIds.removeFirst();
					leftQueue.remove();
				} else {
					if (leftQueue.peek() > rightStack.peek()) {
						result = antIds.removeLast();
						rightStack.pop();
					} else if (leftQueue.peek() < rightStack.peek()) {
						result = antIds.removeFirst();
						leftQueue.remove();
					} else {
						int leftId = antIds.getFirst();
						int rightId = antIds.getLast();

						if (leftId < rightId) {
							result = leftId;
							antIds.removeFirst();
							leftQueue.remove();
							continue;
						} else if (leftId > rightId) {
							result = rightId;
							antIds.removeLast();
							rightStack.pop();
							continue;
						}
					}
				}
			}

			System.out.println(result);
		}

		sc.close();
	}

}
