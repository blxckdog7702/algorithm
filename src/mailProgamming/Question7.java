package mailProgamming;

//주어진 string 에 모든 단어를 거꾸로 하시오.

//예제)
//Input: “abc 123 apple”
//Output: “cba 321 elppa”

public class Question7 {
	public static void main(String[] args) {
		String input = "abc 123 apple";
		
		String result = solution(input);
		
		System.out.println(result);
	}

	private static String solution(String input) {
		String[] words = input.split(" ");
		
		StringBuilder result = new StringBuilder();

		for(String word : words) {
			StringBuilder temp = new StringBuilder();
			temp.append(word);
			temp.reverse();
			result.append(temp.toString() + " ");
		}
		
		return result.toString().trim();
	}
}
