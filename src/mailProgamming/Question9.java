package mailProgamming;

import java.util.Arrays;

//정수 배열(int array)이 주어지면 0이 아닌 정수 순서를 유지하며 모든 0을 배열 오른쪽 끝으로 옮기시오. 
//단, 시간복잡도는 O(n), 공간복잡도는 O(1)여야 합니다.
//
//예제)
//Input: [0, 5, 0, 3, -1]
//Output: [5, 3, -1, 0, 0]
//
//Input: [3, 0, 3]
//﻿Output: [3, 3, 0]

//이 문제는 0을 오른쪽으로 옮기는것보다 0이 아닌 정수를 왼쪽으로 옮긴다고 생각하면 쉽게 풀수 있습니다.

public class Question9 {

	public static void main(String[] args) {
		int[] input = new int[] { 0, 5, 0, 3, -1 };
		
		int[] result = solution(input);
		
		System.out.println(Arrays.toString(result));
	}

	private static int[] solution(int[] input) {
		int position = 0; // 0이 아닌 정수가 들어갈 곳의 index
		
		for(int i = 0; i < input.length; i++) {
			if(input[i] != 0) {
				swap(input, i, position);
				position++;
			}
		}
		
		return input;
	}

	private static void swap(int[] input, int i, int position) {
		int temp = 0;
		temp = input[i];
		input[i] = input[position];
		input[position] = temp;
	}

}
