package 백준.규칙찾기;

import java.util.Scanner;

//10250번(ACM호텔)

public class ACMHotel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();

		// 호텔의 높이
		int h = 0;
		// 호텔의 너비
		int w = 0;
		// n번째 손님
		int n = 0;

		for (int i = 0; i < tc; i++) {
			h = sc.nextInt();
			w = sc.nextInt();
			n = sc.nextInt();

			//몫은 호수(1호부터 시작)
			int room = n / h + 1;
			//나머지는 층수
			int floor = n % h;
			
			//나누어 떨어지면 꼭대기 층
			//호실 한칸 더 앞으로 나간거 취소
			if(floor == 0) {
				floor = h;
				room--;
			}

			System.out.print(floor);

			//호수가 한자리면 0을 붙여준다.
			if (room< 10) {
				System.out.println("0" + (room));
			} else {
				System.out.println(room);
			}
		}
	}
}
