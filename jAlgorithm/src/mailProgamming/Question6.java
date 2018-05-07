package mailProgamming;

import java.util.Arrays;
import java.util.LinkedList;

//간격(interval)로 이루어진 배열이 주어지면, 겹치는 간격 원소들을 합친 새로운 배열을 만드시오.
//간격은 시작과 끝으로 이루어져 있으며 시작은 끝보다 작거나 같습니다.

//예제)
//Input: {{2,4}, {1,5}, {7,9}}
//Output: {{1,5}, {7,9}}
//
//Input: {{3,6}, {1,3}, {2,4}}
//Output: {{1,6}}

public class Question6 {
	public static void main(String[] args) {
//		int[][] input = new int[][] { { 2, 4 }, { 1, 5 }, { 7, 9 } };
		 int[][] input = new int[][] {{3,6}, {1,3}, {2,4}};
		
		Arrays.sort(input, (a, b) -> Integer.compare(a[0], b[0]));
		LinkedList<int[]> result = solution(input);
			
		result.forEach(n -> System.out.println(Arrays.toString(n)));
	}

	private static LinkedList<int[]> solution(int[][] input) {
		LinkedList<int[]> result = new LinkedList<>();
		
		result.add(input[0]);
		
		for(int i = 1; i < input.length; i++) {
			int[] temp = input[i];
			
			if(result.getLast()[1] < temp[0]){
				result.addLast(temp);
			} else {
				result.getLast()[1] = Math.max(result.getLast()[1], temp[1]);
			}
		}
		
		return result;
	}
}
