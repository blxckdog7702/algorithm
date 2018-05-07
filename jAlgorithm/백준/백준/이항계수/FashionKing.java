package 백준.이항계수;

import java.util.HashMap;
import java.util.Scanner;

//9375번(패션왕 신해빈)

public class FashionKing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int i = 0; i < tc; i++) {

			HashMap<String, Integer> map = new HashMap<>();
			int inputTimes = sc.nextInt();
			sc.nextLine();
			String input = null;

			for (int j = 0; j < inputTimes; j++) {
				input = sc.nextLine();
				String key = input.split(" ")[1];

				if (map.containsKey(key)) {
					map.put(key, map.get(key) + 1);
				} else {
					map.put(key, 1);
				}
			}

			int result = 1;

			for (int value : map.values()) {
				result *= value + 1;
			}

			System.out.println(result - 1);
		}

		sc.close();
	}

}
