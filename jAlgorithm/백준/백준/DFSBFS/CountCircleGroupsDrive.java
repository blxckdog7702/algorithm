package 백준.DFSBFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//10216번(Count Circle Groups, 미완)

public class CountCircleGroupsDrive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			int n = sc.nextInt();
			int numberOfGroups = 0;

			Queue<int[]> enemyQueue = new LinkedList<>();
			Queue<int[]> groupQueue = new LinkedList<>();

			// 입력
			for (int j = 0; j < n; j++) {
				// x, y, r
				enemyQueue.add(new int[] { sc.nextInt(), sc.nextInt(), sc.nextInt() });
			}

			while (!enemyQueue.isEmpty()) {
				groupQueue.add(enemyQueue.poll());

				while (!groupQueue.isEmpty()) {
					int[] thisGroupEnemy = groupQueue.poll();
					Iterator<int[]> iter = enemyQueue.iterator();
					
					while(iter.hasNext()) {
						int[] unGroupedEnemy = iter.next();
						
						if (isSameGroup(unGroupedEnemy, thisGroupEnemy)) {
							groupQueue.add(thisGroupEnemy);
							iter.remove();
						}
					}
				}

				numberOfGroups++;
			}
			
			System.out.println(numberOfGroups);

		}
		sc.close();
	}

	public static boolean isSameGroup(int[] source, int[] target) {
		int distace = (target[0] - source[0]) * (target[0] - source[0])
				+ (target[1] - source[1]) * (target[1] - source[1]);
		
		int sumOfRadius = (target[2] + source[2]) + (target[2] + source[2]);
		
		if(distace > sumOfRadius) {
			return false;
		} else {
			return true;
		}
		
	}

}
