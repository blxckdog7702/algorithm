package 프로그래머스.단계1;

import java.util.Arrays;

class TryHelloWorld {
	public int[] gcdlcm(int a, int b) {
		int big = Math.max(a, b);
		int small = Math.min(a, b);
		
		int mod = big % small;
		
		while(mod > 0) {
			big = small;
			small = mod;
			mod = big % small;
		}
		
		int[] answer = new int[2];
		
		answer[0] = small;
		answer[1] = (a * b) / small;
		
		return answer;
	}

	// �Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
	public static void main(String[] args) {
		TryHelloWorld c = new TryHelloWorld();
		System.out.println(Arrays.toString(c.gcdlcm(3, 12)));
	}
}
