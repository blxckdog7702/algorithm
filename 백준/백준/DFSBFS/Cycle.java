package 백준.DFSBFS;

import java.util.Scanner;

//10451번(순열 싸이클)

public class Cycle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			int n = sc.nextInt();

			int arr[] = new int[n + 1];
			boolean visit[] = new boolean[n + 1];

			// 입력
			for (int j = 1; j <= n; j++) {
				arr[j] = sc.nextInt();
			}

			int count = 0;

			for (int j = 1; j <= n; j++) {
				// 방문 여부 체크
				if (visit[j] == true) {
					continue;
				}

				// 현재 수와 다음 수 비교 준비
				int current = arr[j];
				int next = arr[current];
				visit[j] = true;

				// 현재 수와 다음 수가 일치할 때까지 비교
				while (true) {
					// 방문
					visit[next] = true;

					// 일치하면 loop 탈출
					if (current == next) {
						count++;
						break;
					}

					// 일치하지 않으면 그 다음 수로 넘어감
					next = arr[next];
				}
			}

			System.out.println(count);
		}

		sc.close();
	}

}
