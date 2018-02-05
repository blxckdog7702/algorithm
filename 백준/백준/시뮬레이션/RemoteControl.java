package 백준.시뮬레이션;

import java.util.Arrays;
import java.util.Scanner;

//1107번(리모컨)

public class RemoteControl {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String dest = sc.nextLine();

		int n = sc.nextInt();

		boolean[] brokenArr = new boolean[10];
		Arrays.fill(brokenArr, true);

		for (int i = 0; i < n; i++) {
			brokenArr[sc.nextInt()] = false;
		}
		
		sc.close();
		
		//그냥 +- 버튼으로만 이동했을 경우
		int result = Math.abs(100 - Integer.parseInt(dest));
		
		//0번 채널부터 1000000번 채널까지 돌면서 숫자키로 이동가능한 채널을 찾아낸다.
		for(int i = 0; i < 1000000; i++) {
			String channel = String.valueOf(i);
			boolean flag = true;
			int len = channel.length();
			
			for(int j = 0; j < len; j++) {
				int value = channel.charAt(j) - '0';
				
				if(brokenArr[value] == false) {
					flag = false;
					break;
				}
			}
			
			//현재(i) 채널이 숫자버튼으로 이동가능하면 목표 채널까지 필요한 +-버튼과 숫자버튼을 누르는 횟수를 더해준다.
			if(flag == true) {
				int tempResult = Math.abs(i - Integer.parseInt(dest)) + len;
				result = Math.min(tempResult, result);
			}
		}
		
		System.out.println(result);
		
	}
}
