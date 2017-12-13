package 기업대비;

import java.util.InputMismatchException;
import java.util.Scanner;

class OutOfTileRangeException extends Exception {
	private static final long serialVersionUID = -6723341209501382298L;

	public OutOfTileRangeException() {
		super("타일은 " + AniPung.MIN_TILE + " ~ " + AniPung.MAX_TILE + " 범위 내의 숫자여야 합니다.");
	}
}

public class AniPung {
	private static final int COL = 5;
	private static final int ROW = 5;
	public static final int MIN_TILE = 1;
	public static final int MAX_TILE = 4;

	private int[][] tiles;
	private boolean[][] checkArr;
	private boolean isFinish;

	public AniPung() {
		tiles = new int[ROW + 2][COL + 2];
		checkArr = new boolean[ROW][COL];
		isFinish = false;
	}

	public void gameStart() {
		// 타일 입력. 예외 발생시 게임 종료.
		try {
			inputTiles();
		} catch (InputMismatchException e) {
			System.out.println("입력 값은 숫자여야 합니다.");
			System.out.println("게임을 종료합니다.");
			return;
		} catch (OutOfTileRangeException e) {
			System.out.println(e.getMessage());
			System.out.println("게임을 종료합니다.");
			return;
		}

		// 게임 로직 처리 루프.
		gameLoop();
	}

	private void inputTiles() throws OutOfTileRangeException {
		Scanner sc = new Scanner(System.in);
		int input;

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				input = sc.nextInt();

				if (input < MIN_TILE || input > MAX_TILE) {
					sc.close();
					throw new OutOfTileRangeException();
				}

				tiles[i][j] = input;
			}
		}

		sc.close();
	}

	private void gameLoop() {
		while (true) {
			// 터뜨릴 타일이 없으면 isFinish이 true가 된다.
			isFinish = checkTiles();

			if (isFinish) {
				break;
			}

			// 체크한 타일을 터뜨린다.
			removeTiles();

			// 타일을 터뜨린 뒤, 빈칸이 있으면 내려오도록 정리한다.
			moveTiles();
		}

		// 결과 타일 값 출력.
		printTiles();
	}

	private boolean checkTiles() {
		boolean isFinish = true;
		int count;

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				// 가로 판별
				if (tiles[i][j] == tiles[i][j + 1] && tiles[i][j] == tiles[i][j + 2] && tiles[i][j] != 0) {
					count = j;

					while (tiles[i][j] == tiles[i][count]) {
						checkArr[i][count] = true;
						count++;
					}

					isFinish = false;
				}

				// 세로 판별
				if (tiles[i][j] == tiles[i + 1][j] && tiles[i][j] == tiles[i + 2][j] && tiles[i][j] != 0) {
					count = i;

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

	private void removeTiles() {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (checkArr[i][j]) {
					tiles[i][j] = 0;
					checkArr[i][j] = false;
				}
			}
		}
	}

	private void moveTiles() {
		int index;

		for (int j = 0; j < COL; j++) {
			for (int i = ROW - 1; i > 0; i--) {
				if (tiles[i][j] == 0) {
					index = i;

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

	private void printTiles() {
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

	public static void main(String[] args) {
		AniPung game = new AniPung();
		game.gameStart();
	}
}
