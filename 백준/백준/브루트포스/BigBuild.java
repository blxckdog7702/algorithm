package 백준.브루트포스;

import java.util.Scanner;

//7568번(덩치)

public class BigBuild {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}

		for(int i = 0; i < n; i++) {
			int count = 0;
			
			for(int j = 0; j < n; j++) {
				if(i == j) {
					continue;
				}
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					count++;
				}
			}
			
			System.out.print((count + 1) + " ");
		}
		
		sc.close();
	}

}
