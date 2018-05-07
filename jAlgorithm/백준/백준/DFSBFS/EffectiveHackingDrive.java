package 백준.DFSBFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//1325번(효율적인 해킹, 미완)

public class EffectiveHackingDrive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		EffectiveHacking eh = new EffectiveHacking();

		eh.n = sc.nextInt();
		eh.m = sc.nextInt();

		eh.init();
		
		eh.input(sc);
		sc.close();
		
		for(int i = 1; i <= eh.n; i++) {
			Stack<Integer> stack = new Stack<>();
			eh.dfs(i, stack);
			System.out.println(Arrays.toString(eh.resultCountArr));
		}
		
		System.out.println(Arrays.toString(eh.resultCountArr));
	}

}

class EffectiveHacking {
	int n;
	int m;
	ArrayList<ArrayList<Integer>> arr;
	int[] resultCountArr;
	boolean[][] visit;
	boolean[] selfVisit;
	
	public void dfs(int index, Stack<Integer> stack) {
		stack.add(index);
		
		for(int stackIndex : stack) {
			if(!visit[index][stackIndex]) {
				visit[index][stackIndex] = true;
				
				int add = arr.get(index).size();
				resultCountArr[stackIndex] += add;
			}
		
		}
		
		for(int item : arr.get(index)) {
			if(!visit[index][item]) {
				dfs(item, stack);
			}

		}
		
		stack.pop();
	}
	
	public void init() {
		arr = new ArrayList<>();
		
		for(int i =0; i <= n; i++) {
			arr.add(new ArrayList<>());
		}
		
		resultCountArr = new int[n + 1];
		visit = new boolean[n + 1][n + 1];
		
	}
	
	public void input(Scanner sc) {
		for (int i = 0; i < m; i++) {
			int source = sc.nextInt();
			int target = sc.nextInt();
			
			arr.get(target).add(source);
		}
	}
}
