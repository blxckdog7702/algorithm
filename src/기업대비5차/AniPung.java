package 기업대비5차;

import java.util.Scanner;

public class AniPung {
	private static final int COL = 5;
	private static final int ROW = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] arr = new int[ROW + 2][COL + 2];
		boolean[][] checkArr = new boolean[ROW][COL];

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		sc.close();

		boolean isFinish = false;

		while (!isFinish) {
			isFinish = true;
			
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					// 가로 판별
					if (arr[i][j] == arr[i][j + 1] && arr[i][j] == arr[i][j + 2] && arr[i][j] != 0) {
						int count = j;
						while (arr[i][j] == arr[i][count]) {
							checkArr[i][count] = true;
							count++;
						}
						isFinish = false;
					}

					// 세로 판별
					if (arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i + 2][j] && arr[i][j] != 0) {
						int count = i;
						while (arr[i][j] == arr[count][j]) {
							checkArr[count][j] = true;
							count++;
						}
						isFinish = false;
					}
				}
			}

			// 터뜨리는 부분
			for (int i = 0; i < ROW; i++) {
				for (int j = 0; j < COL; j++) {
					if (checkArr[i][j]) {
						arr[i][j] = 0;
						checkArr[i][j] = false;
					}
				}
			}

			// 중력 작용
			for (int j = 0; j < COL; j++) {
				for (int i = ROW - 1; i > 0; i--) {
					if(arr[i][j] == 0) {
						int index = i;
						while(arr[index][j] == 0) {
							if(index == 0) {
								break;
							}
							index--;
						}
						
						arr[i][j] = arr[index][j];
						arr[index][j] = 0;
					}
				}
			}
		}

		//출력
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				System.out.print(" " + arr[i][j]);
			}
			System.out.println();
		}
	}

}
