package 백준.큐;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1260번(DFS와 BFS)

public class DfsBfs {
	// 정점의 개수
	int n;
	// 간선의 개수
	int m;
	// 탐색을 시작할 정점
	int v;
	// 그래프
	int[][] graph;
	// 방문 체크
	boolean[] visit;

	public DfsBfs() {
		Scanner sc = new Scanner(System.in);

		// 정점의 개수
		n = sc.nextInt();

		// 간선의 개수
		m = sc.nextInt();

		// 탐색을 시작할 정점
		v = sc.nextInt();

		graph = new int[n + 1][n + 1];
		visit = new boolean[n + 1];

		int x, y;

		// 그래프 초기화
		for (int i = 0; i < m; i++) {
			x = sc.nextInt();
			y = sc.nextInt();

			graph[x][y] = 1;
			graph[y][x] = 1;
		}

		sc.close();
	}

	public static void main(String[] args) {
		DfsBfs search = new DfsBfs();

		// DFS
		search.visit[search.v] = true;
		search.dfs(search.v);

		System.out.println();

		// BFS
		search.bfs();

	}

	// 재귀 방법으로 풀었다.
	private void dfs(int num) {
		System.out.printf("%d ", num);

		for (int j = 1; j <= n; j++) {
			if (graph[num][j] == 1 && visit[j] == false) {
				visit[j] = true;
				dfs(j);
			}
		}
	}

	private void bfs() {
		Queue<Integer> q = new LinkedList<>();

		// 방문 배열 초기화
		Arrays.fill(visit, false);

		// 시작 정점 방문 처리
		visit[v] = true;
		q.add(v);

		while (!q.isEmpty()) {

			int num = q.peek();
			q.remove();

			System.out.printf("%d ", num);

			for (int j = 1; j <= n; j++) {
				if (graph[num][j] == 1 & visit[j] == false) {
					q.add(j);
					visit[j] = true;
				}
			}
		}
	}
}
