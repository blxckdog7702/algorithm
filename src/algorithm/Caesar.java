package algorithm;

public class Caesar {
	String caesar(String s, int n) {
		
		if(n > 26) {
			n = n % 26;
		}
		
		char[] arr = s.toCharArray();
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != ' ') {
				if(arr[i] >= 65 && arr[i] <= 90) {
					if(arr[i] + n > 90 ) {
						arr[i] = (char) (arr[i] + n - 26);
					} else {
						arr[i] = (char) (arr[i] + n);
					}
				} else if(arr[i] >= 97 && arr[i] <= 122) {
					if(arr[i] + n > 122) {
						arr[i] = (char) (arr[i] + n - 26);
					} else {
						arr[i] = (char) (arr[i] + n);
					}
				}
			}
		}
		String result = String.valueOf(arr);
		// 함수를 완성하세요.

		return result;
	}

	public static void main(String[] args) {
		Caesar c = new Caesar();
		System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("a B z", 4));
	}
}
