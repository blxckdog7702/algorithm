package 백준.DFSBFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//10216번(Count Circle Groups)

public class CountCircleGroupsDrive2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			CountCircleGroups ccg = new CountCircleGroups();
			
			ccg.n = sc.nextInt();
			ccg.init();
			ccg.input(sc);
			ccg.adj();
			
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
	List<ArrayList<Integer>> list;
	int numberOfGroups;
	
	public void init() {
		enemies = new int[n][3];
		visit = new boolean[n];
		list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
	}
	
	public void adj() {
		for(int i = 0; i < n; i++) {
			for(int j = i + 1; j < n; j++) {
				if(isSameGroup(enemies[i], enemies[j])) {
					list.get(i).add(j);
					list.get(j).add(i);
//					for(ArrayList<Integer> item : list) {
//						System.out.println(item.toString());
//					}
				}
			}
		}
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
		visit[next] = true;
		
		for(int i = 0; i < list.get(next).size(); i++) {
			if(!visit[list.get(next).get(i)]) {
				dfs(list.get(next).get(i));
			}
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
