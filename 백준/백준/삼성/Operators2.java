package 백준.삼성;

import java.util.Scanner;

//14888번(연산자 끼워넣기, 다른풀이)

public class Operators2 {

	private static int n;
	private static int[] nums;
	private static int[] opers;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		n = in.nextInt();
		
		nums = new int[n];
		
		for(int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
		
		opers = new int[4];
		
		for(int i = 0; i < 4;i ++) {
			opers[i] = in.nextInt();
		}
		
		in.close();
		
		dfs(nums[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int result, int idx) {
		if(idx == n) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(opers[i] > 0) {
				switch(i) {
				case 0:
					opers[i]--;
					dfs(result + nums[idx], idx + 1);
					opers[i]++;
					break;
				case 1:
					opers[i]--;
					dfs(result - nums[idx], idx + 1);
					opers[i]++;
					break;
				case 2:
					opers[i]--;
					dfs(result * nums[idx], idx + 1);
					opers[i]++;
					break;
				case 3:
					opers[i]--;
					dfs(result / nums[idx], idx + 1);
					opers[i]++;
					break;
				}
			}
		}
	}

}
