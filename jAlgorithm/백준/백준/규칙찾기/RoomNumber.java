package 백준.규칙찾기;

import java.util.Scanner;

//1475번(방 번호)

public class RoomNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		
		int count = 0;
		
		//입력 값이 ""이 될 때까지 1~9를 순회하면서 동일한 값을 찾아서 하나 씩 없앤다.
		while(!input.equals("")) {
			for(int i = 0; i <= 9; i++) {
				//1~9를 순회하면서 일치하는 값을 포함하면 replace
				if(input.contains(String.valueOf(i))) {
					input = input.replaceFirst(String.valueOf(i), "");
					continue;
				}
				
				//6으로 9 대체
				if(i == 6 && input.contains("9")) {
					input = input.replaceFirst("9", "");
					continue;
				}
				
				//9로 6 대체
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
