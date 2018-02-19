package mailProgamming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//정수 n이 주어지면, n개의 여는 괄호 "("와 n개의 닫는 괄호 ")"로 만들 수 있는 괄호 조합을 모두 구하시오. (시간 복잡도 제한 없습니다).
//예제)
//
//Input: 1
//Output: ["()"]
//
//Input: 2
//Output: ["(())", "()()"]
//
//Input: 3
//Output: ["((()))", "(()())", "()(())", "(())()", "()()()"]

public class Question3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(parenthesisPairs(n).toString());
		
		sc.close();
	}
	
	private static List<String> parenthesisPairs(int n) {
		List<String> ans = new ArrayList<>();
		
		recurse(ans, "", 0, 0, n);
		
		return ans;
	}

	private static void recurse(List<String> ans, String cur, int open, int close, int n) {
		if(cur.length() == n * 2) {
			ans.add(cur);
			return;
		}
		
		if(open < n) {
			recurse(ans, cur + "(", open + 1, close, n);
		}
		
		if(close < open) {
			recurse(ans, cur + ")", open, close + 1, n);
		}
	}

}
