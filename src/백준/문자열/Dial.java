package 백준.문자열;

import java.util.Scanner;

//5622번(다이얼)

public class Dial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		int sum = 0;
		
		for(int i = 0; i < s.length(); i++) {
			sum += check(s.charAt(i));
		}
		
		System.out.println(sum);
	}

	private static int check(char item) {
		 switch (item)
         {
             case 'A':
             case 'B':
             case 'C':
                 return 3;
             case 'D':
             case 'E':
             case 'F':
                 return 4;
             case 'G':
             case 'H':
             case 'I':
                 return 5;
             case 'J':
             case 'K':
             case 'L':
                 return 6;
             case 'M':
             case 'N':
             case 'O':
                 return 7;
             case 'P':
             case 'Q':
             case 'R':
             case 'S':
                 return 8;
             case 'T':
             case 'U':
             case 'V':
                 return 9;
             case 'W':
             case 'X':
             case 'Y':
             case 'Z':
                 return 10;
             default:
                 break;
         }
		return 0;
	}
}
