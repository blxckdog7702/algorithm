package 백준.삼성;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//14891(톱니바퀴)

public class Gears {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Queue<Integer>[] gears = new LinkedList[4];
		
		for(int i = 0; i < 4; i++) {
			gears[i] = new LinkedList<Integer>();
		}
		
		//입력
		for(int i = 0; i < 4; i++) {
			String input = in.nextLine();
			
			for(int j = 0; j < input.length(); j++) {
				gears[i].add(input.charAt(j) - '0');
			}
		}
		
		
		
		in.close();
	}

}
