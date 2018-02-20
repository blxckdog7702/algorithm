package 백준.트리;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//1167번(트리의 지름)

public class TreeRange2Drive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		TreeRange2 tr2 = new TreeRange2(n);

		tr2.init();
		tr2.input(sc);

		sc.close();
		
		tr2.search(1, 0);
		tr2.resetValues();
		tr2.search(tr2.farmostNode, 0);
		
		System.out.println(tr2.totalDistance);
	}

}

class TreeRange2 {
	int n;
	LinkedList<NodeTR2>[] nodeList;
	int[] distance;
	int totalDistance;
	int farmostNode;

	public TreeRange2(int n) {
		this.n = n;
	}

	public void init() {
		nodeList = new LinkedList[n + 1];

		for (int i = 0; i < n + 1; i++) {
			nodeList[i] = new LinkedList<>();
		}

		distance = new int[n + 1];
		Arrays.fill(distance, -1);

		totalDistance = 0;
		farmostNode = 0;
	}

	public void resetValues() {
		Arrays.fill(distance, -1);
		totalDistance = 0;
	}

	public void input(Scanner sc) {
		for (int i = 0; i < n; i++) {
			int currentNode = sc.nextInt();

			while (true) {
				int childNode = sc.nextInt();

				if (childNode == -1) {
					break;
				}

				int w = sc.nextInt();

				nodeList[currentNode].add(new NodeTR2(childNode, w));
				nodeList[childNode].add(new NodeTR2(currentNode, w));
			}
		}
	}

	public void search(int currentNode, int currentTotalDistance) {
		distance[currentNode] = currentTotalDistance;

		if (distance[currentNode] > totalDistance) {
			totalDistance = distance[currentNode];
			farmostNode = currentNode;
		}

		for (NodeTR2 node : nodeList[currentNode]) {
			int nextNode = node.vertex;
			int weight = node.weight;

			if (distance[nextNode] == -1) {
				search(nextNode, currentTotalDistance + weight);
			}
		}
	}

}

class NodeTR2 {
	int vertex;
	int weight;

	public NodeTR2(int v, int w) {
		this.vertex = v;
		this.weight = w;
	}
}
