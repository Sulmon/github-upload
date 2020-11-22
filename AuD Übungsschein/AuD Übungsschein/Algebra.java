public class Algebra {

//
//    private Algebra mathe; // Bei der Syntax kommt <> immer hinter den Namen. (Variablendeklaration)
//    private Nat zahl;
//    private Liste liste;

	public static Nat modulo(Nat x, Nat y) {

		return Nat.sub(x, (Nat.mul((Nat.div(x, y)), y)));
	}

	public static Nat kleiner(Nat x, Nat y) {

		return Nat.sub(x, y) == Nat.zero() && Nat.sub(Nat.succ(x), y) == Nat.zero() ? Nat.succ(Nat.zero()) : Nat.zero();
	}

	public static Nat gleich(Nat x, Nat y) {

		return Nat.sub(x, y) == Nat.zero() && Nat.sub(y, x) == Nat.zero() ? Nat.succ(Nat.zero()) : Nat.zero();
	}

	public static Nat groesser(Nat x, Nat y) {
		return Nat.sub(y, x) == Nat.zero() && Nat.sub(Nat.succ(y), x) == Nat.zero() ? Nat.succ(Nat.zero()) : Nat.zero();
	}

	public static Nat ggt(Nat x, Nat y) {
		Nat zahl1 = x;
		Nat zahl2 = y;
		while (zahl2 != Nat.zero()) {
			if (Algebra.groesser(zahl1, zahl2) != Nat.zero()) {
				zahl1 = Nat.sub(zahl1, zahl2);
			} else {
				zahl2 = Nat.sub(zahl2, zahl1);
			}
		}
		return zahl1;
	}

	public static Nat kgv(Nat x, Nat y) {
		Nat o = ggt(x, y);
		return Nat.div(Nat.mul(x, y), o);
	}

	public static Liste pfz(Nat number) {
		Nat n = number;
		Liste<Nat> factors = new Liste<>();
		for (Nat i = Nat.succ(Nat.succ(Nat.zero())); Algebra.kleiner(i, n) != Nat.zero()
				|| Algebra.gleich(i, n) != Nat.zero()/* i <= n */; i = Nat.succ(i)) {
			while (Algebra.modulo(n, i) == Nat.zero()) {
				factors = Liste.vorne(factors, i);
				n = Nat.div(n, i);
			}
		}

		// invert list
		Liste<Nat> fuckingSortedFactors = Liste.neu();
		Liste<Nat> list = factors;
		Nat nextElement = Liste.kopf(list);
		while (nextElement != null) {
			fuckingSortedFactors = Liste.vorne(fuckingSortedFactors, nextElement);
			list = Liste.rest(list);
			nextElement = Liste.kopf(list);
		}
		return fuckingSortedFactors;
	}

	private static Liste pfzH(Nat x, Nat y) {

		return null;
	}
}