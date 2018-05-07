package line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4 {
	private static final int SIZE = 1000000;
	/**
	 * Time complexity: Space complexity:
	 */
	long[] arr = new long[1000001];
	long[] inv = new long[1000001];
	static long mod = 1003001;

	public static void main(String[] args) throws IOException {
		Q4 main = new Q4();
		main.init();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			final int T = Integer.parseInt(br.readLine().trim());

			for (int i = 0; i < T; i++) {
				final StringTokenizer tokenizer = new StringTokenizer(br.readLine().trim());
				int N = Integer.parseInt(tokenizer.nextToken());
				int K = Integer.parseInt(tokenizer.nextToken());
				int M = Integer.parseInt(tokenizer.nextToken());
				
				long sticker = main.func(N, M);
				long theme = main.func(N, K - M);
				long result = (sticker * theme) % mod;

				System.out.println(result);
			}
		}
	}

	public void init() {
		arr[1] = 1;
		for (int i = 2; i <= SIZE; i++)
			arr[i] = (arr[i - 1] * i) % mod;

		inv[SIZE] = calc(arr[SIZE], mod - 2);
		for (int i = SIZE - 1; i > 0; i--)
			inv[i] = (inv[i + 1] * (i + 1)) % mod;
	}

	public long calc(long x, long y) {
		long result = 1;
		while (y > 0) {
			if (y % 2 > 0) {
				result *= x;
				result %= mod;
			}
			x *= x;
			x %= mod;
			y /= 2;
		}

		return result;
	}

	long func(int N, int K) {
		long result;
		if ((N == K) || (K == 0)) {
			return 1;
		}

		result = (arr[N] * inv[N - K]) % mod;
		result = (result * inv[K]) % mod;
		return result;
	}
}
