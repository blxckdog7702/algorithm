package 백준.문자열;

import java.util.Scanner;

//2941번 (크로아티아 알파벳)

public class CroatiaAlpha {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();
		//2글자와 3글자로 이루어진 크로아티아 알파벳을 구분하기 위한 변수
		int skipCount = 0;
		//결과 값 변수
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			//skipCount만큼 건너뛴다.
			//dz= 를 만났으면 skipCount는 2가되고, skipCount를 0으로 만드는 동안 z=는 건너뛴다.
			if (skipCount > 0) {
				skipCount--;
				continue;
			}

			//skipCount에 걸리지 않고 마지막 단어까지 왔으면 count를 1 더해준다. 
			if (i == s.length() - 1) {
				count++;
				continue;
			}

			//c=, c-
			if (s.charAt(i) == 'c' && s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
				count++;
				skipCount++;
				continue;
			}
			//d-
			else if (s.charAt(i) == 'd' && s.charAt(i + 1) == '-') {
				count++;
				skipCount++;
				continue;
			}
			//dz=는 skipCount를 2 더해준다.
			else if (s.charAt(i) == 'd' && i <= s.length() - 2 && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
				count++;
				skipCount += 2;
				continue;
			//lj
			} else if (s.charAt(i) == 'l' && s.charAt(i + 1) == 'j') {
				count++;
				skipCount++;
				continue;
			//nj
			} else if (s.charAt(i) == 'n' && s.charAt(i + 1) == 'j') {
				count++;
				skipCount++;
				continue;
			}
			//s=
			else if (s.charAt(i) == 's' && s.charAt(i + 1) == '=') {
				count++;
				skipCount++;
				continue;
			}
			//z=
			else if (s.charAt(i) == 'z' && s.charAt(i + 1) == '=') {
				count++;
				skipCount++;
				continue;
			}
			//나머지 알파벳
			else {
				count++;
			}
		}

		System.out.println(count);
	}
}
