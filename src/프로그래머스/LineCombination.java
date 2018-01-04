package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;

class LineCombination {
	public int[] setAlign(int n, long k) {
		int[] answer = new int[n];
		long temp = k - 1;
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= n; i ++) {
			list.add(i);
		}
		
		for(int i = 0; i < n; i++) {
			int divide = (int) (fac(n - i) / (n - i));
			int index = (int) (temp / divide);
			answer[i] = list.get(index);
			list.remove(index);
			temp = temp % divide;
		}

		return answer;
	}
	
	public static long fac(long n) {
		long result = 1;
		
		for(int i = 1; i <= n; i++) {
			result = result * i;
		}
		
		return result;
	}

	// �Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
	public static void main(String[] args) {
		LineCombination lc = new LineCombination();
		System.out.println(Arrays.toString(lc.setAlign(4, 12)));
	}
}
