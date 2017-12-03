package tryHelloWorld;

public class Expressions {

	public int expressions(int num) {
		int answer = 0;
		
		for(int i = 1; i <= num; i++) {
			int temp = i;
			int sum = 0;
			
			while(sum < num) {
				sum += temp++;
			}
			
			if(sum == num) {
				answer++;
			}
		}
		
		return answer;
	}

	public static void main(String args[]) {
		Expressions expressions = new Expressions();
		// �Ʒ��� �׽�Ʈ�� ����� ���� ���� �ڵ��Դϴ�.
		System.out.println(expressions.expressions(15));
	}
}