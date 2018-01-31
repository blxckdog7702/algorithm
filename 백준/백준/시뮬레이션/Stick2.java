package 백준.시뮬레이션;

import java.util.Arrays;
import java.util.Scanner;

//1094번(막대기)

public class Stick2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String bi = Integer.toBinaryString(sc.nextInt());
//		System.out.println(bi.length() - bi.replace("1", "").length());
		System.out.println(Integer.bitCount(sc.nextInt()));
		sc.close();
		
		int[][] arr = new int[4][4];
		
		System.out.println(Arrays.deepToString(arr));
	}

}
