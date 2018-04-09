package mailProgamming;

import java.util.HashMap;

//String이 주어지면, 중복된 char가 없는 가장 긴 서브스트링 (substring)의 길이를 찾으시오.  

//예제)
//Input: “aabcbcbc”
//Output: 3 // “abc”

//Input: “aaaaaaaa”
//Output: 1 // “a”

//Input: “abbbcedd”
//Output: 4 // “bced”

public class Question10 {

	public static void main(String[] args) {
		String input = "aabcbcbc";
//		String input = "aaaaaaaa";
		

		System.out.println(solution(input));
	}

	private static int solution(String s) {
		int result = 0;
		int start = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			if(map.containsKey(s.charAt(i))) {
				start = Math.max(start, map.get(s.charAt(i)));
			}
			
			result = Math.max(result, i - start + 1);
			// subString의 시작점은 i + 1;
			map.put(s.charAt(i), i + 1);
		}

		return result;
	}
	
	

}
