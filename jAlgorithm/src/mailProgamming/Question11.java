package mailProgamming;

import java.util.HashMap;

//길이가 같은 두 문자열(string) A 와 B가 주어지면, A 가 B 로 1:1 암호화 가능한지 찾으시오.
//예제)
//Input: “EGG”, “FOO”
//Output: True // E->F, G->O
//
//Input: “ABBCD”, “APPLE”
//Output: True // A->A, B->P, C->L, D->E
//
//Input: “AAB”, “FOO”
//Output: False

public class Question11 {

	public static void main(String[] args) {
		String[] input1 = new String[] { "EGG", "FOO" };
		String[] input2 = new String[] { "ABBCD", "APPLE" };
		String[] input3 = new String[] { "AAB", "FOO" };

		System.out.println(solution(input1));
		System.out.println(solution(input2));
		System.out.println(solution(input3));

	}

	private static boolean solution(String[] input) {
		String before = input[0];
		String after = input[1];

		HashMap<Character, Character> map = new HashMap<>();
		
		for(int i = 0; i < before.length(); i++) {
			if(!map.containsKey(before.charAt(i))) {
				map.put(before.charAt(i), after.charAt(i));	
			} else {
				if(map.get(before.charAt(i)) != after.charAt(i)) {
					return false;
				}
			}
		}
		
		return true;
	}

}
