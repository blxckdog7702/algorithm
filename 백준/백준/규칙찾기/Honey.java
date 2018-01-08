package 백준.규칙찾기;

import java.util.Scanner;

//2292번(벌집)

public class Honey {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();
		
		//같은 라인 내에 있는 칸 끼리는 거리가 모두 같다.
		//몇 번째 라인에 포함되는지만 구하면 된다.
		//라인 수 규칙은 6n + 1로 올라간다.
		int count = 1;
		int sum = 1;
		
		while(input > sum) {
			sum += count * 6;
			count++;
		}
		
		System.out.println(count);
	}

}
