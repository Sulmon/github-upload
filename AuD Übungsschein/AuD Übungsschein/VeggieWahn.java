
public class VeggieWahn {
	public static long essen(int v, int g) {

		long[][] meal = new long[124][124];
		return 2 * spices(v, g, meal);

	}

	public static long spices(int v, int g, long[][] meal) {

		if (meal[v][g] != 0) {
			return meal[v][g];
		}

		if (v == g) {
			return 1;
		}
		if (v == 1) {
			return 1;

		} else {

			meal[v][g] = spices(v - 1, g - 1, meal) + v * spices(v, g - 1, meal);
			return meal[v][g];

		}

	}
}