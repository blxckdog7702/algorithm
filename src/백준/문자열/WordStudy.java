package 백준.문자열;

import java.util.Arrays;
import java.util.Scanner;

//1157번(문자열)

public class WordStudy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] countArr = new int[26];
		
		String word = sc.next();
		
		word = word.toLowerCase();
		
		char[] charArr = word.toCharArray();
		
		int maxIndex = 0;
		int max = 0;
		
		for(int i = 0; i < charArr.length; i++) {
			int index =  (int)charArr[i] - 97;
			countArr[index] += 1;
			
			if(max < countArr[index]) {
				max = countArr[index];
				maxIndex = index;
			}
		}
		
		Arrays.sort(countArr);
		
		if(countArr[25] == countArr[24]) {
			System.out.println("?");
			return;
		}
		
		System.out.println((char)(maxIndex + 65));
	}

}
