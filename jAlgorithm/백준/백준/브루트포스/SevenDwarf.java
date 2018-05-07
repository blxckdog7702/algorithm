package 백준.브루트포스;

import java.util.Arrays;
import java.util.Scanner;

//2309번(일곱 난쟁이)

public class SevenDwarf {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] leng = new int[9];
		int sum = 0;
		
		for(int i = 0; i < 9; i++) {
			int input = sc.nextInt();
			leng[i] = input;
			sum += input;
		}
		
		int goal = sum - 100;
		boolean find = false;
		Arrays.sort(leng);
		
		boolean[] check = new boolean[9];
		
		for(int i = 0; i < 8; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(goal == leng[i] + leng[j]) {
					check[i] = true;
					check[j] = true;
					find = true;
					break;
				}
			}
			if(find) {
				break;
			}
 		}
		
		for(int i = 0; i < 9; i++) {
			if(!check[i]) {
				System.out.println(leng[i]);	
			}
		}
		
		sc.close();
	}

}
