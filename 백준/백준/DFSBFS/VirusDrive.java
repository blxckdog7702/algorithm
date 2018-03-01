package 백준.DFSBFS;

import java.util.Scanner;
import java.util.Stack;

//2606(바이러스)

public class VirusDrive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Virus virus = new Virus();
		virus.numberOfComputers = sc.nextInt();
		virus.numberOfNetworks = sc.nextInt();

		virus.init();
		virus.input(sc);

		sc.close();

//		virus.dfs();
		virus.recursive(1);

		System.out.println(virus.numberOfVirus);
	}

}

class Virus {
	int numberOfComputers;
	int numberOfNetworks;
	int numberOfVirus;
	boolean[][] hasVirus;
	boolean[] visit;
	
	public void recursive(int current) {
		for(int next = 2; next <= numberOfComputers; next++) {
			if(hasVirus[current][next] && !visit[next]) {
				visit[next] = true;
				numberOfVirus++;
				
				recursive(next);
			}
		}
	}

	public void dfs() {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);

		while (!stack.isEmpty()) {
			int current = stack.peek();
			boolean hasNext = false;

			for (int next = 2; next <= numberOfComputers; next++) {
				if (hasVirus[current][next] && !visit[next]) {
					stack.push(next);
					visit[next] = true;
					hasNext = true;
					numberOfVirus++;
					break;
				}
			}

			if (!hasNext) {
				stack.pop();
			}
		}
	}

	public void init() {
		hasVirus = new boolean[numberOfComputers + 1][numberOfComputers + 1];
		visit = new boolean[numberOfComputers + 1];
		
		numberOfVirus = 0;
		visit[1] = true;
	}

	public void input(Scanner sc) {
		for (int i = 1; i <= numberOfNetworks; i++) {
			int current = sc.nextInt();
			int next = sc.nextInt();

			hasVirus[current][next] = true;
			hasVirus[next][current] = true;
		}
	}
}
