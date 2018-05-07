package 백준.브루트포스;

import java.util.Scanner;

//1038번(감소하는 수)

public class DecreaseNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		sc.close();

		if(n > 1022) {
			System.out.println(-1);
			return;
		}
		
		if (n <= 10 && n >= 0) {
			System.out.println(n);
			return;
		}

		int count = 10;
		long index = 11;
		
		while (count != n) {
			String sIndex = String.valueOf(index);
			boolean check = true;

			for (int i = 0; i < sIndex.length() - 1; i++) {
				if (sIndex.charAt(i) - '0' <= sIndex.charAt(i + 1) - '0') {
					check = false;
					
					// 감소하는 수가 아니면 연산 횟수를 줄이기 위해 index를 점프시킨다.
					// 가장 큰 자리수 만큼 더해주고 그 아래 자리는 0으로 초기화한다.
					// ex) 11 -> 20
					int digit = sIndex.length() - 1 - i;
					index += (long)Math.pow(10, digit);
					index = (long)(Math.floor((double)index / Math.pow(10, digit)) * Math.pow(10, digit));
					break;
				}
			}

			if (check) {
				count++;
				index++;
			}

		}

		System.out.println(index - 1);

	}

}
