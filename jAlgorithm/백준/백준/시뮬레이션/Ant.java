package 백준.시뮬레이션;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//3163번(떨어지는 개미, 직접구현)

public class Ant {
	int id;
	int position;
	boolean direction;

	public Ant(int position, int id, boolean direction) {
		this.position = position;
		this.id = id;
		this.direction = direction;
	}

	public boolean isRight() {
		return direction;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {
			int numOfAnts = sc.nextInt();
			int stickLength = sc.nextInt();
			int target = sc.nextInt();

			// int[][] stick = new int[2][stickLength + 1];
			List<Ant> antList = new ArrayList<>();

			// 개미 입력
			int position;
			int id;
			for (int j = 0; j < numOfAnts; j++) {
				position = sc.nextInt();
				id = sc.nextInt();
				antList.add(new Ant(position, id, id > 0));
			}

			int result = 0;

			while (target > 0) {
				int rightOut = -1;
				int leftOut = -1;
				// 이동
				for (Ant ant : antList) {
					if (ant.isRight()) {
						ant.position++;
						if (ant.position > stickLength) {
							rightOut = antList.indexOf(ant);
						}
					} else {
						ant.position--;
						if (ant.position < 0) {
							leftOut = antList.indexOf(ant);
						}
					}
				}

				if (rightOut > -1 || leftOut > -1) {
					// 삭제 과정
					List<Ant> removeList = new ArrayList<>();
					if (rightOut > -1) {
						removeList.add(antList.get(rightOut));
					}

					if (leftOut > -1) {
						removeList.add(antList.get(leftOut));
					}

					// id가 작은 순으로 먼저 떨어지기 때문에 정렬
					removeList.sort((a1, a2) -> a1.id - a2.id);

					for (Ant removeAnt : removeList) {
						if (target == 1) {
							result = removeAnt.id;
						}
						antList.remove(removeAnt);
						target--;
					}
				}
				
				// 충돌 판정
				// 위치를 기준으로 sort.
				antList.sort((a1, a2) -> a1.position - a2.position);
				for (int k = 0; k < antList.size() - 1; k++) {
					if (antList.get(k).position == antList.get(k + 1).position) {
//						System.out.println("!!!!" + antList.get(k).position + " " + antList.get(k+1).position);
						antList.get(k).direction = !antList.get(k).direction;
						antList.get(k + 1).direction = !antList.get(k + 1).direction;
					}
				}

//				antList.stream().forEach(n -> System.out.print(n.id + ":" + n.position + " "));
//				System.out.println();

			}

			System.out.println(result);

		}

		sc.close();
	}

}
