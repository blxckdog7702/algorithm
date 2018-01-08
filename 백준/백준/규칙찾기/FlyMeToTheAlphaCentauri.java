package 백준.규칙찾기;

import java.util.Scanner;

//1011번(Fly me to the Alpha Centauri)
//거리가 n^2 일 때, 그 거리를 기준으로 +-n 마다 규칙이 나타난다.

public class FlyMeToTheAlphaCentauri {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		long x = 0;
		long y = 0;
		long distance = 0;
		long n = 0;
		long minRange = 0;
		long maxRange = 0;
		long timePow = 0;

		for (int i = 0; i < tc; i++) {
			x = sc.nextLong();
			y = sc.nextLong();

			distance = y - x;

			// 0, 1, 2 일땐 그대로
			if (distance < 3) {
				System.out.println(distance);
				continue;
			}

			n = 1;

			while (true) {
				timePow = n * n;
				minRange = timePow - n + 1;
				maxRange = timePow + n;
				
				//범위 안에 포함될 때
				if(distance >= minRange && distance <= maxRange) {
					if(distance >= minRange && distance <= timePow) {
						System.out.println(n * 2 - 1);
					} else {
						System.out.println(n * 2);
					}
					break;
				}
					
				n++;
			}

		}

		sc.close();
	}

}
