package 백준.이항계수;

import java.math.BigInteger;
import java.util.Scanner;

//6591번(이항 쇼다운)

public class ShowDown {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		BigInteger result;

		int n = 0;
		int m = 0;

		while (true) {
			n = sc.nextInt();
			m = sc.nextInt();
			
			result = BigInteger.ONE;

			if (n == 0 && m == 0) {
				break;
			}

			if (m > n - m) {
				m = n - m;
			}

			for (long i = 1; i <= m; i++) {
				result = result.multiply(new BigInteger(String.valueOf(n)));
				n--;
				result = result.divide(new BigInteger(String.valueOf(i)));
			}
			
			System.out.println(result);
		}

		sc.close();
	}

}
