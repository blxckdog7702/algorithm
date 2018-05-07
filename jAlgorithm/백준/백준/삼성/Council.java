package 백준.삼성;

import java.util.Scanner;

//14501번(퇴사)(실패)

public class Council {

	private static int n;
	private static int[][] arr;
	private static int max;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		
		arr = new int[2][n];
		
		for(int i = 0; i < n; i++) {
			arr[0][i] = in.nextInt();
			arr[1][i] = in.nextInt();
		}
		in.close();
		
		max = 0;
		
		for(int i = 0; i < n; i++) {
			dfs(i, 0);	
		}
		
		System.out.println(max);
	}

	private static void dfs(int idx, int sum) {
		if(idx == n) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = idx; i < n; i++) {
			if(i + arr[0][i] - 1 < n) {
				dfs(i + arr[0][i], sum + arr[1][i]);
			} else {
				max = Math.max(max, sum);
				return;
			}
		}
	}

}
