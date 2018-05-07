package 백준.문자열;

import java.util.StringTokenizer;

public class CountCharInWordTest {

	public static void main(String[] args) {
		String str = "I love yoou";
		
		//StringTOkenizer로는 정확하게 단어 개수를 셀 수없다.
		//split도 마찬가지
		StringTokenizer st = new StringTokenizer(str, "o");
		System.out.println(st.countTokens());
		
		String word = "I love you".toLowerCase();
		
		int count = word.length() - word.replace("o", "").length();
		System.out.println(count);
	}

}
