package 백준.덱;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//1021번(회전하는 큐)

public class CircularQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 원소의 갯수
		int n = sc.nextInt();

		// 뽑아내려는 원소의 갯수
		int m = sc.nextInt();

		// 덱 초기화
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			deque.addLast(i);
		}

		// 삭제 목록 만들기
		int[] deleteList = new int[m];

		for (int i = 0; i < m; i++) {
			deleteList[i] = sc.nextInt();
		}

		int deleteIndex = 0;
		int count = 0;
		// 삭제할 요소들을 하나씩 탐색해나간다.
		while (deleteIndex != m) {
			
			//일치하면 삭제
			if (deque.getFirst() == deleteList[deleteIndex]) {
				deque.removeFirst();
				deleteIndex++;
				continue;
			}

			int tempCount = 0;
			while (deque.getFirst() != deleteList[deleteIndex]) {
				move(deque);
				tempCount++;
			}

			//반절 이상 움직였으면 반대방향으로 진행한 횟수로 만들어서 더해준다.
			if (tempCount > deque.size() / 2) {
				tempCount = deque.size() - tempCount;
			}

			count += tempCount;

		}

		System.out.println(count);
		sc.close();
	}

	private static void move(Deque<Integer> deque) {
		deque.addLast(deque.removeFirst());
	}

}
