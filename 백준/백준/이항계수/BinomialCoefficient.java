package 백준.이항계수;

import java.util.Scanner;

//11050(이항계수1)
//11050(이항계수2)

public class BinomialCoefficient {
	
	int[][] arr;
	
	public BinomialCoefficient() {
		arr = new int[4000001][4000001];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BinomialCoefficient bc = new BinomialCoefficient();
		
		System.out.println(bc.combination(sc.nextInt(), sc.nextInt()));
		
		sc.close();
	}
	
	public int combination(int n, int r) {
		if (n == r || r == 0)
			return 1;
		else
			if(arr[n][r] == 0) {
				arr[n][r] = (combination(n - 1, r - 1) + combination(n - 1, r) ) % 10007;
			}
			return arr[n][r];
	}

}
