package 백준.그리디;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//1931번(그리디)

public class Meeting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		int[][] arr = new int[tc][2];
		
		for(int i = 0; i < tc; i++) {
			for(int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				//끝 시간은 같고, 시간 시간은 다를 경우
				if(o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int last = arr[0][1];
		int count = 1;

		for(int i = 1; i < tc; i++) {
			if(arr[i][0] >= last) {
				last = arr[i][1];
				count++;
			}
		}
		System.out.println(count);
	}

}
