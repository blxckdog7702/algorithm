package test;

import java.util.Arrays;

public class CloneTest {

	public static void main(String[] args) {
		int[][] arr1 = new int[][] {{1},{2},{3},{4},{5}};
		int[][] arr2 = arr1.clone();
		
		arr1[0][0] = 999;
		
		System.out.println(Arrays.deepToString(arr1));
		System.out.println(Arrays.deepToString(arr2));
	}

}
