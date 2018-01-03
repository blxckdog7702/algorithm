package 백준.함수;

import java.util.Scanner;

//1193번(분수 찾기)

public class FindFraction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();

		//1, 2, 4, 7, 11, 16...
		int checkPoint = 1;
		
		//몇 번째 체크포인트에 있는지 확인
		int n = 0;
		
		//체크포인트는 1 + 시그마(n)
		while(input >= checkPoint) {
			n++;
			checkPoint = n*(n+1)/2 + 1;
		}
		
		//이미 체크포인트는 한 단계 더 앞서나갔기 때문에 n을 더해준다.
		int remain = input - checkPoint + n;
		//분모
		int denominator = n;
		//분자
		int numerator = 1;
		
		while(remain != 0) {
			denominator--;
			numerator++;
			remain--;
		}
		
		//지그재그 방향으로 진행되기 때문에 n의 홀수/짝수 여부에 따라서 반대로 출력해야한다.
		if(n % 2 == 0) {
			System.out.println(numerator + "/" + denominator);
		} else {
			System.out.println(denominator + "/" + numerator);
		}
	}

}
