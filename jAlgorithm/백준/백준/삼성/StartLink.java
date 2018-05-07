package 백준.삼성;

import java.util.Scanner;

//14889(스타트와 링크)

public class StartLink {

	private static int n;
	private static int[][] arr;
	private static int min;
	private static boolean[] check;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		
		arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = in.nextInt();	
			}
		}
		
		in.close();
		
		check = new boolean[n];
		
		min = Integer.MAX_VALUE;
		
		dfs(0, true, 1);
		dfs(0, false, 0);
		
		System.out.println(min);
		
	}

	private static void dfs(int idx, boolean value, int count) {
		if(idx >= n) {
			return;
		}
		
		check[idx] = value;
		
		if(count == n / 2) {
			min = Math.min(min, calculate(check));
			return;
		}
		
		dfs(idx + 1, true, count + 1);
		dfs(idx + 1, false, count);
	}

	private static int calculate(boolean[] check) {
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j) {
					continue;
				}
				
				if(check[i] && check[j]) {
					a += arr[i][j];
				} else if(!check[i] && !check[j]) {
					b += arr[i][j];
				}
			}
		}
		
		return Math.abs(a - b);
	}

}
