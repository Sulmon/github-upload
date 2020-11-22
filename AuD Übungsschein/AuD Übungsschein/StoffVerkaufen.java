
public class StoffVerkaufen {
	// a) TO DO: This task is to recalculate and return the highest possible profit
	// recursively without further optimization.
	// This function is intended to find the best solution for cutting a piece of
	// rod of length "stoff",
	// and the rod of length i having a cost price of [i-1]

	public static long verkaufenNaive(Polizei p, int stoff, long[] preise) {

		p.kontrolle();
													
		if (stoff == 0)
			return 0;

		long maxProfit = 0;
		for (int i = 1; i <= stoff; i++) {
		
			int neueStoffLaenge = stoff - i;
			int stoffTeilLaenge = stoff - neueStoffLaenge - 1;
			
			if (stoffTeilLaenge >= preise.length) {
				continue;
			}
			
			long neuerStoffPreis = verkaufenNaive(p, neueStoffLaenge, preise);
			long neuerStoffTeilPreis = preise[stoffTeilLaenge];
			long neuerPreis = neuerStoffTeilPreis + neuerStoffPreis;
			
			if (maxProfit < neuerPreis) {
				maxProfit = neuerPreis;
			}
		}
		
		return maxProfit;
	}
	
// b) TO DO: This task is now to be solved iteratively by means of dynamic programming by filling a method-local memoization field (bottom-up).

	public static long verkaufenDP(Polizei p, int stoff, long[] preise) {
		p.kontrolle();
		
		// maxProfit[i] stores maximum profit achieved from rod of length i
		long[] results = new long[stoff + 1];

		// consider rod of length i
		for (int i = 1; i <= stoff; i++) {

			long maxProfit = Long.MIN_VALUE;

			// divide the rod of length i into two rods of length j
			// and i-j each and take maximum
			for (int j = 1; j <= i; j++) {
				
				int neueStoffLaenge = stoff - j;
				int stoffTeilLaenge = stoff - neueStoffLaenge - 1;
				
				if (j - 1 >= preise.length) {
					continue;
				}
				
				long neuerStoffPreis = results[i - j];
				long neuerStoffTeilPreis = preise[j - 1];
				long neuerProfit = neuerStoffTeilPreis + neuerStoffPreis;
				
				if (maxProfit < neuerProfit) {
					maxProfit = neuerProfit;
				}
			}
			results[i] = maxProfit;
		}

		// maxProfit[stoff] stores maximum profit achieved from rod of length stoff
		return results[stoff];
	}
	
}
