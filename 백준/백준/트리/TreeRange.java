package 백준.트리;

import java.util.LinkedList;
import java.util.Scanner;

//1967번(트리의 지름)

public class TreeRange {
	
	static int[] dist;
	static LinkedList<NodeTR>[] list;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		list = (LinkedList<NodeTR>[]) new LinkedList[n];
		dist = new int[10001];
		
		for(int i = 0; i < n; i++) {
			list[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < n; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			int weight = sc.nextInt();
			
			list[parent].add(new NodeTR(child, weight));
			list[child].add(new NodeTR(parent, weight));
		}
		
		dfs(1, 0);
		
		sc.close();
	}

	private static void dfs(int v, int d) {
		dist[v] = d;
		
		if(dist[v] > result) {
			result = dist[v];
		}
	}

}

class NodeTR {
	int v;
	int w;
	
	public NodeTR(int v, int w) {
		this.v = v;
		this.w = w;
	}
}
