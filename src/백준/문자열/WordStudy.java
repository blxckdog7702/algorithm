package 백준.문자열;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//1157번(문자열)

public class WordStudy {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		int[] countArr = new int[26];
//		
//		String word = sc.next();
//		
//		word = word.toLowerCase();
//		
//		char[] charArr = word.toCharArray();
//		
//		int maxIndex = 0;
//		int max = 0;
//		
//		for(int i = 0; i < charArr.length; i++) {
//			int index =  (int)charArr[i] - 97;
//			countArr[index] += 1;
//			
//			if(max < countArr[index]) {
//				max = countArr[index];
//				maxIndex = index;
//			}
//		}
//		
//		Arrays.sort(countArr);
//		
//		if(countArr[25] == countArr[24]) {
//			System.out.println("?");
//			return;
//		}
//		
//		System.out.println((char)(maxIndex + 65));
		
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		sc.close();
		
		Map<Character, Integer> map = new HashMap<>();
		
		word = word.toUpperCase();
		
		for(int i = 0; i < word.length(); i++) {
			if(!map.containsKey(word.charAt(i))) {
				map.put(word.charAt(i), 1);
			} else {
				map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
			}
		}
		
		Entry<Character, Integer> maxEntry = Collections.max(map.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue());
//		Collections.max(map.values());
		int max = maxEntry.getValue();
		int count = Collections.frequency(map.values(), max);
		
		if(count > 1) {
			System.out.println("?");
			return;
		}
		System.out.println(maxEntry.getKey());
	}

}
