package codejam;

import java.util.*;
import java.io.*;

//https://codejam.withgoogle.com/codejam/contest/9234486/dashboard

public class Practice1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		in.nextLine();

		for (int i = 1; i <= t; i++) {
			String input = in.nextLine();
			int temp = Integer.parseInt(input);
			
			StringBuilder eight = new StringBuilder();
			
			if(input.length() > 1) {
				for(int j = 0; j < input.length() - 1; j++) {
					eight.append("8");
				}
			} else {
				eight.append("0");
			}
			
			int count = 0;
			
			for(int j = 0; j < input.length(); j++) {
				int digit = input.charAt(j) - '0';
				
				if(digit % 2 == 1) {
					int mod = (int)(Math.pow(10, input.length() - j - 1));
					
					int up = temp - (temp % mod) + mod;
					int down = temp - (temp % mod) - mod;
					
//					System.out.println(up + " " + down);
					
					count = Math.min(Math.abs(temp - up), Math.abs(temp - down));
					count = Math.min(count, Math.abs(temp - Integer.parseInt(eight.toString())));
					count = Math.min(count, Math.abs(temp - Integer.parseInt(eight.toString() + "8")));

					break;
//					System.out.println(count);
				}
			}
			
			System.out.println("Case #" + i + ": " + count);
		}

		in.close();
	}

}
