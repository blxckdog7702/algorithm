package 백준.DFSBFS;

import java.util.Scanner;

//10216번(Count Circle Groups, 미완)

public class CountCircleGroupsDrive2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			CountCircleGroups ccg = new CountCircleGroups();
			
			ccg.n = sc.nextInt();
			ccg.init();
			ccg.input(sc);
			
			for(int j = 0; j < ccg.n; j++) {
				if(!ccg.visit[j]) {
					ccg.dfs(j);
					ccg.numberOfGroups++;
				}
			}
			
			System.out.println(ccg.numberOfGroups);
		
		}
		sc.close();
	}
}

class CountCircleGroups {
	int n;
	int[][] enemies;
	boolean[] visit;
	int numberOfGroups;
	
	public void init() {
		enemies = new int[n][3];
		visit = new boolean[n];
	}
	
	public void input(Scanner sc) {
		// 입력
		for (int j = 0; j < n; j++) {
			// x, y, r
			enemies[j][0] = sc.nextInt();
			enemies[j][1] = sc.nextInt();
			enemies[j][2] = sc.nextInt();
		}
	}

	public void dfs(int next) {
		
		int[] current = enemies[next];
		
		for(int i = 0; i < n; i++) {
			if(i == next) {
				continue;
			}
			
			if(visit[i]) {
				continue;
			}
			
			if(!isSameGroup(current, enemies[i])) {
				continue;
			}
			
			visit[i] = true;
			dfs(i);
		}
		
	}
	
	public boolean isSameGroup(int[] source, int[] target) {
		int distace = (target[0] - source[0]) * (target[0] - source[0])
				+ (target[1] - source[1]) * (target[1] - source[1]);
		
		int sumOfRadius = (target[2] + source[2]) + (target[2] + source[2]);
		
		if(distace <= sumOfRadius) {
			return true;
		} else {
			return false;
		}
		
	}
}
