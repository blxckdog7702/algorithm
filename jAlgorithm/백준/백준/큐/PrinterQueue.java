package 백준.큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1966번(프린터 큐)

public class PrinterQueue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		Queue<Page> q = new LinkedList<>();
		
		for(int i = 0; i < tc; i++) {
			int numberOfPage = sc.nextInt();
			int indexToFind = sc.nextInt();
			int priority;
			int count = 0;
			q.clear();
			
			//우선순위 입력
			for(int j = 0; j < numberOfPage; j++) {
				priority = sc.nextInt();
				q.add(new Page(j, priority));
			}

			while(true) {
				int max = q.stream().max((Page p1, Page p2) -> p1.getPriority() - p2.getPriority()).get().getPriority();
				
				while(q.peek().getPriority() != max) {
					q.add(q.remove());
				}
				
				//max값을 만나면 뽑아낸다.
				count++;
				
				//max 값이 찾던거라면 count를 출력 후 종료.
				if(q.peek().getIndex() == indexToFind) {
					System.out.println(count);
					break;
				}
				//max 값이 찾던게 아니라면 그냥 지운다.
				else {
					q.remove();
				}
				
			}
		}
		
		sc.close();
	}

}

class Page {
	int index;
	int priority;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Page(int index, int priority) {
		this.index = index;
		this.priority = priority;
	}
}
