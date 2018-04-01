package line;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1 {

	/**
	 * Time complexity: Space complexity:
	 */
	public static void main(String[] args) throws Exception {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine().trim());

			for (int i = 0; i < T; ++i) {
				String word = br.readLine().trim();
				StringBuilder result = new StringBuilder();

				int j = 0;

				while (j < word.length()) {
					char current = word.charAt(j);
					int count = 1;

					while (j + 1 < word.length() && current == word.charAt(j + 1)) {
						j++;
						count++;
					}

					result.append(count + "" + current);

					j++;

				}

				System.out.println(result);

			}
		}
	}
}