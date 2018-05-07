package 백준.트리;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

//1967번(트리의 지름)

public class TreeRangeDrive {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		TreeRange tr = new TreeRange();

		tr.init(n);

		// 입력과정
		for (int i = 0; i < n - 1; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			int weight = sc.nextInt();

			// 자신과 이어진 노드 번호와 가중치를 입력한다.
			tr.nodeList[parent].add(new NodeTR(child, weight));
			tr.nodeList[child].add(new NodeTR(parent, weight));
		}

		sc.close();

		// 1번에서 가장 멀리 떨어진 노드 탐색
		tr.findFarmostNode(1, 0);

		tr.totalDistance = 0;

		// 거리배열 초기화
		Arrays.fill(tr.distance, -1);

		// 아까 검색했던 farmostNode에서 가장 멀리 떨어진 노드 탐색
		tr.findFarmostNode(tr.farmostNode, 0);

		System.out.println(tr.totalDistance);
	}
}

class TreeRange {
	LinkedList<NodeTR>[] nodeList;
	int[] distance;
	int totalDistance;
	int farmostNode;

	public void init(int numberOfNodes) {
		nodeList = (LinkedList<NodeTR>[]) new LinkedList[numberOfNodes + 1];

		// 1번에서 v번 정점까지의 거리를 담는 배열
		// 또는 검색했던 가장 먼 정점 부터 v번 정점까지의 거리를 담는 배열
		distance = new int[10001];

		// 탐색하지 않은 노드까지의 거리는 -1로 초기화
		Arrays.fill(distance, -1);

		// 인접행렬 초기화
		for (int i = 0; i < numberOfNodes + 1; i++) {
			nodeList[i] = new LinkedList<>();
		}
	}

	public void findFarmostNode(int currentNode, int currentTotalDistance) {
		// 해당 노드까지의 거리 저장
		distance[currentNode] = currentTotalDistance;

		// 현재 노드가 최대 거리 노드면 저장
		if (distance[currentNode] > totalDistance) {
			totalDistance = distance[currentNode];
			farmostNode = currentNode;
		}

		for (NodeTR node : nodeList[currentNode]) {
			int next = node.vertex;
			int weight = node.weight;

			// 다음 노드가 한번도 탐색된 적이 없는 노드라면 다시 dfs로 탐색
			if (distance[next] == -1) {
				findFarmostNode(next, currentTotalDistance + weight);
			}
		}
	}
}

class NodeTR {
	int vertex;
	int weight;

	public NodeTR(int v, int w) {
		this.vertex = v;
		this.weight = w;
	}
}
