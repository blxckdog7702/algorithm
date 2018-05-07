package 백준.이항계수;

import java.math.BigInteger;
import java.util.Scanner;

//1676번(팩토리얼 0의 개수)

public class CountZero {
	BigInteger[] arr;

	public CountZero() {
		arr = new BigInteger[501];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();

		CountZero cz = new CountZero();
		
		BigInteger result = cz.fac(number);

		System.out.println(cz.countZero(result.toString()));

		sc.close();
	}
	
	public int countZero(String input) {
		int count = 0;
		
		for(int i = input.length() - 1; i >= 0; i--) {
			if(input.charAt(i) != '0') {
				break;
			}
			count++;
		}
		
		return count;
	}

	public BigInteger fac(int number) {
		if (number == 0 || number == 1) {
			return BigInteger.ONE;
		}

		if (arr[number] == null) {
			arr[number] = fac(number - 1).multiply(BigInteger.valueOf(number));
		}

		return arr[number];
	}

}
