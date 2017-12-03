package tryHelloWorld;

import java.util.*;

public class Knight {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int height = scan.nextInt();
		int width = scan.nextInt();
		
		boolean[][] board = new boolean[height][width];
		
		int count = 1;
		int maxLevel = 0;
		
		int[][] move = new int[][] { {-2, 1},{ -1, 2 },{ 1, 2 },{ 2, 1 },{ 2, -1 },{ 1, -2 },{ -1, -2 },{ -2, -1 }};
		
		Queue<Pos> q = new LinkedList<Pos>();
		
		Pos firstPos = new Pos(0,0,0);
		q.add(firstPos);
		board[0][0] = true;
		
		while(!q.isEmpty()) {
			Pos currentPos = q.poll();
			
			int x = currentPos.getX();
			int y = currentPos.getY();
			int level = currentPos.getLevel();
			
//			System.out.println(x + " " + y + " " + level);
			if(level > maxLevel) {
				maxLevel = level;
//				System.out.println(maxLevel);
			}
			
			for(int i = 0; i < 8; i++) {
				int nextY = y + move[i][0];
				int nextX = x + move[i][1];
				int nextLevel = level + 1;
				
				if(nextY >= 0 && nextY < height && nextX >=0 && nextX < width && board[nextY][nextX] == false) {
					q.add(new Pos(nextX, nextY, nextLevel));
					board[nextY][nextX] = true;
					count++;
				}
			}
		}
		
		if(count != height * width) {
			System.out.println("꽝");
		}
		System.out.println("MaxLevel : " + maxLevel + " Count : " + count);
		
	}
}