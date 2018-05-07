package 백준.트리;

import java.util.LinkedList;
import java.util.Scanner;

//1289번(트리의 가중치, 오답)

public class TreeWeightDrive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		TreeWeight tw = new TreeWeight();

		tw.n = sc.nextInt();

		tw.init();
		
		tw.input(sc);
		
		tw.dfs(1, -1);
		
		System.out.println(tw.total);
		
		sc.close();
	}

}

class TreeWeight {
	private static final int MOD = 1000000007;
	int n;
	int total;
	LinkedList<NodeTW>[] list;

	public void init() {
		list = (LinkedList<NodeTW>[])new LinkedList[n + 1];
		
		for(int i = 0; i < n + 1; i++) {
			list[i] = new LinkedList<>();
		}
		
		total = 0;
	}
	
	public void input(Scanner sc) {
		for (int i = 0; i < n - 1; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			int weight = sc.nextInt();
			
			list[first].add(new NodeTW(second, weight));
			list[second].add(new NodeTW(first, weight));
		}
	}
	
	public int dfs(int root, int parent) {
		int temp = 1;
		int part = 0;
		
		for(NodeTW node : list[root]) {
			int v = node.vertex;
			int w = node.weight;
			
			if(v == parent) {
				continue;
			}
		
			part = dfs(v, root) * w % MOD;
			total = (total + part * temp) % MOD;
			temp = (temp + part) % MOD;
		}
		return temp;
	}
}

class NodeTW {
	int vertex;
	int weight;

	public NodeTW(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}
