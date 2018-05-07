package 백준.DFSBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//1890번(점프)

public class JumpDrive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Jump jump = new Jump();
		
		jump.n = sc.nextInt();
		
		jump.init();
		jump.input(sc);
		sc.close();
		
		jump.solution();
		
		System.out.println(jump.count[jump.n-1][jump.n-1]);
	}
}

class Jump {
	int n;
	int[][] arr;
	long[][] count;
	Queue<int[]> q;
	int[] dx = {0, 1};
	int[] dy = {1, 0};
	

	public void init() {
		arr = new int[n][n];
		count = new long[n][n];
		q = new LinkedList<>();
	}

	public void input(Scanner sc) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
	}
	
	public void solution() {
		count[0][0] = 1;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(count[i][j] == 0 || (i == n - 1 && j == n - 1)) {
					continue;
				}
				
				int current = arr[i][j];
				int down = current + i;
				int right = current + j;
				
				if(down < n) {
					count[down][j] += count[i][j];
				}
				
				if(right < n) {
					count[i][right] += count[i][j];
				}
			}
		}
	}
}
