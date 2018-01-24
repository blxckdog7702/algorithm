package 백준.구현;

import java.util.Scanner;

//2490번(윷놀이)

public class KoreanBurumarble {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] output = new char[] {'D','C','B','A','E'};
		
		int count = 0;
		while(sc.hasNextInt()) {
			count = 0;
			
			for(int i = 0; i < 4; i++) {
				count += sc.nextInt();
			}
			
			System.out.println(output[count]);
		}
		
		sc.close();
	}

}
