package tryHelloWorld;

import java.util.Arrays;

public class OneTwoFour {
	public String change124(int n) {
		String answer = "";
		
		if( n > 0) {
			int rest = n % 3;
			answer = ((rest == 0) ? "4" : (rest == 1) ? "1" : "2") + answer;
			answer = change124((n - 1) / 3) + answer;
		}
		
		return answer;
	}

	// �Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
	public static void main(String[] args) {
		OneTwoFour oneTwoFour = new OneTwoFour();
		System.out.println(oneTwoFour.change124(10));
	}
}
