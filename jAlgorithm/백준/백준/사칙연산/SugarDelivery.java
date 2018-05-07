package 백준.사칙연산;

import java.util.Scanner;

//2839번(설탕배달)

public class SugarDelivery {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int sugar = sc.nextInt();
		sc.close();

		//5로 나누어 떨어질 때
		if (sugar % 5 == 0) {
			System.out.println(sugar / 5);
			return;
		}

		//5와 3의 배수의 합으로 설탕을 만들 수 있을 때 ex) 11 16...
		int temp = 0;

		for (int i = (sugar / 5); i > 0; i --) {
			temp = sugar - (i * 5);
			
			if(temp % 3 == 0) {
				System.out.println((temp / 3) + i);
				return;
			}
		}

		//3로 나누어 떨어질 때
		if (sugar % 3 == 0) {
			System.out.println(sugar / 3);
			return;
		}

		//무게를 정확히 만들 수 없을 때
		System.out.println(-1);
	}

}
