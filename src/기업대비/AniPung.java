package 기업대비;

import java.util.InputMismatchException;
import java.util.Scanner;

class OutOfTileRangeException extends Exception {
	private static final long serialVersionUID = -6723341209501382298L;

	public OutOfTileRangeException() {
		super("타일은 1~4 범위 내의 숫자여야 합니다.");
	}
}

public class AniPung {
	private static final int COL = 5;
	private static final int ROW = 5;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[][] tiles = new int[ROW + 2][COL + 2];
		boolean[][] checkArr = new boolean[ROW][COL];

		// 타일 값 입력.
		try {
			inputTiles(sc, tiles);
		} catch (InputMismatchException e) {
			System.out.println("입력 값은 숫자여야 합니다.");
			return;
		} catch (OutOfTileRangeException e) {
			System.out.println(e.getMessage());
			return;
		} finally {
			sc.close();
		}

		boolean isFinish = false;

		while (true) {
			// 터뜨릴 타일이 없으면 isFinish이 true가 된다.
			isFinish = checkTiles(tiles, checkArr);

			if (isFinish) {
				break;
			}

			// 체크한 타일을 터뜨린다.
			removeTiles(tiles, checkArr);

			// 타일을 터뜨린 뒤, 빈칸이 있으면 내려오도록 정리한다.
			moveTiles(tiles);
		}

		// 결과 타일 값 출력.
		printTiles(tiles);
	}

	private static void inputTiles(Scanner sc, int[][] tiles) throws OutOfTileRangeException {
		int input;

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				input = sc.nextInt();

				if (input < 1 || input > 4) {
					throw new OutOfTileRangeException();
				}

				tiles[i][j] = input;
			}
		}
	}

	private static void printTiles(int[][] tiles) {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (j == 0) {
					System.out.print(tiles[i][j]);
				} else {
					System.out.print(" " + tiles[i][j]);
				}
			}
			System.out.println();
		}
	}

	private static void moveTiles(int[][] tiles) {
		for (int j = 0; j < COL; j++) {
			for (int i = ROW - 1; i > 0; i--) {
				if (tiles[i][j] == 0) {
					int index = i;
					while (tiles[index][j] == 0) {
						if (index == 0) {
							break;
						}
						index--;
					}

					tiles[i][j] = tiles[index][j];
					tiles[index][j] = 0;
				}
			}
		}
	}

	private static void removeTiles(int[][] tiles, boolean[][] checkArr) {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (checkArr[i][j]) {
					tiles[i][j] = 0;
					checkArr[i][j] = false;
				}
			}
		}
	}

	private static boolean checkTiles(int[][] tiles, boolean[][] checkArr) {
		boolean isFinish = true;

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				// 가로 판별
				if (tiles[i][j] == tiles[i][j + 1] && tiles[i][j] == tiles[i][j + 2] && tiles[i][j] != 0) {
					int count = j;
					while (tiles[i][j] == tiles[i][count]) {
						checkArr[i][count] = true;
						count++;
					}
					isFinish = false;
				}

				// 세로 판별
				if (tiles[i][j] == tiles[i + 1][j] && tiles[i][j] == tiles[i + 2][j] && tiles[i][j] != 0) {
					int count = i;
					while (tiles[i][j] == tiles[count][j]) {
						checkArr[count][j] = true;
						count++;
					}
					isFinish = false;
				}
			}
		}
		return isFinish;
	}

}
