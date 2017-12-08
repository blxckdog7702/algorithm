package 기업대비5차;

/* 문제) 입력받은 숫자를 한글 구음으로 변환하여 Standard out으로 출력하는 프로그램을 만들고자 합니다. 
 PreTest.java라면, 아래와 같이 동작하도록 구현하시오. (입력값은 1 ~ 99999 의 정수에 한함.) */

// 재정의) 일만, 일천, 일백, 일십의 경우는 '일'을 빼고 출력하도록 구현하시오.

public class NhnTech {

	public static void main(String[] args) {
		// 입력 숫자
		int input = Integer.parseInt(args[0]);

		// 숫자 발음
		String[] numberPronArr = new String[] { "", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
		// 단위 발음
		String[] unitPronArr = new String[] { "", "십", "백", "천", "만" };
		// 결과
		StringBuilder result = new StringBuilder();

		// 몫
		int quot;
		// 현재 단위
		int unit;

		for (int i = 4; i >= 0; i--) {
			unit = (int) Math.pow(10, i);
			quot = input / unit;

			if (quot == 0) {
				continue;
			}

			// 일만 일천 일백 일십을 제외한 경우는 숫자 발음 기록
			if (quot == 1 && i != 0) {
			} else {
				result.append(numberPronArr[quot]);
			}

			//단위 발음 기록
			result.append(unitPronArr[i]);
			input -= quot * unit;
		}

		System.out.println(result.toString());
	}
}
