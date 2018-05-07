package 백준.큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus1 {

//11866번(조세퍼스 문제1)
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numberOfPeople = sc.nextInt();
		int deleteCount = sc.nextInt();
		sc.close();
		
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= numberOfPeople; i++) {
			q.add(i);
		}
		
		System.out.print("<");
		
		int count = 0;
		
		while(!q.isEmpty()) {
			//마지막 하나 남은 요소는 바로 출력한다.
			if(q.size() == 1) {
				System.out.print(q.remove());
				break;
			}
			
			count++;
			
			//삭제할 순서면 삭제하면서 출력한다.
			if(count == deleteCount) {
				System.out.print(q.remove());
				System.out.print(", ");
				count = 0;
			}
			//삭제할 순서가 아니면 앞에 요소를 빼서 바로 뒤로 넣어주면서 원형큐처럼 만든다.
			else {
				q.add(q.remove());
			}
		}
		System.out.print(">");
	}

}
