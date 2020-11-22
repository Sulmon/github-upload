public class Tribonacci {

	public static long delannoyNaive(TriboCheck tc, int n, int k) {
		tc.checkTribo();

		if (n == 0 || k == 0) {
			return 1;
		}

		return delannoyNaive(tc, n - 1, k) + delannoyNaive(tc, n - 1, k - 1) + delannoyNaive(tc, n, k - 1);
	}

	public static long delannoyMem(TriboCheck tc, int n, int k, long[][] mem) {
		tc.checkTribo();

		if (mem == null) {

			return delannoyMem(tc, n, k, new long[n + 1][k + 1]);
		}

		if (n == 0 || k == 0) {
			return 1;
		}

		if (mem[n][k] != 0) {
			return mem[n][k];
		}

		mem[n][k] = delannoyMem(tc, n - 1, k, mem) + delannoyMem(tc, n - 1, k - 1, mem) + delannoyMem(tc, n, k - 1, mem);

		return mem[n][k];
	}

	public static long delannoyDP(TriboCheck tc, int n, int k) {
		tc.checkTribo();

		int mem[][] = new int[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			mem[i][0] = 1;
		}
		for (int i = 0; i <= k; i++) {
			mem[0][i] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {

				mem[i][j] = mem[i - 1][j] + mem[i - 1][j - 1] + mem[i][j - 1];
			}
		}

		return mem[n][k];
	}
}
