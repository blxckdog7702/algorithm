package 백준.이항계수;

import java.math.BigInteger;
import java.util.Scanner;

//2407번(조합)

public class Combination {

	BigInteger[][] arr;

	public Combination() {
		arr = new BigInteger[101][101];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		sc.close();

		Combination com = new Combination();

		System.out.println(com.combination(n, m));
	}

	public BigInteger combination(int n, int r) {
		if (n == r || r == 0)
			return BigInteger.ONE;
		else if (arr[n][r] == null) {
			arr[n][r] = combination(n - 1, r - 1).add(combination(n - 1, r));
		}
		return arr[n][r];
	}

}
