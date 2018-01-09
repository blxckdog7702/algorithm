package 백준.정렬;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//1181번(단어정렬)

public class WordSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		sc.nextLine();

		List<String> list = new ArrayList<>();

		String input;

		for (int i = 0; i < tc; i++) {
			input = sc.nextLine();

			if (!list.contains(input)) {
				list.add(input);
			}
		}
		
		sc.close();

		// list.sort(new Comparator<String>() {
		//
		// @Override
		// public int compare(String o1, String o2) {
		// // TODO Auto-generated method stub
		// if(o1.length() == o2.length()) {
		// return o1.compareTo(o2);
		// }
		//
		// return o1.length() - o2.length();
		// }
		// });

		list.sort((String o1, String o2) -> {
			if (o1.length() == o2.length()) {
				return o1.compareTo(o2);
			}
			return o1.length() - o2.length();
		});

		for (String s : list) {
			System.out.println(s);
		}
	}

}
