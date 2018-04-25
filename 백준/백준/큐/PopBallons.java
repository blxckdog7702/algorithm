package 백준.큐;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//2346번(풍선 터뜨리기)

class Ballon {
	int idx;
	int value;
	
	public Ballon(int idx, int value) {
		this.idx = idx;
		this.value = value;
	}
}

public class PopBallons {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		Deque<Ballon> q = new LinkedList<>();

		int n = in.nextInt();

		for (int i = 1; i <= n; i++) {
			q.addLast(new Ballon(i, in.nextInt()));
		}

		for (int i = 0; i < n; i++) {
			Ballon out = q.pollFirst();
			System.out.print(out.idx + " ");
			
			if(q.isEmpty()) {
				return;
			}
			
			if (out.value > 0) {
				for (int j = 1; j < Math.abs(out.value); j++) {
					q.addLast(q.pollFirst());
				}
			} else {
				for(int j = 1; j <= Math.abs(out.value); j++) {
					q.addFirst(q.pollLast());
				}
			}
		}
		
		in.close();
	}

}
