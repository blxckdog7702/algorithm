package 백준.규칙찾기;

import java.util.Scanner;

//1475번(방 번호)

public class RoomNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		int count = 0;
		
		while(!input.equals("")) {
			for(int i = 0; i <= 9; i++) {
				if(input.contains(String.valueOf(i))) {
					input = input.replaceFirst(String.valueOf(i), "");
					continue;
				}
				
				if(i == 6 && input.contains("9")) {
					input = input.replaceFirst("9", "");
					continue;
				}
				
				if(i == 9 && input.contains("6")) {
					input = input.replaceFirst("6", "");
					continue;
				}
			}
			
			count++;
		}
		
		System.out.println(count);
		
	}

}
